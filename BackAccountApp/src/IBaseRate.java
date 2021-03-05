/**
 * Author: Adam C Wojdyla
 * Description: Bank Account Application
 * Personal Project
 */

public interface IBaseRate {

    /**
     * Interface method
     * @return - the current base rate
     */
    default double getBaseRate() {
        return 2.5;
    }

}
