package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketMachine {

    private String ticketMachineID;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Department> departments;


    public TicketMachine(List<Department> departments) {
        this.departments = departments;
        //ticketMachineID

    }


    public void createTicket(Department department) {

        Ticket ticket = new Ticket(this, department);
        tickets.add(ticket);


    }

    public int queSize(Department department) {

        int sum = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getDepartment().getDepartmentID().equals(department.getDepartmentID())
                    && !ticket.isFinished()) {
                sum++;
            }
        }
        return sum;
    }

    public int ticketNumber(Department department) {


        int sum = 0;
        for (Ticket ticket : tickets) {

            if (ticket.getDepartment().getDepartmentID().equals(department.getDepartmentID())) {
                sum++;

            }
        }
        return sum;
    }

    public void testMethod() {


        departments.forEach(department-> tickets.forEach(ticket ->{
            if (!ticket.isAssigned()){
                while (queSize(department) >= department.deskCount()){

                    System.out.println("Wszystkie stanowiska zajęte ");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    department.getDesks().forEach(desk -> {
                        if (!desk.isBusy() && desk.isOpen() && !ticket.isAssigned()){
                            ticket.setDesk(desk);
                            System.out.println("Bilet: " + ticket.getTicketID()
                                    + " przypisany do stanowaiska "
                                    + desk.getDeskID());
                            ticket.setAssigned(true);
                            desk.callTicket(ticket);
                            //break;
                        }
                    });
                }
            }

            }));
    }

    public String getTicketMachineID() {
        return ticketMachineID;
    }
}
