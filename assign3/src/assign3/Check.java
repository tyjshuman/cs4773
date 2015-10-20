package assign3;

/**
 * One instance is created per transaction and the stored in the ChecksToClear
 * class. Only contains getters and setters for the check's inmformation
 * 
 * @author tyjshuman
 *
 */
public class Check {
	private double amount;
	private String from;
	private String to;
	private int routingNumber;
	private int accountNumber;

	public Check(double amount, int accountNumber, int routingNumber, String to) {
		this.amount = amount;
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.to = to;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(int routingNumber) {
		this.routingNumber = routingNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
}
