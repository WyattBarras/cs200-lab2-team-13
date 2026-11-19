package application;

import java.util.ArrayList;

public class ProviderList {
	ArrayList<Provider> providerList;
	
	// Standard constructor
	public ProviderList(){
		this.providerList = new ArrayList<Provider>();
	}
	
	public int size() {
		return this.providerList.size();
	}
	
	// returns arrayList for use in accounting report
	public ArrayList<Provider> getProviderList() {	
		return this.providerList;
	}
	
	// searches for Provider by number, if not found, prints error message and returns null
	public Provider getProvider(int idNum) {
		for(Provider x:this.providerList) {
			if(x.getNumber() == idNum) {
				return x;
			}
		}
		System.out.println("Provider not found in list.");
		return null;
	}
	
	// Same as above, but returns name of found provider, empty string if not found
	public String getProviderName(int provNum) {
		String name = "";
		for (Provider p : providerList) {
			if(p.getNumber() == provNum) {
				name = p.getName();
			}
		}
		return name;
	}
	
	// Adds Provider (created using standard constructor) to end of providerList
	public void addProvider(int number, String name, String streetAddress, String city, String state, int zipCode, double billAmount) {
		Provider next = new Provider(number, name, streetAddress, city, state, zipCode, billAmount);
		this.providerList.add(next);
	}
	
	// searches of Provider by number, if found, removes at the relevant index of providerList
	// if not found, print error message and return
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
		if (index == -1) { System.out.println("Provider does not exist."); return; }
		this.providerList.remove(index);
	}
	
	// looks for Provider by number, if found update relevant data members (-1 for no change)
	// if not found display error message
	public void updateProviderRecords(int number, String name, String streetAddress, String city, String state, int zipCode, double billAmount) {
		boolean found = false;
		for(Provider x:this.providerList) {
			if(x.getNumber() == number) {
				found = true;
			}
			if(found) {
				if (name.contains("-1")) {
				} else { x.setName(name); }
				
				if (streetAddress.contains("-1")) {
				} else { x.setStreetAddress(streetAddress); }
				
				if (city.contains("-1")) {
				} else { x.setCity(city); }
				
				if (state.contains("-1")) {
				} else { x.setState(state); }
				
				if (zipCode == -1) {
				} else { x.setZipCode(zipCode); }
				
				if (billAmount == -1) {
				} else { x.setBillAmount(billAmount); }
				break;
			}
		}
		if (!found) {
			System.out.println("Provider does not exist in database.");
		}
	}
	
	@Override
	// basic toString() following format Providers are read in, ensuring writing does not mess up future reading
	public String toString() {
		String provText = "";
		for (Provider m: this.providerList) {
			provText += m.toString() + "\n";
		}
		return provText;
	}	
}
