package main;

public class Display {

    private Ticket ticket;



    public void displayCurrent(Ticket ticket){
        System.out.println("\t [DISPLAY]-> Obecnie numer " + ticket.getTicketID());

    }


}
