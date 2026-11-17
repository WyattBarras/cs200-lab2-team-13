package application;

public class Terminal {

	public void readDataFromFiles(String[] filepaths) {
		
	}
	
	public static void main(String[] args) {
		/* TODO: 
		 *  - Finish login menu functions (hashed passwords?)
		 *  - Add Operation menu functionality
		 * 	- Add terminal functions, permissions determined by role
		 */
		String[] filepaths = {"/home/wbarras/cs200-lab2-team-13/Project 4/Project4/members.txt",
							  "/home/wbarras/cs200-lab2-team-13/Project 4/Project4/providers.txt",
							  "/home/wbarras/cs200-lab2-team-13/Project 4/Project4/services.txt"};
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
		
		ProviderDirectory provDir = new ProviderDirectory(3);
		provDir.addService("Massage session", 110923, 59.99, "A one-hour appointment at a local massage parlor.");
		provDir.addService("Dietitian appointment", 913458, 49.59, "A 30 minute appointment with a licensed dietitian.");
		provDir.addService("Group therapy", 334455, 75.95, "A two-hour group therapy session with other ChocAn customers.");
		provDir.addService("Setup Service 1", 0, 0, "null");
		System.out.println(provDir.toString());
	}

}
