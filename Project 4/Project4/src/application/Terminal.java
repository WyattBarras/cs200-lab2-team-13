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

	// Reads Members from file into MemberList object
	public static MemberList readMembersFromFile(String filepath) {
		File members = new File(filepath);
		// If file does not exist, exit with file not found code and print error message
		if (!members.exists()) {
			System.out.println("Members file does not exist. Exiting program");
			System.exit(404);
		}
		
		// Create new MemberList
		MemberList memberList = new MemberList();
		// try with resources auto-closes Scanner when finished
		try(Scanner scanMem = new Scanner(members)){
			// While file still has data, read member info, adding each member to memberList as info is scanned
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
	
	// Same as above, but reading Providers from file into ProviderList
	public static ProviderList readProvidersFromFile(String filepath) {
		File providers = new File(filepath);
		if (!providers.exists()) {
			System.out.println("Providers file does not exist. Exiting program");
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
	
	// Same as above, with some tweaks for array sizing
	public static ProviderDirectory readProvDirFromFile(String filepath) {
		File providerDirectory = new File(filepath);
		if (!providerDirectory.exists()) {
			System.out.println("Services file does not exist. Exiting program");
			System.exit(404);
		}
		
		// Gets Path object for filepath
		Path path = Path.of(filepath);
		long count = 0;
		// Stream lines from file, counting each
		try (Stream<String> lines = Files.lines(path)) {
            count = lines.count();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		// Create ProviderDirectory with the exact size of the number of objects in the file
		int size = (int) (count / 4);
		ProviderDirectory provDir = new ProviderDirectory(size);
		
		try(Scanner scanDir = new Scanner(providerDirectory)){
			// Same as above: scan Services from file following set format, create Services in provDir with data
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
	
	// Same as the above functions for Members and Providers, but for ServiceRecords
	public static ServiceRecordList readServiceRecordsFromFile(String filepath) {
		File servRecords = new File(filepath);
		if (!servRecords.exists()) {
			System.out.println("Service Records file does not exist. Exiting program");
			System.exit(404);
		}
		
		ServiceRecordList servRecordList = new ServiceRecordList();
		try(Scanner scanProv = new Scanner(servRecords)){
			
			while (scanProv.hasNext()) {
				String curDateTime = scanProv.nextLine();
				String servDateTime = scanProv.nextLine();
				int provNum = Integer.parseInt(scanProv.next());
				int memNum = Integer.parseInt(scanProv.next());
				scanProv.nextLine();
				int servCode = Integer.parseInt(scanProv.nextLine());
				String comments = scanProv.nextLine();
				
				servRecordList.addServiceRecord(curDateTime, servDateTime, provNum, memNum, servCode, comments);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return servRecordList;
		
	}
	
	// Generic file writer using BufferedWriter to write given strings to a given file
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
		// Scanner for *all* user input to program
		Scanner inputScan = new Scanner(System.in);
		
		// Create loginMenu
		LoginMenu loginMenu = new LoginMenu();
		// Prompt user for login info
		int LoginID = loginMenu.login(inputScan);
		int role = 0;
		// If loginID valid, role based on value of ID, if not, print error message and exit program
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
		
		// Read all info from relevant data files
		String[] filepaths = {"members.txt","providers.txt","services.txt","service_records.txt"};
		MemberList memberList = readMembersFromFile(filepaths[0]);
		ProviderList providerList = readProvidersFromFile(filepaths[1]);
		ProviderDirectory provDir = readProvDirFromFile(filepaths[2]);
		ServiceRecordList servRecordList = readServiceRecordsFromFile(filepaths[3]);
		
		// Set up operation menu using user role and id
		OperatingMenu opMenu = new OperatingMenu(role, LoginID);
		opMenu.generateOperatingMenu();
		boolean cont = true;
		
		// each role can only use certain functions
		// Repetition allowed with while loop/boolean condition, function selection with switch statement b/c integer input
		if (role == 1) {
			while (cont) {
				opMenu.displayMenu();
				System.out.print(" > ");
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
					String provReports = opMenu.runProviderReports(servRecordList, memberList, providerList, provDir);
					writeFile("provider_reports.txt", provReports);
					break;
				case 9:
					System.out.println("Exiting program...");
					cont = false;
					break;
					default:
						System.out.println("Invalid function.");
						break;
				}
				System.out.println();
			}
		} else if (role == 2) {
			while (cont) {
				opMenu.displayMenu();
				System.out.print(" > ");
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
					String memReports = opMenu.runMemberReports(servRecordList, memberList, provDir, providerList);
					writeFile("member_reports.txt", memReports);
					break;
				case 8:
					String provReports = opMenu.runProviderReports(servRecordList, memberList, providerList, provDir);
					writeFile("provider_reports.txt", provReports);
					break;
				case 9:
					System.out.println("Exiting program...");
					cont = false;
					break;
					default:
						System.out.println("Invalid function.");
						break;
				}
				System.out.println();
			}
		} else if (role == 3) {
			while (cont) {
				opMenu.displayMenu();
				System.out.print(" > ");
				switch (inputScan.nextInt()) {
				case 1:
					opMenu.writeServiceRecord(servRecordList, memberList, provDir, inputScan, LoginID);
					break;
				case 2:
					opMenu.displayProviderDirectory(provDir);
					break;
				case 3:
					opMenu.addService(provDir, inputScan);
					break;
				case 4:
					opMenu.deleteService(provDir, inputScan);
					break;
				case 5:
					opMenu.updateService(provDir, inputScan);
					break;
				case 9:
					System.out.println("Exiting program...");
					cont = false;
					break;
					default:
						System.out.println("Invalid function.");
						break;
				}
				System.out.println();
			}
		}
		
		// Write changed data to files
		writeFile(filepaths[0], memberList.toString());
		writeFile(filepaths[1], providerList.toString());
		writeFile(filepaths[2], provDir.toString());
		writeFile(filepaths[3], servRecordList.toString());

		System.out.println("Thank you for using ChocAn Services!");
		System.out.println("Have a great day!");
		inputScan.close();
	}
}
		
