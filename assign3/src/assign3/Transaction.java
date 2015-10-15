package assign3;

public class Transaction {
	private int amount;
	private String ToAccountID;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getToAccountID() {
		return ToAccountID;
	}

	public void setToAccountID(String toAccountID) {
		ToAccountID = toAccountID;
	}
}
