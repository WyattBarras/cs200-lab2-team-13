package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginMenu {
	private static String MENU_TEXT;
	
	public LoginMenu() {
		// Basic login prompt - doesn't change
		MENU_TEXT = "ChocAn Login: \n   ID Number: ";
	}
	
	@Override
	public String toString() {
		return MENU_TEXT;
	}
	
	public int login(Scanner loginScan) {
		System.out.print(this.toString());
		
		// gets id/password from user, prompted by above sysout
		Integer id = Integer.parseInt(loginScan.next());
		System.out.print("   Password: ");
		String pass = loginScan.next();
		// builds IDPair from user login info
		IDPair<Integer, String> idIN = new IDPair<Integer, String>(id, pass);
		
		boolean pairFound = false;
		// Opens passes.txt file for scanning
		File passes = new File("passes.txt");
		String passStr = null;
		int idNum = 0;
		
		try (Scanner reader = new Scanner(passes)){
			while (reader.hasNext()) {
				// while file still has passwords, compare ids with user ids until a match is found
				// when found, grab password of matching id
				idNum = Integer.parseInt(reader.next());
				if (idNum == idIN.getID()) {
					pairFound = true;
					passStr = reader.next();
					break;
				}
				
				// moves past passwords associated with non-matching ids in passes.txt
				passStr = reader.next();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		// if match not found, return failure
		if (!pairFound) {
			return -1;
		}
		
		// create pair of matching id/password found in passes.txt
		IDPair<Integer, String> idComp = new IDPair<Integer, String>(idNum, passStr);
		// if the pairs' hashCode is equal (only if passwords match), return success (login id to be used elsewhere)
		if (idIN.hashCode() == idComp.hashCode()) {
			return idIN.getID();
		}
		
		// if password doesn't match, return failure
		return -1;
	}
}
