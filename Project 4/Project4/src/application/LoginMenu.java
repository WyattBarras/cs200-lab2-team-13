package application;

import java.io.File;
import java.io.FileNotFoundException;
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
		
		Integer id = loginScan.nextInt();
		System.out.println("Password: ");
		String pass = loginScan.next();
		loginScan.close();
		IDPair<Integer, String> idIN = new IDPair<Integer, String>(id, pass);
		
		boolean pairFound = false;
		File passes = new File("/home/wbarras/cs200-lab2-team-13/Project 4/Project4/passes.txt");
		String idStr = null;
		String passStr = null;
		int idNum = 0;
		
		try (Scanner reader = new Scanner(passes)){
			while (reader.hasNext()) {
				idStr = reader.next();
				idNum = Integer.parseInt(idStr);
				passStr = reader.next();
				
				if (idNum == idIN.getID()) {
					pairFound = true;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		if (!pairFound) {
			return false;
		}
		
		IDPair<Integer, String> idComp = new IDPair<Integer, String>(idNum, passStr);
		if (idIN.getPassword() == idComp.getPassword()) {
			isValid = true;
		}
		return isValid;
	}
}
