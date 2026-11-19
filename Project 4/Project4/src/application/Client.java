package application;

public class Client {
   protected int number;
   protected String name;
   protected String streetAddress;
   protected String city;
   protected String state;
   protected int zipCode;

   // Standard constructor
   public Client(int number, String name, String streetAddress, String city, String state, int zipCode) {
      this.number = number;
      this.name = name;
      this.streetAddress = streetAddress;
      this.city = city;
      this.state = state;
      this.zipCode = zipCode;
   }
   
   // Default constructor
   public Client() {
	  this.number = -1;
	  this.name = "null";
	  this.streetAddress = "null";
	  this.city = "null";
	  this.state = "null";
	  this.zipCode = -1;
   }

   // Getters and setters
   public int getNumber() {
      return this.number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getStreetAddress() {
      return this.streetAddress;
   }

   public void setStreetAddress(String streetAddress) {
      this.streetAddress = streetAddress;
   }

   public String getCity() {
      return this.city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return this.state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public int getZipCode() {
      return this.zipCode;
   }

   public void setZipCode(int zipCode) {
      this.zipCode = zipCode;
   }
}
