public class Customer{
  String firstName, lastName;
  long phoneNumber;
  Customer[] list;

  public Customer(){
    list = new Customer[100];
    if(list.length > 100){
      list = new Customer[100 + 100];
    }
  }
  
  public Customer(long phoneNumber, String firstName, String lastName){
      this.firstName = firstName;
      this.lastName = lastName;
    if(Long.toString(phoneNumber).length() < 10 || Long.toString(phoneNumber).length() > 10){
      System.out.println("Invalid phone number");
    }
    else{
      this.phoneNumber = phoneNumber;
    }
  }

  public void add(String firstName, String lastName, long phoneNumber){
    for(int i = 0; i < list.length; i++){
      if(list[i] == null){
        list[i] = new Customer(phoneNumber, firstName, lastName);
        break;
      }
    }
  }

  public String getName(){
    return firstName + " " + lastName;
  }

  public long getphoneNumber(){
    return phoneNumber;
  }
}
