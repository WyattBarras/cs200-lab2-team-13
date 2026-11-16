package application;

import java.util.ArrayList;

public class ProviderList {
	ArrayList<Provider> providerList;
	
	public ProviderList(){
		this.providerList = new ArrayList<Provider>();
	}
	
	public Provider getProvider(int idNum) {
		for(Provider x:this.providerList) {
			if(x.getNumber() == idNum) {
				return x;
			}
		}
		System.out.println("Error: Provider not found in List. Defaulting to empty Proivder.");
		Provider val = new Provider();
		return val;
	}
	
	public void addMember(int number, String name, String streetAddress, String city, String state, int zipCode, int billAmount) {
		Provider next = new Provider(number, name, streetAddress, city, state, zipCode, billAmount);
		this.providerList.add(next);
	}
	
	public void removeMember(int idNum) {
		int index = -1;
		int i = 0;
		for(Provider x:this.providerList) {
			if(x.getNumber() == idNum) {
				index = i;
				break;
			}
			i++;
		}
		this.providerList.remove(index);
	}
	
	public void updateMemborRecords(int number, String name, String streetAddress, String city, String state, int zipCode, int billAmount) {
		Provider change = new Provider();
		boolean found = false;
		for(Provider x:this.providerList) {
			if(x.getNumber() == number) {
				found = true;
				change = x;
				break;
			}
		}
		if(found) {
			change.setName(name);
			change.setStreetAddress(streetAddress);
			change.setCity(city);
			change.setState(state);
			change.setZipCode(zipCode);
			change.setBillAmount(billAmount);
		}
	}
}
