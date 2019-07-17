package main;

import java.util.ArrayList;
import java.util.List;

public class Setup {

    final public static int ticketMachineCount = 2;
    final public static int departmentCount = 8;
    final public static int deskCount = 40;


    public static List<Desk> desks = new ArrayList<>();
    public static List<Department> departments = new ArrayList<>();


    public static void start(){


    }

    public static List<Desk> createDesks(int value, String signature) {

        List<Desk> d = new ArrayList<>();
        for (int i = 0; i < value; i++) {
            d.add(new Desk(signature + i));
        }

        return d;
    }

    public static List<Department> createDepartments() {
        departments.add(new Department("SC_", createDesks(5,"sc")));
        departments.add(new Department("MC_", createDesks(6,"mc")));
        departments.add(new Department("GB_", createDesks(4,"gb")));
        departments.add(new Department("Z0_", createDesks(3,"z0")));
        departments.add(new Department("ZA_", createDesks(7,"za")));
        departments.add(new Department("ZB_", createDesks(2,"zb")));
        departments.add(new Department("ZC_", createDesks(8,"zc")));
        return departments;
    }



}
