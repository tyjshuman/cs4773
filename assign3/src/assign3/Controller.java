package assign3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the CREATOR and CONTROLLER class of my project. It is responsible for
 * creating instances of almost every object as well as controlling all the
 * other individual controllers.
 * 
 * This is also the INFORMATION EXPERT as it has access to all classes and
 * everything goes through this class
 * 
 * @author tyjshuman
 *
 */
public class Controller {
	private MemberDB memberDB;
	private AccountDB accountDB;
	private TransactionController transactionController;
	private TransactionDB transactionDB;

	Scanner scanner;

	/**
	 * by splitting up all the controllers and databases i utilize the HIGH
	 * COHESION design patterm
	 */
	public Controller() {
		transactionController = new TransactionController();
		transactionDB = new TransactionDB();
		scanner = new Scanner(System.in);
		memberDB = new MemberDB();
		accountDB = new AccountDB();
	}

	/**
	 * get a list of members
	 * 
	 * @return arraylist of members
	 */
	public ArrayList<Member> getMembers() {
		return memberDB.getMembers();
	}

	/**
	 * get transactions
	 * 
	 * @return an arraylist of all transactions
	 */
	public ArrayList<Transaction> getTransactions() {
		return transactionDB.getTransactions();
	}

	/**
	 * get accounts
	 * 
	 * @return an arraylist of all accounts
	 */
	public ArrayList<Account> getAccounts() {
		return accountDB.getAccounts();
	}

	/**
	 * used to pass the members db to the deposit tester for searching for
	 * different members
	 * 
	 * @return MemberDB
	 */
	public MemberDB getMemberDB() {
		return memberDB;
	}

	/**
	 * passes the account database to the tester to search for accounts
	 * 
	 * @return AccountDB
	 */
	public AccountDB getAccountDB() {
		return accountDB;
	}

	/**
	 * passes the transaction database to the tester
	 * 
	 * @return transactions db
	 */
	public TransactionDB getTransactionsDB() {
		return transactionDB;
	}

	/**
	 * reads in user input and creates a transaction
	 * 
	 * @param text
	 *            the method of input
	 */
	public void readCheckDeposit(String text) {
		int accountNumber;
		int routingNumber;
		double amount;
		String recipientName = "";
		System.out.print("Enter check amount: ");
		amount = scanner.nextDouble();
		System.out.print("Enter account number: ");
		accountNumber = scanner.nextInt();
		System.out.print("Enter routing number: ");
		routingNumber = scanner.nextInt();
		System.out.print("Enter recipient's full name: ");
		recipientName = scanner.next();
		recipientName += scanner.nextLine();

		Check check = new Check(amount, accountNumber, routingNumber, recipientName);
		Transaction t = transactionController.newCheck(check);
		transactionDB.newTransaction(t);
		accountDB.applyTransaction(t);
	}

	public void readCheckDeposit(String medium, String file) {
		transactionDB.incrementTransactionID();
	}

	public void addMember(String fName, String mName, String lName, int memberID) {
		Member member = new Member(fName, mName, lName, memberID);
		memberDB.addMember(member);
	}

	public void addAccount(int accountNumber, int routingNumber, int memberID) {
		Account account = new Account(accountNumber, routingNumber, memberID);
		memberDB.getMember(memberID).addAccount(accountNumber);
		account.setFullName(memberDB.getMember(memberID).getFullName());
		accountDB.addAccount(account);
	}

	public void addAccount(int accountNumber, int routingNumber, String memberFullName) {
		Account account = new Account(accountNumber, routingNumber, memberFullName);
		memberDB.getMember(memberFullName).addAccount(accountNumber);
		account.setFullName(memberFullName);
		accountDB.addAccount(account);
	}

	public void addAccount(int accountNumber, int routingNumber, double initialBalance, int memberID) {
		Account account = new Account(accountNumber, routingNumber, initialBalance, memberID);
		Member member = memberDB.getMember(memberID);
		member.addAccount(accountNumber);
		account.setFullName(memberDB.getMember(memberID).getFullName());
		accountDB.addAccount(account);
	}

	public void addAccount(int accountNumber, int routingNumber, double initialBalance, String memberFullName) {
		Account account = new Account(accountNumber, routingNumber, initialBalance, memberFullName);
		Member member = memberDB.getMember(memberFullName);
		member.addAccount(accountNumber);
		account.setFullName(memberFullName);
		accountDB.addAccount(account);
	}
}
