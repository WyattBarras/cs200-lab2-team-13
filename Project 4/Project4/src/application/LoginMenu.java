package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginMenu {
	private static String MENU_TEXT;
	
	public LoginMenu() {
		MENU_TEXT = "";
	}
	
	public void setMenuText() {
		MENU_TEXT = "ChocAn Login: \n   ID Number: ";
	}
	
	@Override
	public String toString() {
		return MENU_TEXT;
	}
	
	public int login(Scanner loginScan) {
		System.out.print(this.toString());
		
		Integer id = Integer.parseInt(loginScan.next());
		System.out.print("   Password: ");
		String pass = loginScan.next();
		IDPair<Integer, String> idIN = new IDPair<Integer, String>(id, pass);
		
		boolean pairFound = false;
		File passes = new File("passes.txt");
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
			reader.close();
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
