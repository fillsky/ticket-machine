package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Ticket {

    private static int ticketCounter = 0;
    private String ticketID;// ID = nazwa departamentu plus kolejny numer w kolejce danego dnia;


    private boolean isFinished;
    private boolean isAssigned;

    private LocalDateTime dateTime;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy, HH:mm:ss");
    private TicketMachine ticketMachine;
    private Department department;
    private Desk desk;


    public Ticket(TicketMachine ticketMachine, Department department) {
        this.ticketMachine = ticketMachine;
        this.department = department;
        isFinished = false;
        isAssigned = false;
        dateTime = LocalDateTime.now();
        ticketID = department.getDepartmentID() + ticketMachine.ticketNumber(department);
        ticketCounter++;
        printTicket();


    }


    private void printTicket() {

        System.out.println("\n--- BILET ---");
        System.out.println("Numerek: " + ticketID + "W depaertamecie: " + department.getDepartmentID());
        System.out.println("Ilość osobó w kolejce: " + ticketMachine.queSize(department));
        System.out.println("Data: " + dateTime.format(dateTimeFormatter));

        System.out.println("------------------\n");
       try {
            assignTicket();
        } catch (InterruptedException e) {
            System.out.println("Błąd przypisania biletu " + e.getLocalizedMessage());

        }
       //ticketMachine.testMethod();
        //data, godzina
        //numer stanowiska
        //wydzial.nr biletu
        // ilosc osob w kolejce
    }

    private void assignTicket() throws InterruptedException {



        if (ticketMachine.queSize(department) >= department.deskCount()) { //check if queue is longer then avaiable desks;
            System.out.println("Wszystkie stanowiska zajęte ");
            TimeUnit.SECONDS.sleep(3);
            assignTicket(); // try to assign again after some time delay (so it don't spam),
                            // i must work on better solution since this blocks entire queue
                            //even if next tickets in queue are for different departments and having free desks.
                            // Maybe TicketAssigner class?
        } else {
            for (Desk departmentDesk : department.getDesks()) {
                if (!departmentDesk.isBusy() && departmentDesk.isOpen() && !this.isAssigned) { //checking for each desk in given department for free desk if ticket is unassigned;
                    this.desk = departmentDesk; // assigning first found desk to ticket
                    System.out.println("Bilet: " + this.ticketID
                            + " przypisany do stanowaiska "
                            + departmentDesk.getDeskID());
                    isAssigned = true;
                    departmentDesk.callTicket(this);
                    break;
                }
            }
        }
    }



    public void setFinished(boolean finished) {
        isFinished = finished;
    }


    public Department getDepartment() {
        return department;
    }

    public String getTicketID() {
        return ticketID;
    }


    public Desk getDesk() {
        return desk;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }
}
