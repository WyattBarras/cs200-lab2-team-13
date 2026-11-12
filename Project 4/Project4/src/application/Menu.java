package application;

public class Menu {
	private String menuText;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setMenuText(String role) {
		if (role == "manager") {
			menuText = "Manager Login:\n\tID Number: ";
		} else if (role == "operator") {
			menuText = "Operator Login:\n\tID Number: ";
		} else if (role == "provider") {
			menuText = "Provider Login:\n\tProvider Number: ";
		} else {
			System.out.println("Invalid role");
		}
	}
	
	@Override
	public String toString() {
		return menuText;
	}
}
