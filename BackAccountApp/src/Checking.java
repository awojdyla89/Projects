/**
 * Author: Adam C Wojdyla
 * Description: Bank Account Application
 * Personal Project
 *
 * child class
 * Extends - Inherits properties from Account.java class
 */

public class Checking extends Account {
    //Properties specific to the checking account
    private int debitCardNumber;
    private int debitCardPin;


    /**
     * Constructor
     *
     * @param name        - Customer name.
     * @param sSN         - Social Security Number.
     * @param initDeposit - Initial Deposit.
     *                    super() method calls the constructor from Parent class
     */
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    /**
     * Method
     * Inherited from the Parent class
     * Changes the Checking base rate by 15%
     */
    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    /**
     * Method
     * creates a random 12 digit credit card number
     * Creates a random 4 digit pin number
     */
    private void setDebitCard() {
        debitCardNumber =  numberGenerator(12);
        debitCardPin = numberGenerator(4);

    }

    /**
     * Polymorphism - Overrides showInfo() method in parent class.
     * Displays debit card number and debit card pin.
     * Super() method calls the showInfo() method from the parent class
     */
    public void showInfo() {
        super.showInfo();
        System.out.println("Your Checking Account Features: " +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card PIN: " + debitCardPin);
    }

}
