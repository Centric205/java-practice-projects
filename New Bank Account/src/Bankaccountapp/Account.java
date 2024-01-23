package Bankaccountapp;

/**
 * @class: Account
 *  - It abstract, and so won't be able to create objects from this class.
 */

public abstract class Account implements IRate {
    // List common properties for savings and checking accounts
    String name;
    String sSN;
    double balance;
    String accountNumber;
    double rate;
    static int index = 10000;

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
            this.name = name;
            this.sSN = sSN;
            balance = initDeposit + 100;

            // Set account number
            this.accountNumber = setAccountNumber();

    }
    // List common methods

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: R" + accruedInterest);
        printBalance();
    }

    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing R" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing R" + amount);
        printBalance();
    }

    public void transfer(String destination,double amount){
        balance = balance - amount;
        System.out.println("Transferring $" + amount + " to " + destination);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }


    public abstract void setRate();

    private String setAccountNumber(){
        return sSN.substring(sSN.length() - 2) + index + ((int) (Math.random() * Math.pow(10, 3)));
    }

    public void showInfo(){
        setRate();
        System.out.println("======================================");
        System.out.println("NAME: " + name +
                           "\nACCOUNT NUMBER: " + accountNumber +
                           "\nBALANCE: " + balance +
                           "\nRATE: " + rate + "%");

    }

}
