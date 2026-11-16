package application;

public class Provider extends Client {
   private int billAmount;

   public Provider(int number, String name, String streetAddress, String city, String state, int zipCode, int billAmount) {
      super(number, name, streetAddress, city, state, zipCode);
      this.billAmount = billAmount;
   }
   
   public Provider() {
	  super();
	  this.billAmount = -1;
   }

   public int getBillAmount() {
      return this.billAmount;
   }

   public void setBillAmount(int billAmount) {
      this.billAmount = billAmount;
   }
}
