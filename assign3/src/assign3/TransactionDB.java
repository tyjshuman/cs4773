package assign3;

import java.util.ArrayList;

/**
 * database containing all transactions as well as methods to look up
 * transactions by account number and member name. Acts as INFORMATION EXPERT
 * for tranactions
 * 
 * @author tyjshuman
 *
 */
public class TransactionDB {
	private int transactionID = 0;
	private ArrayList<Transaction> transactions;

	public TransactionDB() {
		transactions = new ArrayList<Transaction>();
	}

	public void newTransaction(Transaction t) {
		t.setID(transactionID);
		transactions.add(t);
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public ArrayList<Transaction> getAccountTransactions(int accountNumber, String name) {
		ArrayList<Transaction> out = new ArrayList<Transaction>();
		for (Transaction t : transactions) {
			if (t.getToAccount().equals(name) || t.getFrom() == accountNumber) {
				out.add(t);
			}
		}
		return out;
	}

	public void incrementTransactionID() {
		transactionID++;
	}
}
