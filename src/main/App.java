package main;


import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {


        List<Department> departments = Setup.createDepartments();
        TicketMachine ticketMachine = new TicketMachine(departments);

        Scanner sc = new Scanner(System.in);
        int input = 0;
        System.out.println(ticketMachine.getTicketMachineID());
        //while (input != 9) {
        input = sc.nextInt();
        for (int i = 0; i < input; i++) {


            ticketMachine.createTicket(departments.get(1));

        }


    }
}
