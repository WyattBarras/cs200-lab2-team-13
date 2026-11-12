package application;

public class Service {
	private String serviceName;
	private int serviceCode;
	private double serviceFee;
	private String serviceDesc;
	
	public Service(String serviceName, int serviceCode, double serviceFee, String serviceDesc) {
		this.serviceName = serviceName;
		this.serviceCode = serviceCode;
		this.serviceFee = serviceFee;
		this.serviceDesc = serviceDesc;
	}
	
	public Service() {
		this.serviceName = "null";
		this.serviceCode = 0;
		this.serviceFee = 0.00;
		this.serviceDesc = "null";
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public int getServiceCode() {
		return serviceCode;
	}
	
	public void setServiceCode(int serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	public double getServiceFee() {
		return serviceFee;
	}
	
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	
	public String getServiceDesc() {
		return serviceDesc;
	}
	
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	@Override
	public String toString() {
		if (this.serviceName == "null") {return "Empty slot\n";}
		
		return "Service: " + serviceName + "\n   Code: " + serviceCode + "\n   Fee: " + serviceFee
				+ "\n   Description: " + serviceDesc + "\n";
	}
}
