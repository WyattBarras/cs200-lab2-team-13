package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Terminal {

	public static MemberList readMembersFromFile(String filepath) {
		File members = new File(filepath);
		if (!members.exists()) {
			System.out.println("Members file does not exist. Exiting program");
			System.exit(404);
		}
		
		MemberList memberList = new MemberList();
		try(Scanner scanMem = new Scanner(members)){
			
			while (scanMem.hasNext()) {
				int memNum = Integer.parseInt(scanMem.next());
				String memName = scanMem.nextLine();
				String memAddr = scanMem.nextLine();
				String memCity = scanMem.nextLine();
				String memState= scanMem.next();
				int memZIP = Integer.parseInt(scanMem.next());
				int memBal = Integer.parseInt(scanMem.next());
				boolean memStatus = Boolean.parseBoolean(scanMem.next());
				
				memberList.addMember(memNum, memName, memAddr, memCity, memState, memZIP, memBal, memStatus);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
	
	public static void main(String[] args) {
		/* TODO: 
		 *  - Add read from files and write to files
		 *  - Add Operation menu functionality
		 * 	- Add terminal functions, permissions determined by role
		 */
		
		int role = Integer.parseInt(args[0]);
		if (role < 1 || role > 3){
			System.out.println("Invalid role, exiting program");
			System.exit(-1);
		}
		
		LoginMenu loginMenu = new LoginMenu(role);
		loginMenu.setMenuText();
		boolean isLoginValid = false;
		isLoginValid = loginMenu.login();
		
		if(!isLoginValid) {
			System.out.println("Invalid login credentials. Exiting program.");
			System.exit(0);
		}
		
		String[] filepaths = {"/home/wbarras/cs200-lab2-team-13/Project 4/Project4/members.txt",
				  "/home/wbarras/cs200-lab2-team-13/Project 4/Project4/providers.txt",
				  "/home/wbarras/cs200-lab2-team-13/Project 4/Project4/services.txt"};
		MemberList memberList = readMembersFromFile(filepaths[0]);
		System.out.println(memberList.toString());
		
		ProviderDirectory provDir = new ProviderDirectory(3);
		provDir.addService("Massage session", 110923, 59.99, "A one-hour appointment at a local massage parlor.");
		provDir.addService("Dietitian appointment", 913458, 49.59, "A 30 minute appointment with a licensed dietitian.");
		provDir.addService("Group therapy", 334455, 75.95, "A two-hour group therapy session with other ChocAn customers.");
		provDir.addService("Setup Service 1", 0, 0, "null");
		System.out.println(provDir.toString());
	}

}
