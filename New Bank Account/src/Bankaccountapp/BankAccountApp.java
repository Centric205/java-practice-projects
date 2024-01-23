package Bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args){
        // TODO: Auto-generated method stub
        List<Account> accountList = new LinkedList<Account>();
        String filename = "/home/user/Documents/Fun Projects/java-practice-projects/New Bank Account/NewBankAccounts.csv";
/**
        Checking checking = new Checking("Theo Madikgetla", "324928743", 1500);

        Savings savings = new Savings("Centric", "495729418", 2500);

        checking.showInfo();
        System.out.println("*****************************");
        savings.showInfo();
        savings.deposit(5000);
        savings.withdraw(200);
        savings.transfer("GOLD MINE", 3000);
        savings.compound();
**/
        // Read a CSV file then create new accounts based on that data
        List<String []> newAccountHolders = utilities.CSV.read(filename);
        for (String[] accountHolder : newAccountHolders){
                String name  = accountHolder[0];
                String sSN = accountHolder[1];
                String accountType = accountHolder[2];
                double initDeposit = Double.parseDouble(accountHolder[3]);
                //System.out.println(name + " " + sSN + " " + accountType + " " + initDeposit);

                if (accountType.equals("Savings"))
                {
                    accountList.add(new Savings(name, sSN, initDeposit));
                } else if (accountType.equals("Checking")) {
                    accountList.add(new Checking(name, sSN, initDeposit));
                }
                else {
                    System.out.println("ERROR READING ACCOUNT TYPE");
                }
        }
        for (Account account : accountList){
            account.showInfo();
        }
    }
}
