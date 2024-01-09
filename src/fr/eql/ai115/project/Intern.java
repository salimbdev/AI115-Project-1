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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getChildNodeLeftPointer() {
        return childNodeLeftPointer;
    }

    public void setChildNodeLeftPointer(int childNodeLeftPointer) {
        this.childNodeLeftPointer = childNodeLeftPointer;
    }

    public int getChildNodeRightPointer() {
        return childNodeRightPointer;
    }

    public void setChildNodeRightPointer(int childNodeRightPointer) {
        this.childNodeRightPointer = childNodeRightPointer;
    }
}
