package Bankaccountapp;

public class Checking extends Account{
    // List properties specific to a Checking account
    private int debitCardNumber;
    private int debitCardPIN;

    // Constructor to initialize checking Account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
    }

    // List any methods specific to the checking account
    public void setRate(){
        rate = getBaseRate() * 0.15;
    }

    private void setDebitCard(){
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                "Your Checking Account Features" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card PIN " + debitCardPIN);
    }
}
