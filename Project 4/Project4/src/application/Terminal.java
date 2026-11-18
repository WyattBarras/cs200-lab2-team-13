package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

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
				scanMem.nextLine();
				String memName = scanMem.nextLine();
				String memAddr = scanMem.nextLine();
				String memCity = scanMem.nextLine();
				String memState = scanMem.next();
				int memZIP = scanMem.nextInt();
				double memBal = scanMem.nextDouble();
				boolean memStatus = Boolean.parseBoolean(scanMem.next());
				
				memberList.addMember(memNum, memName, memAddr, memCity, memState, memZIP, memBal, memStatus);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
	
	public static ProviderList readProvidersFromFile(String filepath) {
		File providers = new File(filepath);
		if (!providers.exists()) {
			System.out.println("Members file does not exist. Exiting program");
			System.exit(404);
		}
		
		ProviderList providerList = new ProviderList();
		try(Scanner scanProv = new Scanner(providers)){
			
			while (scanProv.hasNext()) {
				int provNum = Integer.parseInt(scanProv.next());
				scanProv.nextLine();
				String provName = scanProv.nextLine();
				String provAddr = scanProv.nextLine();
				String provCity = scanProv.nextLine();
				String provState = scanProv.next();
				int provZIP = scanProv.nextInt();
				double provBill = scanProv.nextDouble();
				
				providerList.addProvider(provNum, provName, provAddr, provCity, provState, provZIP, provBill);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return providerList;
		
	}
	
	public static ProviderDirectory readProvDirFromFile(String filepath) {
		File providerDirectory = new File(filepath);
		if (!providerDirectory.exists()) {
			System.out.println("Members file does not exist. Exiting program");
			System.exit(404);
		}
		
		Path path = Path.of(filepath);
		long count = 0;
		try (Stream<String> lines = Files.lines(path)) {
            count = lines.count();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		int size = (int) (count / 4);
		ProviderDirectory provDir = new ProviderDirectory(size);
		
		try(Scanner scanDir = new Scanner(providerDirectory)){
			
			while (scanDir.hasNext()) {
				String servName = scanDir.nextLine();
				int servNum = Integer.parseInt(scanDir.nextLine());
				double servFee = Double.parseDouble(scanDir.nextLine());
				String servDesc = scanDir.nextLine();
				
				provDir.addService(servName, servNum, servFee, servDesc);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return provDir;
	}
	
	public static void main(String[] args) {
		/* TODO: 
		 *  - Add write to files
		 * 	- Add terminal functions, permissions determined by role
		 */
		
		int role = Integer.parseInt(args[0]);
		if (role < 1 || role > 3){
			System.out.println("Invalid role, exiting program");
			System.exit(-1);
		}
		
		LoginMenu loginMenu = new LoginMenu(role);
		loginMenu.setMenuText();
		int LoginID = loginMenu.login();
		
		if(LoginID < 0) {
			System.out.println("Invalid login credentials. Exiting program.");
			System.exit(0);
		}
		
		String[] filepaths = {"/home/wbarras/cs200-lab2-team-13/Project 4/Project4/members.txt",
				  "/home/wbarras/cs200-lab2-team-13/Project 4/Project4/providers.txt",
				  "/home/wbarras/cs200-lab2-team-13/Project 4/Project4/services.txt"};
		MemberList memberList = readMembersFromFile(filepaths[0]);
		ProviderList providerList = readProvidersFromFile(filepaths[1]);
		ProviderDirectory provDir = readProvDirFromFile(filepaths[2]);
		
		OperatingMenu opMenu = new OperatingMenu(role, LoginID);
		
	}

}
