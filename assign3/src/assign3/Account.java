package assign3;

public class Account {
	private String ID;
	private int balance;
	private String[] ownerID;
	private String accountType;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String[] getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String[] ownerID) {
		this.ownerID = ownerID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
