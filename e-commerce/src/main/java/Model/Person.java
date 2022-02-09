package Model;

import enums.Designation;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String address;
    private Designation designation;


    public Person(String firstName, String lastName, String address, Designation designation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.designation = designation;
    }


    public String getFirstName(){return firstName;}
    public void setFirstName(String name){firstName = name;}
    public String getLastName(){return  lastName;}
    public void setLastName(String surname){lastName = surname;}
    public String getAddress(){return address;}
    public void setAddress(String customerAddress){address = customerAddress;}
}
