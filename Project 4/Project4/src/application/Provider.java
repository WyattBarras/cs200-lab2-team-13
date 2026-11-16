package application;

public class Provider extends Client {
   private int billAmount;

   Provider(int number, String name, String streetAddress, String city, String state, int zipCode, int billAmount) {
      super(number, name, streetAddress, city, state, zipCode);
      this.billAmount = billAmount;
   }

   public int getBillAmount() {
      return this.billAmount;
   }

   public void setBillAmount(int billAmount) {
      this.billAmount = billAmount;
   }
}
