package Bankaccountapp;

public class Savings extends Account{
    // List properties specific to the Savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize settings for the Savings properties
    public Savings (String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    // List any methods specific to savings account
    private void setSafetyDepositBox()
    {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 3));

    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                "Your Savings Account Features" +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey);
    }
}
