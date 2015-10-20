package assign3;

import java.util.ArrayList;

/**
 * member object. contains an array of all associated accounts
 * 
 * @author tyjshuman
 *
 */
public class Member {
	private int ID;
	private String fullName;
	private String fName;
	private String mName;
	private String lName;
	private String DOB;
	private String address;
	private String SSN;

	private ArrayList<Integer> accounts;

	public Member(String fName, String mName, String lName, int memberID) {
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.ID = memberID;
		this.fullName = fName + " " + mName + " " + lName;
		accounts = new ArrayList<Integer>();
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFName() {
		return fName;
	}

	public String getMName() {
		return mName;
	}

	public String getLName() {
		return lName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setName(String name) {
		this.fullName = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public ArrayList<Integer> getAccounts() {
		return accounts;
	}

	public void addAccount(Integer account) {
		accounts.add(account);
	}

	public void setAccounts(ArrayList<Integer> accounts) {
		this.accounts = accounts;
	}
}
