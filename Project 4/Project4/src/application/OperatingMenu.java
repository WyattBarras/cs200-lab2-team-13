package application;

public class OperatingMenu {
	private int role;
	private int opID;
	private String menuText;

	public OperatingMenu(int role, int opID) {
		this.role = role;
		this.opID = opID;
	}
	
	public void generateOperatingMenu() {
		if (this.role == 1) {
			menuText += ("Hello Manager " + this.opID + "!\n");
			menuText += "  Available Functions: \n";
			menuText += "   (1) Add Member\n";
			menuText += "   (2) Delete Member\n";
			menuText += "   (3) Update Member\n";
			menuText += "   (4) Add Provider\n";
			menuText += "   (5) Delete Provider\n";
			menuText += "   (6) Update Provider\n";
			menuText += "   (7) Run Accounting Report\n";
			menuText += "   (8) Run Manager Report\n";
			menuText += "   (9) Quit\n";
		} else if (this.role == 2) {
			menuText += ("Hello Operator " + this.opID + "!\n");
			menuText += "  Available Functions: \n";
			menuText += "   (1) Add Member\n";
			menuText += "   (2) Delete Member\n";
			menuText += "   (3) Update Member\n";
			menuText += "   (4) Add Provider\n";
			menuText += "   (5) Delete Provider\n";
			menuText += "   (6) Update Provider\n";
			menuText += "   (9) Quit\n";
		} else if (this.role == 3) {
			menuText += ("Hello Operator " + this.opID + "!\n");
			menuText += "  Available Functions: \n";
			menuText += "   (1) Write Service Record";
			menuText += "   (2) Process Transaction";
			menuText += "   (9) Quit\n";
		}
	}

	public void displayMenu() {
		System.out.println(this.menuText);
	}
	
	
}
