/**
 * Author: Adam C Wojdyla
 * Description: Bank Account Application
 * Personal Project
 * <p>
 * Created a simple Bank Account Application that uses the fundamentals of OOP
 * through data structures, abstraction, inheritance and polymorphism.
 * <p>
 * <p>
 * Created a Super class(Parent Class) with two child classes and one interface.
 * The parent class(Account.java) gives inheritance to the Child classes (Checking/Savings.java).
 * The interface (IbaseRate.java) is used in both child classes and implemented in Account.java.
 */


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class BankAccountApp {
    public static void main(String[] args) throws IOException {
        List<Account> accounts = new LinkedList<>();

        //read a csv file and create new accounts based on the data
        List<String[]> newAccountHolder = CSV.read("NewBankAccounts.csv");
        for (String[] account : newAccountHolder) {
            String name = account[0];
            String sSN = account[1];
            String accountType = account[2];
            double initBalance = Double.parseDouble(account[3]);

            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initBalance));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initBalance));
            } else {
                System.out.println("ACCOUNT TYPE ERROR");
            }
        }
        for (Account acc : accounts) {
            System.out.println("****************");
            acc.showInfo();
        }

    }
}
