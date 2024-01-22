package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstname;
    private String lastname;
    private int yearOfStudy;
    private String studentID;
    private static int idCount = 1000;
    private String courses = "";
    private double tuitionBalance;
    private double courseRate = 6000;

    // Constructor - prompt user to enter student's name and year
    public Student()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Capturing student's details");
        System.out.print("Enter firstname: ");
        this.firstname = input.nextLine();
        System.out.print("Enter lastname: ");
        this.lastname = input.nextLine();
        System.out.print("Enter Year of Study: ");
        this.yearOfStudy = input.nextInt();

        setStudentID();
//        System.out.println("========== Summary ==========");
//        System.out.println("Name: "+firstname + " " + lastname);
//        System.out.println("Year of Study:  " + yearOfStudy);
//        System.out.println("Student ID: " + studentID);

    }

    // Generate student ID\
    public void setStudentID()
    {
        idCount++;
        this.studentID = yearOfStudy + "" + idCount;
    }

    // Enroll in courses
    public void enroll()
    {
        // Loop quits when user enters the 0 digit
        System.out.println("***** Available Courses *****");
        String string = " HST"+ yearOfStudy +"01 - History "+ yearOfStudy + "01\n MAM"+ yearOfStudy + "01 - Mathematics "+ yearOfStudy + "01\n ENG" + yearOfStudy + "01 - English " +yearOfStudy +"01\n CHEM" + yearOfStudy + "01 - Chemistry " + "01\n CSC" + yearOfStudy +"01 - Computer Science "+ yearOfStudy +"01";
        System.out.println(string);

        do {
            System.out.println("Enter Course Code to enroll (Q to quit):");
            Scanner userOption = new Scanner(System.in);
            String courseCode = userOption.nextLine();

            if ((courseCode).equalsIgnoreCase("q"))
            {
                break;
            }
            else {
                courses = courses + "\n" + "  " +courseCode;
                tuitionBalance = tuitionBalance + courseRate;
            }

        }
        while (true);
//        System.out.println("========== Summary ==========");
//        System.out.println("Name: "+firstname + " " + lastname);
//        System.out.println("Year of Study:  " + yearOfStudy);
//        System.out.println("Student ID: " + studentID);
//        System.out.println("Course Enrolled: " + courses);
//        System.out.println("Tuition Balance: " + tuitionBalance);
    }

    // View balance
    public void viewBalance()
    {
        System.out.println("Balance is: R" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition(double payment)
    {
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for you payment of R" + payment);
        viewBalance();
    }

    // Show status
    public String toString()
    {

        return  "========== Summary ==========\n" +
                "Name: "+firstname + " " + lastname + "\n" +
                "Year of Study:  " + yearOfStudy + "\n" +
                "Student ID: " + studentID + "\n" +
                "Course Enrolled: " + courses + "\n" +
                "Tuition Balance: " + tuitionBalance;
    }

}
