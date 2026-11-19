package application;
import java.util.ArrayList;


public class MemberList {
	ArrayList<Member> memberList;
	
	public MemberList(){
		this.memberList = new ArrayList<Member>();
	}
	
	public int size() {
		return this.memberList.size();
	}
	
	public ArrayList<Member> getMemberList() {	
		return this.memberList;
	}
	
	public Member getMember(int idNum) {
		for(Member x:this.memberList) {
			if(x.getNumber() == idNum) {
				return x;
			}
		}
		System.out.println("Member not found in member list.");
		return null;
	}
	
	public String getMemberName(int memNum) {
		String name = "";
		for (Member m: memberList) {
			if (m.getNumber() == memNum) {
				name = m.getName();
			}
		}
		return name;
	}
	
	public void addMember(int number, String name, String streetAddress, String city, String state, int zipCode, double accountBalance, boolean memberStatus) {
		Member next = new Member(number, name, streetAddress, city, state, zipCode, accountBalance, memberStatus);
		this.memberList.add(next);
	}
	
	public void removeMember(int idNum) {
		int index = -1;
		int i = 0;
		for(Member x:this.memberList) {
			if(x.getNumber() == idNum) {
				index = i;
				break;
			}
			i++;
		}
		if (index == -1) { System.out.println("Member does not exist."); return; } 
		this.memberList.remove(index);
	}
	
	public void updateMemberRecords(int number, String name, String streetAddress, String city, String state, int zipCode, double accountBalance, boolean memberStatus) {
		boolean found = false;
		for(Member x:this.memberList) {
			if(x.getNumber() == number) {
				found = true;
			}
			if(found) {
				if (name.contains("-1")) {
				} else { x.setName(name); }
				
				if (streetAddress.contains("-1")) {
				} else { x.setStreetAddress(streetAddress); }
				
				if (city.contains("-1")) {
				} else { x.setCity(city); }
				
				if (state.contains("-1")) {
				} else { x.setState(state); }
				
				if (zipCode == -1) {
				} else { x.setZipCode(zipCode); }
				
				if (accountBalance == -1) {
				} else { x.setAccountBalance(accountBalance); }
				x.setMemberStatus(memberStatus);
				break;
			}
		}
		if (!found) {
			System.out.println("Member does not exist in database.");
		}
	}

	@Override
	public String toString() {
		String memText = "";
		for (Member m: this.memberList) {
			memText += m.toString() + "\n";
		}
		return memText;
	}	
}
