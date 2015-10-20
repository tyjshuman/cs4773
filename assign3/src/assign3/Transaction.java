package assign3;

/**
 * A transaction class. one instance is created per deposit and the accounts are
 * updated in the controller class
 * 
 * @author tyjshuman
 *
 */
public class Transaction {
	private double amount;
	private int ToAccountID;
	private String toName;
	private int accountFrom;
	private int routingNumber;
	private Check check;
	private int transactionID = 0;

	public Transaction(Check check) {
		this.check = check;
		amount = check.getAmount();
		toName = check.getTo();
		accountFrom = check.getAccountNumber();
		routingNumber = check.getRoutingNumber();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getToAccount() {
		return toName;
	}

	public void setToAccountID(int toAccountID) {
		ToAccountID = toAccountID;
	}

	public int getFrom() {
		return accountFrom;
	}

	public void setID(int ID) {
		this.transactionID = ID;
	}

	public int getID() {
		return transactionID;
	}
}
