package emailapp;

import java.util.Scanner;

public class Email {

    private String companySuffix = "glow.com";
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;

    // Constructor to receive first and last name on object creation
    public Email(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("Email created: " + this.firstname + " " + this.lastname);

        // Call a method asking for the department - It returns the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call randomPassword method and retrieve password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Concatenate fistname, lastname, and department to generate email address
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase() + companySuffix;
        System.out.println("Your email is: " + email);

    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("Enter the department digit:");
        System.out.println("1 -> Sales");
        System.out.println("2 -> Development");
        System.out.println("3 -> Accounting");
        System.out.println("0 -> None");
        System.out.print("$ ");


        // Receive user input
        Scanner input = new Scanner(System.in);
        int department_digit = input.nextInt();

        // Conditional statements to determine which choice was made
        if (department_digit == 1)
        {
            return "Sales";
        }
        else if (department_digit == 2)
        {
            return "Development";
        }
        else if (department_digit == 3)
        {
            return "Accounting";
        }
        else
        {
            return "";
        }

    }

    // Generate a random password
    private String randomPassword(int length)
    {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWSYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++)
        {
            int rand  = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void setPassword(String password) {
        this.password = password;
    }

    // Get the mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Get alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Get password
    public String getPassword() {
        return password;
    }

    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }

    public String getEmail(){
        return email;
    }

    public String getDepartment() {
        return department;
    }

    // Display user details
    public void showInfo(){
        System.out.println("============== User Details ===============");
        System.out.println("Name: " + getFirstname() + " " + getLastname());
        System.out.println("Company Email: " + getEmail());
        System.out.println("Alternate Email: " + getAlternateEmail());
        System.out.println("Mailbox Capacity:" + getMailboxCapacity());
        System.out.println("Department: " + getDepartment());
        System.out.println("===========================================");

    }
}
