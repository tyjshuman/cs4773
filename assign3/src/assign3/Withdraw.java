package assign3;

public class Withdraw extends Transaction {

	public Withdraw(Check check) {
		super(check);
	}

	public String toString() {
		return "Withdraw";
	}

}
