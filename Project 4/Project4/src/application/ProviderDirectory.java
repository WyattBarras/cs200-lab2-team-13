package application;

import java.util.Arrays;
import java.util.Scanner;

public class ProviderDirectory {
	private Service[] serviceArray;
	private int curArraySize;
	private int curServices;

	public ProviderDirectory(int arraySize) {
		this.curArraySize = arraySize;
		this.curServices = 0;
		/* initializes array with empty Service objects 
		 * later search methods use "null" name of empty objects to search for first empty object
		 * or to help determine if array is full */
		Service[] newArray = new Service[arraySize];
		for(int i = 0; i < arraySize; i++) {
			newArray[i] = new Service();
		}
		this.serviceArray = newArray;
	}
	
	public ProviderDirectory() {
		// empty constructor initializes serviceArray with one empty Service object
		this.curArraySize = 1;
		this.curServices = 0;
		this.serviceArray[0] = new Service();
	}
	
	public void resizeArray(int newArraySize) {
		// copies serviceArray to new array of specified size
		Service[] newArray = Arrays.copyOf(this.serviceArray, newArraySize);
		// initializes empty Service objects in added slots of new array so search methods still work
		for(int i = this.curArraySize; i < newArraySize; i++) {
			newArray[i] = new Service();
		}
		this.curArraySize = newArraySize;
		this.serviceArray = newArray;
	}
	
	public Service getService(String servName) {
		for (Service look: serviceArray) {
			// looks for service by name in serviceArray, if not found returns null
			if (look.getServiceName() == servName) {
				return look;
			}
		}
		return null;
	}
	
	public void updateService(boolean nameChange, String servName, int servCode, double servFee, String servDesc) {
		// Search for service by name
		for(Service look: serviceArray) {
			if (look.getServiceName() == servName) {
				// If service name change required, ask for new name
				if (nameChange) {
					Scanner inName = new Scanner(System.in);
					System.out.printf("Input new name > ");
					look.setServiceName(inName.nextLine());
					inName.close();
				}
				// Updates elements of designated service, then breaks out of for loop
				look.setServiceCode(servCode);
				look.setServiceFee(servFee);
				look.setServiceDesc(servDesc);
				break;
			}
		}
	}
	
	public void addService(String servName, int servCode, double servFee, String servDesc) {
		if (this.curArraySize == this.curServices) {
			// If array full, expand array by factor of 2
			this.resizeArray(this.curArraySize * 2);
		}
		
		for (Service look: serviceArray) {
			// Look through serviceArray for first element with "null" serviceName, replace with input data
			if (look.getServiceName() == "null") {
				look.setServiceName(servName);
				look.setServiceCode(servCode);
				look.setServiceFee(servFee);
				look.setServiceDesc(servDesc);
				break;
			}
		}
		// increment curServices
		this.curServices++;
	}

	@Override
	public String toString() {
		String servString = "";
		for (Service s: serviceArray) {
			servString += s.toString();
		}
		return "Provider Directory: \n" + servString + "\ncurArraySize=" + curArraySize + ", curServices=" + curServices + "\n";
	}
	
	public void exportProviderDirectory() {
		// TODO: Export Provider Directory to a file in the working directory
	}
}
