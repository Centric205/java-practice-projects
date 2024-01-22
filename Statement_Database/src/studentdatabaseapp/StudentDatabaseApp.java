package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main (String[] args)
    {
        Student student = new Student();
        student.enroll();
        student.payTuition(500);
        System.out.println(student);


        // Displays option to user
        System.out.println("What would like to do?");
        System.out.println("1. Update Details \n2. Enroll for Course \n3. View Tuition Balance \n4. Make Payment \nQ - Quit");
        Scanner selection = new Scanner(System.in);

        if (selection.nextInt() == 1)
        {

        } else if (selection.nextInt() == 2) {
            student.enroll();
        } else if (selection.nextInt() == 3) {
            student.viewBalance();
        } else if (selection.nextInt() == 4) {
            System.out.print("How much do you wanna pay?: ");
            double amount = selection.nextInt();
            student.payTuition(amount);
        } else if (selection.nextLine().equalsIgnoreCase("Q")) {
            System.exit(0);
        }
    }
}
