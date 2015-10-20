package assign3;

import java.util.ArrayList;

/**
 * Database containing all accounts. Acts as the INFORMATION EXPERT for
 * accounts. contains methods for searching for accounts by account number.
 * 
 * This class is in charge of applying transactions to the different accounts
 * 
 * @author tyjshuman
 *
 */
public class AccountDB {
	ArrayList<Account> accounts;

	public AccountDB() {
		accounts = new ArrayList<Account>();
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public Account getAccount(int accountID) {
		for (Account a : accounts) {
			if (a.getID() == accountID) {
				return a;
			}
		}
		return null;
	}

	public Account getAccount(String name) {
		System.out.println(name);
		for (Account a : accounts) {
			if (a.getOwnerName().equals(name)) {
				return a;
			}
		}
		return null;
	}

	/**
	 * this is called by the main controller once a transaction instance has
	 * been created.
	 * 
	 * @param t
	 *            transaction to be applied to 2 accounts
	 */
	public void applyTransaction(Transaction t) {
		for (Account a : accounts) {
			if (a.getOwnerID() == t.getFrom())
				a.applyTransaction("withdraw", t);
			else if (a.getOwnerName().equals(t.getToAccount())) {
				a.applyTransaction("deposit", t);
			}
		}
	}
}
