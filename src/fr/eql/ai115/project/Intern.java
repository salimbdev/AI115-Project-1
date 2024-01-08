package fr.eql.ai115.project;


public class Intern {

    private String lastName;
    private String firstName;
    private String promotion;
    private int department;
    private int year;
    private int childNodeLeftPointer;
    private int childNodeRightPointer;

    public Intern() {
    }

    public Intern(String lastName, String firstName, String promotion, int department, int year) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.promotion = promotion;
        this.department = department;
        this.year = year;
    }

}
