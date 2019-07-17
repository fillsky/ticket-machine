package main;

import java.util.TimerTask;

public class QueueTimer extends TimerTask {

    private Desk desk;


    public QueueTimer(Desk desk) {
        this.desk = desk;

    }

    @Override


    public void run() {
        System.out.println("Kończenie bieltu " + desk.getTicket().getTicketID());
        desk.closeTicket();
    }
}
