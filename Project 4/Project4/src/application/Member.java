package application;

public class Member extends Client {
   private double accountBalance;
   private boolean memberStatus;

   // Standard constructor, inherits Client instance variables
   public Member(int number, String name, String streetAddress, String city, String state, int zipCode, double accountBalance, boolean memberStatus) {
      super(number, name, streetAddress, city, state, zipCode);
      this.accountBalance = accountBalance;
      this.memberStatus = memberStatus;
   }
   
   public Member() {
	  super();
	  this.accountBalance = -1;
	  this.memberStatus = false;
   }

   public double getAccountBalance() {
      return this.accountBalance;
   }

   public void setAccountBalance(double accountBalance) {
      this.accountBalance = accountBalance;
   }

   public boolean getMemberStatus() {
      return this.memberStatus;
   }

   public void setMemberStatus(boolean memberStatus) {
      this.memberStatus = memberStatus;
   }

   @Override
   // basic toString for writing to files in the same way Members are read from files
   public String toString() {
	   return number + "\n" + name + "\n" + streetAddress + "\n" + city + "\n" + state + " " + zipCode + " "
			   + accountBalance + " " + memberStatus;
   }
   
   
}
