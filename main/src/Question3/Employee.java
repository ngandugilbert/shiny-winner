package Question3;

public class Employee{
    private final String firstName;
    private final String lastName;
    private final int socialSecurityNumber;

    public Employee(String firstName, String lastName, int socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // get firstName
    public String getFirstName(){
        return this.firstName;
    }

    // get lastName
    public String getLastName(){
        return this.lastName;
    }

    // get socialSecurityNumber
    public int getSocialSecurityNumber(){
        return this.socialSecurityNumber;
    }

    // // get earnings
    // public double earnings(){
    //     return
    // }

    @Override
    public String toString(){
        return String.format("First Name: %s%nLast Name: %s%nSocial Security Number: %d%n", getFirstName(), getLastName(), getSocialSecurityNumber());
    }
}