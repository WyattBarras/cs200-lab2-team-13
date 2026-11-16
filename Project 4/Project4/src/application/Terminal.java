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
		if (role < 1 || role > 3){
			System.out.println("Invalid role, exiting program");
			System.exit(-1);
		}

		LoginMenu loginMenu = new LoginMenu(role);
		loginMenu.setMenuText();
		boolean isLoginValid = false;
		while (!isLoginValid) { isLoginValid = loginMenu.login(); }
		
		ProviderDirectory provDir = new ProviderDirectory(3);
		provDir.addService("Massage session", 110923, 59.99, "A one-hour appointment at a local massage parlor.");
		provDir.addService("Dietitian appointment", 913458, 49.59, "A 30 minute appointment with a licensed dietitian.");
		provDir.addService("Group therapy", 334455, 75.95, "A two-hour group therapy session with other ChocAn customers.");
		provDir.addService("Setup Service 1", 0, 0, "null");
		System.out.println(provDir.toString());
	}

}
