package application;
import java.util.ArrayList;


public class MemberList {
	ArrayList<Member> memberList;
	
	public MemberList(){
		this.memberList = new ArrayList<Member>();
	}
	
	public Member getMember(int idNum) {
		for(Member x:this.memberList) {
			if(x.getNumber() == idNum) {
				return x;
			}
		}
		System.out.println("Error: Member not found in List. Defaulting to empty member");
		Member val = new Member();
		return val;
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
		this.memberList.remove(index);
	}
	
	public void updateMemberRecords(int number, String name, String streetAddress, String city, String state, int zipCode, double accountBalance, boolean memberStatus) {
		boolean found = false;
		for(Member x:this.memberList) {
			if(x.getNumber() == number) {
				found = true;
			}
			if(found) {
				if (name != "-1") {
					x.setName(name);
				}
				if (streetAddress != "-1") {
					x.setStreetAddress(streetAddress);
				}
				if (city != "-1") {
					x.setCity(city);
				}
				if (state != "-1") {
					x.setState(state);
				}
				if (zipCode != -1) {
					x.setZipCode(zipCode);
				}
				if (accountBalance != -1) {
					x.setAccountBalance(accountBalance);
				}
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
