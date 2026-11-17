package application;

public class Member extends Client {
   private int accountBalance;
   private boolean memberStatus;

   public Member(int number, String name, String streetAddress, String city, String state, int zipCode, int accountBalance, boolean memberStatus) {
      super(number, name, streetAddress, city, state, zipCode);
      this.accountBalance = accountBalance;
      this.memberStatus = memberStatus;
   }
   
   public Member() {
	  super();
	  this.accountBalance = -1;
	  this.memberStatus = false;
   }

   public int getAccountBalance() {
      return this.accountBalance;
   }

   public void setAccountBalance(int accountBalance) {
      this.accountBalance = accountBalance;
   }

   public boolean getMemberStatus() {
      return this.memberStatus;
   }

   public void setMemberStatus(boolean memberStatus) {
      this.memberStatus = memberStatus;
   }

   @Override
   public String toString() {
	   return number + "\n" + name + "\n" + streetAddress + "\n" + city + "\n" + state + " " + zipCode + " "
			   + accountBalance + " " + memberStatus;
   }
   
   
}
