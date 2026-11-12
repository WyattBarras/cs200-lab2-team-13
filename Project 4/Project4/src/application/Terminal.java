package application;

import java.util.Scanner;

public class Terminal {

	public static void main(String[] args) {
		/* TODO: 
		 *  - Add Main menu/submenu functionality
		 *  - Add login functionality for each role (hashed passwords?)
		 * 	- Add terminal functions
		 */
		int role = Integer.parseInt(args[0]);
		Scanner loginScan = new Scanner(System.in);
		int id = 0;
		String password = "";
		if (role == 1) {
			System.out.print("Manager Login: \n   ID Number: ");
			id = loginScan.nextInt();
			System.out.print("\n   Password: ");
			password = loginScan.next();
		} else if (role == 2) {
			System.out.print("Manager Login: \n   ID Number: ");
			id = loginScan.nextInt();
			System.out.print("\n   Password: ");
			password = loginScan.nextLine();
		} else if (role == 3) {
			System.out.print("Manager Login: \n   Provider Number: ");
			id = loginScan.nextInt();
			System.out.print("\n   Password: ");
			password = loginScan.nextLine();
		} else {
			System.out.println("Invalid role, exiting program");
			System.exit(-1);
		}
		loginScan.close();
		
		System.out.println("ID: " + id + " Password: " + password);
		
		ProviderDirectory provDir = new ProviderDirectory(3);
		provDir.addService("Massage session", 110923, 59.99, "A one-hour appointment at a local massage parlor.");
		provDir.addService("Dietitian appointment", 913458, 49.59, "A 30 minute appointment with a licensed dietitian.");
		provDir.addService("Group therapy", 334455, 75.95, "A two-hour group therapy session with other ChocAn customers.");
		provDir.addService("Setup Service 1", 0, 0, "null");
		System.out.println(provDir.toString());
	}

}
