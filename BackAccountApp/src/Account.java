/**
 * Author: Adam C Wojdyla
 * Description: Bank Account Application
 * Personal Project
 *
 *
 * parent class/super class (gets called first)
 * Abstract - Unable to create objects from account class
 * Implements - IbaseRate.java have properties in this account class
 * Private - These properties are not accessed in other classes
 * Protected - These properties are accessed inside checking and savings through the super class
 */

import java.util.Random;

public abstract class Account implements IBaseRate {
    protected String accountNumber;
    private double balance;
    private static int index = 10000;
    // List of properties shared in savings and checking accounts
    private final String name;
    protected double rate;
    private final String sSN;


    /**
     * Constructor
     * @param name        - Customer name.
     * @param sSN         - Social Security Number.
     * @param initDeposit - Initial account deposit.
     */
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;

        // set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();

    }

    /**
     * Interface method
     * Checking/Savings.java implement this method.
     */
    public abstract void setRate();

    /**
     * Method
     * Checking = 1 ,Savings = 2
     * @return number 1or2 + SSN + 5 digit number + 3 Digit number = 11 digit account number
     */
    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * (999 - 100) + 100); // random # generated from 0-899 + 100
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    /**
     * Method
     * @param length - length of digit to be generated
     * @return - an integer number
     */
    public int numberGenerator(int length){
        int finalint = 0;
        Random random = new Random();
        int[] number = new int[length];
        for (int i = 0; i < number.length-1; i++) {
            number[i] = (random.nextInt(9) + 1);
        }
        for (int i = 0; i < number.length; i++) {
            finalint = finalint * 10;
            finalint = finalint + number[i];
        }
        return Math.abs(finalint);
        }


    /**
     * Method
     * Calculates the compound interest rate
     */
    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    /**
     * Method
     * @param amount - dollar amount to be deposited into account
     */
    public void deposit(double amount) {
        balance = balance + amount;
        printBalance();
    }

    /**
     * Method
     * @param amount - dollar amount to be withdrawn from account
     */
    public void withdraw(double amount) {
        balance = balance - amount;
        printBalance();
    }

    /**
     * Method
     * @param transferTo - destination of money transfer (to what account).
     * @param amount     - amount to be transferred to destination account.
     */
    public void transfer(String transferTo, double amount) {
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + transferTo);
        printBalance();
    }

    /**
     * Method
     * Displays to console the current account balance.
     */
    public void printBalance() {
        System.out.println("Your new Balance is now: " + balance);
    }

    /**
     * Method
     * Displays to console the Account name, Number, Balance and Rate.
     */
    public void showInfo() {
        System.out.println("NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + rate + "%");


    }

}
