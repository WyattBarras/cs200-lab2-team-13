package application;

public class ServiceRecord {
	private String curDateTime;
	private String serviceDateTime;
	private int provNum;
	private int memNum;
	private int servCode;
	private String comments;
	
	public ServiceRecord(String curDateTime, String serviceDateTime, int provNum, int memNum, int servCode, String comments) {
		super();
		this.curDateTime = curDateTime;
		this.serviceDateTime = serviceDateTime;
		this.provNum = provNum;
		this.memNum = memNum;
		this.servCode = servCode;
		this.comments = comments;
	}
	
	public String getCurDateTime() {
		return curDateTime;
	}
	public void setCurDateTime(String curDateTime) {
		this.curDateTime = curDateTime;
	}
	public String getServiceDateTime() {
		return serviceDateTime;
	}
	public void setServiceDateTime(String serviceDateTime) {
		this.serviceDateTime = serviceDateTime;
	}
	public int getProvNum() {
		return provNum;
	}
	public void setProvNum(int provNum) {
		this.provNum = provNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getServCode() {
		return servCode;
	}
	public void setServCode(int servCode) {
		this.servCode = servCode;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean verifyServiceCode(ProviderDirectory provDir) {
		boolean verify = false;
		if (provDir.getService(this.servCode) != null) {
			verify = true;
		}
		return verify;
	}
	
	@Override
	public String toString() {
		return curDateTime + "\n" + serviceDateTime + "\n" + provNum + "\n" + memNum + "\n" + servCode + "\n" + comments + "\n";
	}
	
	
	
}
