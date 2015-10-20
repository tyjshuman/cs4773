package assign3;

/**
 * CREATOR pattern used for this class. The main controller class calls on this
 * class to create a transaction for every new deposit which is then passed back
 * to the main controller
 * 
 * @author tyjshuman
 *
 */
public class TransactionController {
	ChecksToClear checksToClear = new ChecksToClear();

	public TransactionController() {
	}

	/**
	 * called by the main controller when there is a new check deposit
	 * 
	 * @param check
	 *            instance of check being deposited
	 * @return a new transaction instance
	 */
	public Transaction newCheck(Check check) {
		Transaction t = new Transaction(check);
		return t;
	}

}
