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
	
	public void addProvider(int number, String name, String streetAddress, String city, String state, int zipCode, double billAmount) {
		Provider next = new Provider(number, name, streetAddress, city, state, zipCode, billAmount);
		this.providerList.add(next);
	}
	
	public void removeProvider(int idNum) {
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
	
	public void updateProviderRecords(int number, String name, String streetAddress, String city, String state, int zipCode, double billAmount) {
		boolean found = false;
		for(Provider x:this.providerList) {
			if(x.getNumber() == number) {
				found = true;
			}
			if(found) {
				if (name != "-1") {
					x.setName(name);
				}
				if (streetAddress != "-1") {
					x.setStreetAddress(streetAddress);
				}
				if (city != "-1") {
					x.setCity(city);
				}
				if (state != "-1") {
					x.setState(state);
				}
				if (zipCode != -1) {
					x.setZipCode(zipCode);
				}
				if (billAmount != -1) {
					x.setBillAmount(billAmount);
				}
				break;
			}
		}
		if (!found) {
			System.out.println("Provider does not exist in database.");
		}
	}
	
	@Override
	public String toString() {
		String provText = "";
		for (Provider m: this.providerList) {
			provText += m.toString() + "\n";
		}
		return provText;
	}	
}
