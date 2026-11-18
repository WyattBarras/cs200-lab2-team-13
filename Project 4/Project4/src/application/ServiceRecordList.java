package application;

import java.util.ArrayList;

public class ServiceRecordList {
	private ArrayList<ServiceRecord> servRecordList;

	public ServiceRecordList() {
		this.servRecordList = new ArrayList<ServiceRecord>();
	}
	
	public ServiceRecord getServiceRecord(String servDateTime) {
		for (ServiceRecord s: servRecordList) {
			if (servDateTime == s.getServiceDateTime()) {
				return s;
			}
		}
		System.out.println("Service Record not found");
		return null;
	}
	
	public void addServiceRecord(String curDateTime, String serviceDateTime, int provNum, int memNum, int servCode, String comments) {
		ServiceRecord newRecord = new ServiceRecord(curDateTime, serviceDateTime, provNum, memNum, servCode, comments);
		this.servRecordList.add(newRecord);
	}
	
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
		this.servRecordList.remove(index);
	}

	@Override
	public String toString() {
		String servText = "Service Records: \n";
		for (ServiceRecord s: servRecordList) {
			servText += s.toString();
		}
		return servText + "\n";
	}
}
