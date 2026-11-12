package application;

public class Menu {
	private String[] menuText;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setMenuText(String role) {
		if (role == "manager") {
			
		} else if (role == "operator") {
			
		} else if (role == "provider") {
			
		} else {
			System.out.println("Invalid role: ");
		}
	}
	
}
