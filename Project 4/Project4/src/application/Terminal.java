package application;

public class Terminal {

	public static void main(String[] args) {
		/* TODO: 
		 *  - Add Main menu/submenu functionality
		 *  - Add login functionality for each role (hashed passwords?)
		 * 	- Add terminal functions
		 */
		
		ProviderDirectory provDir = new ProviderDirectory(3);
		provDir.addService("Massage session", 110923, 59.99, "A one-hour appointment at a local massage parlor.");
		provDir.addService("Dietitian appointment", 913458, 49.59, "A 30 minute appointment with a licensed dietitian.");
		provDir.addService("Group therapy", 334455, 75.95, "A two-hour group therapy session with other ChocAn customers.");
		provDir.addService("Setup Service 1", 0, 0, "null");
		
		System.out.println(provDir.toString());
		provDir.updateService(false, "Massage session", 111222, 69.99, "A one-hour appointment at a local massage parlor.");
		provDir.updateService(true, "Setup Service 1", 100923, 40.00, "A one-hour lecture on dieting tips and tricks.");
		System.out.println(provDir.toString());
	}

}
