package assign3;

import java.util.ArrayList;

import org.apache.pdfbox.text.PDFTextStripper;

/**
 * ALL THAT WORKS IS THE TEXT INPUT, NOTHING ELSE.
 *
 */
public class DepositTester {

	// Tests each of the 3 Adapters for
	// Image, Text, and PDF by calling a
	// readCheckDeposit operation from the
	// controller. The string that is passed in
	// indicates which adapter is to be used.
	// In the "text" case you will need to prompt the
	// user for all the information that is on the
	// check (account number listed on check, routing
	// number listed on check, amount of check, and
	// name of the recipient), you may choose arbitrary
	// check information as long is it will produce a
	// valid transaction and show a change when the
	// next MemberInfo print is called. The "image" case
	// will pass a file name containing the image of the
	// check, from there find and use APIs to extract the
	// information from the check (same information as
	// the text case). The "pdf" case is very similar to
	// the image case, it will also pass a file and
	// so APIs will be needed to extract the information
	// from that file (again, same as above). (Note, you may
	// choose to modify the file path if wish to orginize
	// your java project to place them in separate folders).
	// As shown, the MemberInfo is printed at every stage. It
	// should show updated balances and logged transactions
	// at each step. Note that we are not using a deposit
	// slip in this assignment. That means that you will need
	// to look up the member who is the recipient (by name
	// or id) of the check and select one of their accounts
	// to deposit the check amount into (you can arbitrarily
	// select the account as long as the print out of the
	// MemberInfo shows the transaction). You will also need
	// to debit/withdraw that same amount from the account
	// that issued the check (if it exists in this bank, if
	// it doesn't than it must be from outside the bank and
	// we aren't going to worry about it for this assignment).
	// Also, the only class that this Tester class should have
	// DIRECT contact/association with is the Controller. No
	// other classes should be directly called. (You can rename
	// the Controller if you like, as long as it is fitting).
	// There will be more test cases for when the assignment
	// is graded so please feel free to implement your own
	// test cases and sample files. If you do, then please include
	// these additional test cases and files in your final turn in.
	// As a final note, please make sure to comment all your
	// classes and operations. Please include the patterns
	// used to assign/create EVERY operation to/in the class
	// it was put in (DO NOT FORGET TO INCLUDE PATTERNS FOR
	// EVRY OPERATION IN EVERY CLASS, YOU WILL BE MARKED OFF
	// IF YOU DO!!!)
	public static void main(String[] args) {
		// PDFTextStripper stripper = new PDFTextStripper();
		// stripper.
		Controller c = new Controller();
		fillProfilesAndAccounts(c);
		printMemberInfo(c);

		c.readCheckDeposit("text");
		printMemberInfo(c);
		// c.readCheckDeposit("image", "SampleImage1.png");
		// printMemberInfo(c);
		// c.readCheckDeposit("pdf", "SamplePDF1.pdf");
		// printMemberInfo(c);
	}

	// Since we are not worried about a database (yet) you can simply
	// fill in some Members and Accounts here. The format used here
	// is:
	// addMember(firstName, middleName, lastName, memberID);
	//
	// addAccount(accountNumber, routingNumber, memberID);
	// OR
	// addAccount(accountNumber, routingNumber, memberFullName);
	// OR
	// addAccount(accountNumber, routingNumber, initialBalance, memberID);
	// OR
	// addAccount(accountNumber, routingNumber, initialBalance, memberFullName);
	// You can use different formats if you'd like (you may want to
	// depending on exactly how you implement all your other classes),
	// as long as they make sense and contain AT LEAST the member name
	// and id and the account number, routing number, and possibly an
	// initial balance. You may also add other accounts/members for further
	// testing, but do not remove the ones present or change their initial
	// values
	// (though if you modify the constructor format, then obviously modify
	// the formats below, just don't change the values).
	public static void fillProfilesAndAccounts(Controller c) {
		String fName, mName, lName, fullName;
		int memberID, accountID, routingNum;
		double initBalance;

		// Member Profiles
		fName = "John";
		mName = "Z";
		lName = "Smith";
		memberID = 123456;
		c.addMember(fName, mName, lName, memberID);

		fName = "Roger";
		mName = "M";
		lName = "Doe";
		memberID = 658241;
		c.addMember(fName, mName, lName, memberID);

		fName = "Ashley";
		mName = "Maureen";
		lName = "Williams";
		memberID = 987654;
		c.addMember(fName, mName, lName, memberID);

		// Member Accounts
		accountID = 724301068;
		routingNum = 122105278;
		memberID = 123456;
		initBalance = 8003.00;
		c.addAccount(accountID, routingNum, initBalance, memberID);

		accountID = 512463512;
		c.addAccount(accountID, routingNum, memberID);

		accountID = 555555555;
		routingNum = 333388888;
		fullName = "Roger M Doe";
		c.addAccount(accountID, routingNum, fullName);

		accountID = 886611554;
		routingNum = 324752184;
		initBalance = 600.00;
		memberID = 987654;
		c.addAccount(accountID, routingNum, initBalance, memberID);

		accountID = 449977123;
		initBalance = 30.00;
		fullName = "Ashley Maureen Williams";
		c.addAccount(accountID, routingNum, initBalance, fullName);

		accountID = 925849516;
		c.addAccount(accountID, routingNum, memberID);

	}

	public static void printMemberInfo(Controller c) {
		// Have this method print ALL members and their
		// account details. An example print out follows
		// (you can choose a different format if you like
		// as long as it makes sense and is easy to understand):
		/*
		 * MemberID MemberName AccountNumber1 balance Transaction1 amount
		 * AccountNumber2 balance Transaction2 amount Transaction1 ithdraamount
		 * 
		 * MemberID MemberName AccountNumber1 balance Transaction2 amount
		 * Transaction1 amount AccountNumber2 balance Transaction1 amount
		 * 
		 * etc...
		 */
		for (Member member : c.getMembers()) {
			System.out.println("Name:\t" + member.getFullName());
			System.out.println("\tAccounts: ");
			for (int account : member.getAccounts()) {
				System.out.println("\t\tAccount number:\t" + account);
				System.out.println("\t\tBalance:\t" + c.getAccountDB().getAccount(account).getBalance());
				ArrayList<Transaction> transactions = c.getTransactionsDB().getAccountTransactions(account,
						member.getFullName());
				if (!transactions.isEmpty()) {
					System.out.println("\t\t\tTransactions:");
					for (Transaction t : transactions) {
						if (t.getFrom() == account)
							System.out.println("\t\t\tType:\twithdraw");
						else
							System.out.println("\t\t\tType:\tdeposit");
						System.out.println("\t\t\tAmount:\t" + t.getAmount());
					}
				} else
					System.out.println();
			}
		}
	}
}
