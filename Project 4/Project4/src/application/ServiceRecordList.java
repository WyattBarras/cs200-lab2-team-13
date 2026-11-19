package application;

import java.util.ArrayList;

public class ServiceRecordList {
	private ArrayList<ServiceRecord> servRecordList;

	// Standard constructor
	public ServiceRecordList() {
		this.servRecordList = new ArrayList<ServiceRecord>();
	}
	
	// looks for service record by date/time of service, if not found return null
	public ServiceRecord getServiceRecord(String servDateTime) {
		for (ServiceRecord s: servRecordList) {
			if (servDateTime == s.getServiceDateTime()) {
				return s;
			}
		}
		System.out.println("Service Record not found");
		return null;
	}
	
	// adds new ServiceRecord to end of servRecordList using standard constructor
	public void addServiceRecord(String curDateTime, String serviceDateTime, int provNum, int memNum, int servCode, String comments) {
		ServiceRecord newRecord = new ServiceRecord(curDateTime, serviceDateTime, provNum, memNum, servCode, comments);
		this.servRecordList.add(newRecord);
	}
	
	// Same as remove functions in MemberList, ProviderList
	public void removeMember(String servDateTime) {
		int index = -1;
		int i = 0;
		for(ServiceRecord x:this.servRecordList) {
			if(x.getServiceDateTime() == servDateTime) {
				index = i;
				break;
			}
			i++;
		}
		if (index == -1) { System.out.println("Service record not found"); }
		this.servRecordList.remove(index);
	}

	@Override
	// Same as toString() in MemberList, ProviderList
	public String toString() {
		String servText = "";
		for (ServiceRecord s: servRecordList) {
			servText += s.toString();
		}
		return servText + "\n";
	}

	// Returns servRecordList for use in accounting reports
	public ArrayList<ServiceRecord> getRecords() {
		return this.servRecordList;
	}
}
