package assign3;

/**
 * Account object used to store all relevent account information.
 * 
 * @author tyjshuman
 *
 */
public class Account {
	private int accountNumber;
	private int routingNumber;
	private double balance;
	private int ownerID;
	private String ownerFullName;
	private String accountType;

	public Account(int accountNumber, int routingNumber, int memberID) {
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.ownerID = memberID;
	}

	public Account(int accountNumber, int routingNumber, String memberFullName) {
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.ownerFullName = memberFullName;
	}

	public Account(int accountNumber, int routingNumber, double initialBalance, int memberID) {
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.ownerID = memberID;
		this.setBalance(initialBalance);
	}

	public Account(int accountNumber, int routingNumber, double initialBalance, String memberFullName) {
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.ownerFullName = memberFullName;
		this.setBalance(initialBalance);
	}

	public String getOwnerName() {
		return ownerFullName;
	}

	public void setFullName(String name) {
		this.ownerFullName = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getID() {
		return accountNumber;
	}

	public void setID(int ID) {
		accountNumber = ID;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * this method is called by the accountDB and then the account balance is
	 * updated depending on the type of transaction
	 * 
	 * @param type
	 *            deposit or withdraw
	 * @param t
	 *            the transaction to be applied to the account
	 */
	public void applyTransaction(String type, Transaction t) {
		if (type.equals("deposit"))
			balance += t.getAmount();
		if (type.equals("withdraw")) {
			balance -= t.getAmount();
		}
	}

}
