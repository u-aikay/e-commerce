package Model;


import enums.Designation;

public class Admin extends Person {

    private String staffId;

    public Admin(String firstName, String lastName, String address){
                super(firstName, lastName, address, Designation.STAFF);
    }

    public String getStaffId(){return staffId;}
    public void setStaffId (String newStaffId){staffId = newStaffId;}

}