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
	
	public int login() {
		Scanner loginScan = new Scanner(System.in);
		System.out.print(this.toString());
		
		Integer id = Integer.parseInt(loginScan.next());
		System.out.print("Password: ");
		String pass = loginScan.next();
		IDPair<Integer, String> idIN = new IDPair<Integer, String>(id, pass);
		loginScan.close();
		
		boolean pairFound = false;
		File passes = new File("/home/wbarras/cs200-lab2-team-13/Project 4/Project4/passes.txt");
		String passStr = null;
		int idNum = 0;
		
		try (Scanner reader = new Scanner(passes)){
			while (reader.hasNext()) {
				idNum = Integer.parseInt(reader.next());
				if (idNum == idIN.getID()) {
					pairFound = true;
					passStr = reader.next();
					break;
				}
				
				passStr = reader.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		if (!pairFound) {
			return -1;
		}
		
		IDPair<Integer, String> idComp = new IDPair<Integer, String>(idNum, passStr);
		if (idIN.hashCode() == idComp.hashCode()) {
			return idIN.getID();
		}
		return -1;
	}
}
