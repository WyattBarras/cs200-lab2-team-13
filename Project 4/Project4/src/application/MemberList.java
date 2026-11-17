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
		Member change = new Member();
		boolean found = false;
		for(Member x:this.memberList) {
			if(x.getNumber() == number) {
				found = true;
				change = x;
				break;
			}
		}
		if(found) {
			change.setName(name);
			change.setStreetAddress(streetAddress);
			change.setCity(city);
			change.setState(state);
			change.setZipCode(zipCode);
			change.setAccountBalance(accountBalance);
			change.setMemberStatus(memberStatus);
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
