public class Rental{
  Customer customer;
  Storage movie;
  Rental[] rentalsout;
  int rentalCount = 0;
  String firstName;
  String lastName;
  long phoneNumber;
  String title;
  String barcode;

  public Rental(){
    rentalsout = new Rental[100];
    if(rentalsout.length > 100){
      rentalsout = new Rental[rentalsout.length + 100];
    }
  }

  public Rental(String firstName, String lastName, long phoneNumber, String title, String barcode){
    this.firstName = firstName;
    this.lastName = lastName;
    if(Long.toString(phoneNumber).length() > 10 || Long.toString(phoneNumber).length() < 10){
      System.out.println("Invalid phone number.");
    }
    if(barcode.length() > 12 || barcode.length() < 12){
      System.out.println("Invalid barcode.");
    }
    this.phoneNumber = phoneNumber;
    this.title = title;
    this.barcode = barcode;
  }
  
  

  public void addRental(){
    rentalCount++;
    if (rentalCount > 3){
      System.out.println("You have reached the maximum number of rentals.");
    }
  }

  public void rentOut(long phoneNumber, String barcode){
    for(int i = 0; i < rentalsout.length; i++){
      if(rentalsout[i] != null && rentalsout[i].getPhoneNumber() == phoneNumber){
        getRentalCount();//retrieves the persons rental count
        if(rentalsout[i].getRentalCount() > 3){
          System.out.println("Customer has reached max rentals allowed");
        }
      }
      else{
        if(rentalsout[i] != null){
          movie.remove(barcode);
          rentalCount++;
          System.out.println("Movie rented!");
        }
      }
    }
  }

  public int getRentalCount() {
    return rentalCount;
 }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void returnMovie(long phoneNumber, String barcode){
        boolean isRented = checkRental();
        if(isRented){
          Movie returnedMovie = movie.getMovie(barcode);
        if(returnedMovie == null){
          movie.add(returnedMovie);
          rentalCount--;
          System.out.println("Movie returned!");
        }
        else{
        System.out.println("Movie not rented by this customer.");
        }
      }
    }

  public boolean checkRental(){
    if(rentalCount > 0){
      for(int i = 0; i < rentalsout.length; i++){
        if(rentalsout[i].getPhoneNumber() == phoneNumber && rentalsout[i].getBarcode() == barcode){
          return true;
        }
      }
    }
    return false;
  }

    public void checkRentals(String title){
      boolean found = false;
        for(int i = 0; i < rentalsout.length; i++){
          if( rentalsout[i] != null && rentalsout[i].getTitle().equals(title)){
            found = true;
            System.out.println("Rented out by: " + rentalsout[i].getFirstName() + " " + rentalsout[i].getLastName() + rentalsout[i].getphoneNumber());
            break;
          }
        
        }

        if(!found){
          System.out.println("Movie not rented out");
        }
    }

    public String getTitle() {
        return title;
    }

    public long getphoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getBarcode() {
        return barcode;
    }

  
}