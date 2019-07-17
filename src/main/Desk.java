package main;

import java.util.Timer;


public class Desk {

    private boolean isOpen;
    private boolean isBusy;
    private String deskID;
    private Display display;
    private Ticket ticket;
    Timer timer = new Timer();


    public Desk(String deskID) {

        this.deskID = deskID;
        display = new Display();
        isOpen = true;
    }

    public void callTicket(Ticket ticket) {
        this.ticket = ticket;
        System.out.println( deskID + " zaprasza: " + ticket.getTicketID());
        isBusy = true;
        display.displayCurrent(ticket);
        QueueTimer queueTimer  = new QueueTimer(this);
        timer.schedule(queueTimer, (int)(Math.random()*5000));

    }


    public void closeTicket() {


        if (isBusy){

            ticket.setFinished(true);
            isBusy = false;
        } else {
            System.out.println("Nic nie robie" + this.deskID);
        }


    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public String getDeskID() {
        return deskID;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
