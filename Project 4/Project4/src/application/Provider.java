package application;

public class Provider extends Client {
   private double billAmount;

   // Standard constructor, inheriting Client instance variables
   public Provider(int number, String name, String streetAddress, String city, String state, int zipCode, double billAmount) {
      super(number, name, streetAddress, city, state, zipCode);
      this.billAmount = billAmount;
   }
   
   public Provider() {
	  super();
	  this.billAmount = -1;
   }

   public double getBillAmount() {
      return this.billAmount;
   }

   public void setBillAmount(double billAmount) {
      this.billAmount = billAmount;
   }
   
   @Override
   // basic toString() matching format Providers are read in
   public String toString() {
	   return number + "\n" + name + "\n" + streetAddress + "\n" + city + "\n" + state + " " + zipCode + " "
			   + billAmount;
   }
}
