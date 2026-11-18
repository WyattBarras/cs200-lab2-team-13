package application;

import java.util.Scanner;

public class OperatingMenu {
	private int role;
	private int opID;
	private String menuText = "";

	public OperatingMenu(int role, int opID) {
		this.role = role;
		this.opID = opID;
	}

	public void generateOperatingMenu() {
		if (this.role == 1) {
			menuText += ("Hello Manager " + this.opID + "!\n");
			menuText += "  Available Functions: \n";
			menuText += "   (1) Add Member\n";
			menuText += "   (2) Delete Member\n";
			menuText += "   (3) Update Member\n";
			menuText += "   (4) Add Provider\n";
			menuText += "   (5) Delete Provider\n";
			menuText += "   (6) Update Provider\n";
			menuText += "   (7) Run Accounting Report\n";
			menuText += "   (8) Run Manager Report\n";
			menuText += "   (9) Quit\n";
		} else if (this.role == 2) {
			menuText += "Hello Operator " + this.opID + "!\n";
			menuText += "  Available Functions: \n";
			menuText += "   (1) Add Member\n";
			menuText += "   (2) Delete Member\n";
			menuText += "   (3) Update Member\n";
			menuText += "   (4) Add Provider\n";
			menuText += "   (5) Delete Provider\n";
			menuText += "   (6) Update Provider\n";
			menuText += "   (9) Quit\n";
		} else if (this.role == 3) {
			menuText += ("Hello Provider " + this.opID + "!\n");
			menuText += "  Available Functions: \n";
			menuText += "   (1) Write Service Record";
			menuText += "   (2) Process Transaction";
			menuText += "   (9) Quit\n";
		}
	}

	public void displayMenu() {
		System.out.println(this.menuText);
	}

	public void addMember(MemberList memList, Scanner memScan) {
		memScan.nextLine();
		System.out.print("New Member Number > ");
		int memNumber = Integer.parseInt(memScan.nextLine().trim());
		System.out.print("New Member Name > ");
		String memName = memScan.nextLine();
		System.out.print("New Member Address > ");
		String memAddr = memScan.nextLine();
		System.out.print("New Member City > ");
		String memCity = memScan.nextLine();
		System.out.print("New Member State > ");
		String memState = memScan.nextLine();
		System.out.print("New Member ZIP > ");
		int memZip = Integer.parseInt(memScan.nextLine().trim());
		System.out.print("New Member Balance > ");
		double memBal = Double.parseDouble(memScan.next().trim());
		System.out.print("New Member Status > ");
		boolean memStatus = Boolean.parseBoolean(memScan.next().trim());

		memList.addMember(memNumber, memName, memAddr, memCity, memState, memZip, memBal, memStatus);
	}

	public void deleteMember(MemberList memList, Scanner scan) {
		scan.nextLine();
		System.out.print("Member ID to delete > ");
		int idNum = scan.nextInt();
		memList.removeMember(idNum);
	}

	public void updateMember(MemberList memList, Scanner updateScan) {
		updateScan.nextLine();
		System.out.println("Enter -1 if no change");
		System.out.print("Member Number > ");
		int memNumber = Integer.parseInt(updateScan.nextLine().trim());
		System.out.print("New Member Name > ");
		String memName = updateScan.nextLine();
		System.out.print("New Member Address > ");
		String memAddr = updateScan.nextLine();
		System.out.print("New Member City > ");
		String memCity = updateScan.nextLine();
		System.out.print("New Member State > ");
		String memState = updateScan.nextLine();
		System.out.print("New Member ZIP > ");
		int memZip = Integer.parseInt(updateScan.nextLine());
		System.out.print("New Member Balance > ");
		double memBal = Double.parseDouble(updateScan.nextLine());
		System.out.print("New Member Status (true or false) > ");
		boolean memStatus = Boolean.parseBoolean(updateScan.nextLine());

		memList.updateMemberRecords(memNumber, memName, memAddr, memCity, memState, memZip, memBal, memStatus);
	}
	
	public void addProvider(ProviderList provList, Scanner provScan) {
		provScan.nextLine();
		System.out.print("New Provider Number > ");
		int provNumber = Integer.parseInt(provScan.nextLine().trim());
		System.out.print("New Provider Name > ");
		String provName = provScan.nextLine();
		System.out.print("New Provider Address > ");
		String provAddr = provScan.nextLine();
		System.out.print("New Provider City > ");
		String provCity = provScan.nextLine();
		System.out.print("New Provider State > ");
		String provState = provScan.nextLine();
		System.out.print("New Provider ZIP > ");
		int provZip = Integer.parseInt(provScan.nextLine().trim());
		System.out.print("New Provider Bill > ");
		double provBill = Double.parseDouble(provScan.next().trim());

		provList.addProvider(provNumber, provName, provAddr, provCity, provState, provZip, provBill);
	}
	
	public void deleteProvider(ProviderList provList, Scanner scan) {
		
	}
}
