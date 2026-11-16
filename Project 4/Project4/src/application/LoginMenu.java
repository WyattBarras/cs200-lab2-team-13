package application;

import java.util.Scanner;

public class LoginMenu {
	private static String MENU_TEXT;
	private String role;
	
	public LoginMenu(int role) {
		if (role == 1) {
			this.role = "Manager";
		} else if (role == 2) {
			this.role = "Operator";
		} else if (role == 3) {
			this.role = "Provider";
		}
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setMenuText() {
		MENU_TEXT = this.role + " Login: \n   ID Number: ";
	}
	
	@Override
	public String toString() {
		return MENU_TEXT;
	}
	
	public boolean login() {
		boolean isValid = false;
		System.out.println(this.toString());
		Scanner loginScan = new Scanner(System.in);
		
		Integer idNum = loginScan.nextInt();
		System.out.println("Password: ");
		String pass = loginScan.next();
		IDPair<Integer, String> id1 = new IDPair<Integer, String>(idNum, pass);
		//TODO: Scan password file for pair with matching id number, check password against what was input, update isValid
		loginScan.close();
		return isValid;
	}
}
