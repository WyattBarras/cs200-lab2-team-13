package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProviderDirectory {
	private ArrayList<Service> serviceArray;

	public ProviderDirectory(int arraySize) {
		/* initializes array with empty Service objects 
		 * later search methods use "null" name of empty objects to search for first empty object */
		ArrayList<Service> newArray = new ArrayList<Service>(Collections.nCopies(arraySize, new Service()));
		this.serviceArray = newArray;
	}
	
	public ProviderDirectory() {
		// empty constructor initializes serviceArray with one empty Service object
		this.serviceArray = new ArrayList<Service>(1);
		Service s = new Service();
		this.serviceArray.set(0, s);
	}
	
	public Service getService(int servCode) {
		for (Service look: serviceArray) {
			// looks for service by code in serviceArray, if not found returns null
			if (look.getServiceCode() == servCode) {
				return look;
			}
		}
		return null;
	}
	
	public String getServiceName(int servCode) {
		String name = "";
		for (Service s: serviceArray) {
			if (servCode == s.getServiceCode()) {
				name = s.getServiceName();
			}
		}
		return name;
	}
	
	public void addService(String servName, int servCode, double servFee, String servDesc) {
		Service newServ = new Service(servName, servCode, servFee, servDesc);
		int index = 0;
		boolean found = false;
		for (Service look: serviceArray) {
			// Look through serviceArray for first element with "null" serviceName, replace with input data
			if (look.getServiceName() == "null") {
				this.serviceArray.set(index, newServ);
				found = true;
				break;
			}
			index++;
		}
		if (!found) {
			this.serviceArray.add(newServ);
		}
	}
	
	public void updateService(boolean codeChange, String servName, int servCode, double servFee, String servDesc, Scanner inCode) {
		// Search for service by name
		for(Service look: serviceArray) {
			if (look.getServiceCode() == servCode) {
				// If service name change required, ask for new name
				if (codeChange) {
					System.out.printf("Input new code > ");
					look.setServiceCode(Integer.parseInt(inCode.nextLine()));
				}
				// Updates elements of designated service, then breaks out of for loop
				look.setServiceName(servName);
				look.setServiceFee(servFee);
				look.setServiceDesc(servDesc);
				break;
			}
		}
	}
	
	public void deleteService(int servCode) {
		int index = 0;
		for (Service look: this.serviceArray) {
			if (look.getServiceCode() == servCode) {
				this.serviceArray.remove(index);
			}
			index++;
		}
	}

	@Override
	public String toString() {
		String servString = "";
		for (Service s: serviceArray) {
			servString += s.toString() + "\n";
		}
		return servString;
	}
	
	public void exportProviderDirectory() {
		String fileLocation = "ProviderDirectory.txt";
		
		try(var bufWrite = new BufferedWriter(new FileWriter(fileLocation))) {
			bufWrite.write(this.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Provider Directory write completed.");
	}
}
