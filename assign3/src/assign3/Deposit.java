package assign3;

public class Deposit extends Transaction {

	public Deposit(Check check) {
		super(check);
	}

	public String toString() {
		return "Deposit";
	}
}
