package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
	
	public static void writeFile(String filename, String contents) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
			out.write(contents);
			System.out.println("Wrote " + filename);
		} catch (IOException e) {
			System.out.println("Could not write " + filename);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner inputScan = new Scanner(System.in);
		
		LoginMenu loginMenu = new LoginMenu();
		loginMenu.setMenuText();
		int LoginID = loginMenu.login(inputScan);
		int role = 0;
		if (LoginID < 0) {
			System.out.println("Invalid login credentials. Exiting program.");
			System.exit(0);
		} else if (LoginID % 111111 == 0) {
			role = 1;
		} else if (LoginID < 200000) {
			role = 2;
		} else {
			role = 3;
		}
		
		String[] filepaths = {"members.txt","providers.txt","services.txt"};
		MemberList memberList = readMembersFromFile(filepaths[0]);
		ProviderList providerList = readProvidersFromFile(filepaths[1]);
		ProviderDirectory provDir = readProvDirFromFile(filepaths[2]);
		ServiceRecordList servRecordList = new ServiceRecordList();
		
		OperatingMenu opMenu = new OperatingMenu(role, LoginID);
		opMenu.generateOperatingMenu();
		boolean cont = true;
		
		
		if (role == 1) {
			while (cont) {
				opMenu.displayMenu();
				switch (inputScan.nextInt()){
				case 1:
					opMenu.addMember(memberList, inputScan);
					break;
				case 2:
					opMenu.deleteMember(memberList, inputScan);
					break;
				case 3:
					opMenu.updateMember(memberList, inputScan);
					break;
				case 4:
					opMenu.addProvider(providerList, inputScan);
					break;
				case 5:
					opMenu.deleteProvider(providerList, inputScan);
					break;
				case 6:
					opMenu.updateProvider(providerList, inputScan);
					break;
				case 7:
					opMenu.runAccReport(servRecordList, providerList, provDir);
					break;
				case 8:
					opMenu.runProviderReports(servRecordList, memberList, providerList, provDir);
					break;
				case 9:
					System.out.println("Exiting program...");
					cont = false;
					break;
					default:
						System.out.println("Invalid function.");
						break;
				}
			}
		} else if (role == 2) {
			while (cont) {
				opMenu.displayMenu();
				switch (inputScan.nextInt()){
				case 1:
					opMenu.addMember(memberList, inputScan);
					break;
				case 2:
					opMenu.deleteMember(memberList, inputScan);
					break;
				case 3:
					opMenu.updateMember(memberList, inputScan);
					break;
				case 4:
					opMenu.addProvider(providerList, inputScan);
					break;
				case 5:
					opMenu.deleteProvider(providerList, inputScan);
					break;
				case 6:
					opMenu.updateProvider(providerList, inputScan);
					break;
				case 7:
					opMenu.runMemberReports(servRecordList, memberList, provDir, providerList);
					break;
				case 8:
					opMenu.runProviderReports(servRecordList, memberList, providerList, provDir);
					break;
				case 9:
					System.out.println("Exiting program...");
					cont = false;
					break;
					default:
						System.out.println("Invalid function.");
						break;
				}
			}
		} else if (role == 3) {
			while (cont) {
				opMenu.displayMenu();
				switch (inputScan.nextInt()) {
				case 1:
					opMenu.writeServiceRecord(servRecordList, memberList, provDir, inputScan, LoginID);
					break;
				case 9:
					System.out.println("Exiting program...");
					cont = false;
					break;
					default:
						System.out.println("Invalid function.");
						break;
				}
			}
		}
		
		writeFile(filepaths[0], memberList.toString());
		writeFile(filepaths[1], providerList.toString());
		writeFile(filepaths[2], provDir.toString());

		inputScan.close();
	}
}
		
