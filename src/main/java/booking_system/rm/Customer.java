package booking_system.rm;

import java.time.LocalDate;

public class Customer {

    private int customerID;

    private String nameTitle;

    private String firstName;

    private String lastName;

    private String gender;

    private String email;

    private LocalDate DoB;

    private String membershipTier;

    public Customer(int customerID, String nameTitle, String firstName, String lastName, String gender, String email, LocalDate doB, String membershipTier) {
        this.customerID = customerID;
        this.nameTitle = nameTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.DoB = doB;
        this.membershipTier = membershipTier;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", nameTitle='" + nameTitle + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", DoB=" + DoB +
                ", membershipTier='" + membershipTier + '\'' +
                '}';
    }
}
