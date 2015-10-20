package assign3;

import java.util.ArrayList;

/**
 * A database containing all the members. Contains methods for finding members
 * by name and by member ID
 * 
 * @author tyjshuman
 *
 */
public class MemberDB {
	private ArrayList<Member> members = new ArrayList<Member>();

	public ArrayList<Member> getMembers() {
		return members;
	}

	/**
	 * add a member to the database
	 * 
	 * @param member
	 *            member instance to add to the database
	 */
	public void addMember(Member member) {
		members.add(member);
	}

	/**
	 * find member by ID
	 * 
	 * @param ID
	 *            member id to look up
	 * @return member
	 */
	public Member getMember(int ID) {
		for (Member m : members) {
			if (m.getID() == ID)
				return m;
		}
		return null;
	}

	/**
	 * find member by name
	 * 
	 * @param name
	 *            name to look up
	 * @return member
	 */
	public Member getMember(String name) {
		for (Member m : members) {
			if (m.getFullName().equals(name))
				return m;
		}
		return null;
	}
}
