package main;

import java.util.List;

public class Department {

    private String departmentID;
    private List<Desk> desks;

    public Department(String departmentID, List<Desk> desks) {
        this.departmentID = departmentID;
        this.desks = desks;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public List<Desk> getDesks() {
        return desks;
    }
    public int deskCount(){
        return desks.size();
    }
}
