package application;

import java.util.ArrayList;
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
			menuText += "   (8) Run Provider Report\n";
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
			menuText += "   (7) Run Member Report\n";
			menuText += "   (8) Run Provider Report\n";
			menuText += "   (9) Quit\n";
		} else if (this.role == 3) {
			menuText += ("Hello Provider " + this.opID + "!\n");
			menuText += "  Available Functions: \n";
			menuText += "   (1) Write Service Record\n";
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
		double memBal = Double.parseDouble(memScan.nextLine().trim());
		System.out.print("New Member Status > ");
		boolean memStatus = Boolean.parseBoolean(memScan.nextLine().trim());

		memList.addMember(memNumber, memName, memAddr, memCity, memState, memZip, memBal, memStatus);
	}

	public void deleteMember(MemberList memList, Scanner scan) {
		scan.nextLine();
		System.out.print("Member ID to delete > ");
		int idNum = Integer.parseInt(scan.nextLine().trim());
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
		int memZip = Integer.parseInt(updateScan.nextLine().trim());
		System.out.print("New Member Balance > ");
		double memBal = Double.parseDouble(updateScan.nextLine().trim());
		System.out.print("New Member Status (true or false) > ");
		boolean memStatus = Boolean.parseBoolean(updateScan.nextLine().trim());

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
		double provBill = Double.parseDouble(provScan.nextLine().trim());

		provList.addProvider(provNumber, provName, provAddr, provCity, provState, provZip, provBill);
	}
	
	public void deleteProvider(ProviderList provList, Scanner scan) {
		scan.nextLine();
		System.out.print("Provider ID to delete > ");
		int idNum = Integer.parseInt(scan.nextLine().trim());
		provList.removeProvider(idNum);
	}
	
	public void updateProvider(ProviderList provList, Scanner provScan) {
		provScan.nextLine();
		
		System.out.println("Enter -1 if no change");
		System.out.print("Provider Number > ");
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
		double provBill = Double.parseDouble(provScan.nextLine().trim());

		provList.updateProviderRecords(provNumber, provName, provAddr, provCity, provState, provZip, provBill);
	}
	
	public void writeServiceRecord(ServiceRecordList servRecordList, MemberList memList, ProviderDirectory provDir, 
			                       Scanner servScan, int idNum) {
		servScan.nextLine();
		
		System.out.print("Current Date & Time: ");
		String curDateTime = servScan.nextLine();
		System.out.println("Service Date & Time: ");
		String servDateTime = servScan.nextLine();
		
		int provNum = idNum;
		System.out.println("Member Number: ");
		int memNum = Integer.parseInt(servScan.nextLine().trim());
		if (memList.getMember(memNum) == null) {
			return;
		}
		
		System.out.println("Service Code: ");
		int servCode = Integer.parseInt(servScan.nextLine().trim());
		Service a = provDir.getService(servCode);
		
		if (a != null) {
			System.out.println(a.getServiceCode());
			System.out.println(a.getServiceName());
			System.out.println(a.getServiceDesc());
			System.out.println("Is this right? (y/n)");
			String cont = servScan.nextLine();
			if (cont.contains("n")) { System.out.println("Exiting to menu..."); return; }
		} else {
			System.out.println("Service does not exist.");
			return;
		}
		
		String comments = servScan.nextLine();
		
		servRecordList.addServiceRecord(curDateTime, servDateTime, provNum, memNum, servCode, comments);
	}
	
	public void runAccReport(ServiceRecordList servRecordList, ProviderList provList, ProviderDirectory provDir) {
		AccountingReport.runAccountingReport(servRecordList, provList, provDir);
	}
	
	public ArrayList<String> runMemberReports(ServiceRecordList servRecordList, MemberList memList, ProviderDirectory provDir, ProviderList provList) {
		ArrayList<String> memReports = new ArrayList<String>(memList.size());
		ArrayList<Integer> memNums = new ArrayList<Integer>(memList.size());
		int index = 0;
		
		for (Member m: memList.getMemberList()) {
			memNums.set(index, m.getNumber());
			String heading = m.getNumber() + "\n" + m.getName() + "\n" + m.getStreetAddress() + "\n" + m.getCity()
							 + m.getState() + " " + m.getZipCode() + "\n";
			memReports.set(index, heading);
			index++;
		}
		
		for (ServiceRecord s: servRecordList.getRecords()) {
			for (index = 0; index < memNums.size(); index++) {
				if (s.getMemNum() == memNums.get(index)) {
					String newAdd = memReports.get(index) + "\n   " + s.getServiceDateTime() + "\n   " + 
									provList.getProvider(s.getProvNum()).getName() + provDir.getService(s.getServCode()).getServiceName();
					memReports.set(index, newAdd);
				}
			}
		}
		
		return memReports;
	}
	
	public ArrayList<String> runProviderReports(ServiceRecordList servRecordList, MemberList memList, ProviderList provList, ProviderDirectory provDir) {
		
		ArrayList<String> provReports = new ArrayList<String>(provList.size());
		ArrayList<Integer> provNums = new ArrayList<Integer>(provList.size());
		int index = 0;
		
		for (Provider p: provList.getProviderList()) {
			provNums.set(index, p.getNumber());
			String heading = p.getNumber() + "\n" + p.getName() + "\n" + p.getStreetAddress() + "\n" + p.getCity()
							 + p.getState() + " " + p.getZipCode() + "\n";
			provReports.set(index, heading);
			index++;
		}
		
		for (ServiceRecord s: servRecordList.getRecords()) {
			for (index = 0; index < provNums.size(); index++) {
				if (s.getProvNum() == provNums.get(index)) {
					String newAdd = provReports.get(index) + "\n" + s.getServiceDateTime() + "\n" + s.getCurDateTime()
									+ memList.getMemberName(s.getMemNum()) + "\n" + s.getMemNum() + "\n" + s.getServCode()
									+ "\n" + provDir.getService(s.getServCode()).getServiceFee() +"\n";
					provReports.set(index, newAdd);
				}
			}
		}
		
		return provReports;
	}
}
