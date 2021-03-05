/**
 * Author: Adam C Wojdyla
 * Description: Bank Account Application
 * Personal Project
 *
 * child class
 * Extends - Inherits properties from Account.java class
 */

public class Savings extends Account {
    //list properties specific to the savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    /**
     * Constructor
     *
     * @param name        - Customer Name
     * @param sSN         - Social Security Number
     * @param initDeposit - Initial Deposit
     *                    super() method calls Constructor from Parent class
     */
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    /**
     * Method
     * Inherited from the Parent class
     * Changes the Savings base rate.
     */
    @Override
    public void setRate() {
        rate = rate = getBaseRate() - .25;
    }

    /**
     * Creates a random 3 digit safety deposit box ID
     * Creates a random 4 digit safety deposit key
     */
    private void setSafetyDepositBox() {
        safetyDepositBoxID = numberGenerator(3);
        safetyDepositBoxKey = numberGenerator(4);

    }

    /**
     * Polymorphism - Overrides showInfo() method in parent class.
     * Displays debit card number and debit card pin.
     * Super() method calls the showInfo() method from the parent class
     */
    public void showInfo() {
        super.showInfo();
        System.out.println("Your savings Account Features:" +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey);
    }
}
