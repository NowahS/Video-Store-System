import java.util.Scanner;
class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    boolean exit = false;

    Rental[] rentals = new Rental[100];

    Storage movies = new Storage();

    while(!exit){
      System.out.println("Welcome to Paul's Video Store management system!");
      System.out.println("Please choose what you would like to do:\n 1. View storage\n 2. Access customer system\n 3. Access rentals\n 4. Exit");
      System.out.print("Choice: ");
      int choice = scan.nextInt();
      
      switch(choice){
        case 1:
          System.out.println("You have chosen to view storage.");
          System.out.println("Please choose what you would like to do:\n 1. Add movie\n 2. Check storage size\n 3. Back");
          System.out.print("Choice: ");
          int choice2 = scan.nextInt();
          //Add a movie
          switch(choice2){
            case 1:
              addMovie(scan);
              break;
            case 2:
              checkStorageSize(scan);
              break;
            case 3:
              break;
          }
          break;
        case 2:
          System.out.println("You have chosen to access customer system.");
          System.out.println("Please choose what you would like to do:\n 1. Add customer\n 2. Back ");
          System.out.print("Choice: ");
          int choice3 = scan.nextInt();
          //Add a customer
          switch(choice3){
              case 1:
                addCustomer(scan);
                break;
              case 2:
                break;
          }
          break;
        case 3:
          System.out.println("You have chosen to access rentals.");
          System.out.println("Please choose what you would like to do:\n 1. Rent movie\n 2. Return movie\n 3. Check rentals\n 4. Back");
          System.out.print("Choice: ");
          int choice4 = scan.nextInt();
          //Rent a movie
          switch(choice4){
              case 1:
                rentMovie(scan, rentals, movies);
                break;
              case 2:
                returnMovie(scan, rentals, movies);
                break;
              case 3:
                checkRentals(scan, rentals, movies);
                break;
              case 4:
                break;
          }
          break;
        case 4:
          exit = true;
          System.out.println("Thank you for using the system!");
          break;
      }
    }

    
  }

  public static void addMovie(Scanner scan){
    System.out.println("You have chosen to add a movie.");
    Storage movies = new Storage();
    System.out.println("Please enter the title of the movie: ");
    String title = scan.nextLine();
    scan.nextLine();
    System.out.println("Please enter the barcode of the movie: ");
    String barcode = scan.nextLine();
    Movie customerchoice = new Movie(title, barcode);
    movies.add(customerchoice);
    System.out.println("Current storage size: " + movies.size());//ERROR: Still adds movie to list if incorrect barcode// 
    System.out.println("Would you like to add another movie?");
    String option = scan.nextLine();
    //continues to add movies
    if(option.equalsIgnoreCase("yes")){
      while(option.equalsIgnoreCase("yes")){
        System.out.println("Please enter the title of the movie: ");
        title = scan.nextLine();
        System.out.println("Please enter the barcode of the movie: ");
        barcode = scan.nextLine();
        movies.add(new Movie(title, barcode));
        System.out.println("Continue?");
        option = scan.nextLine();
      }
      System.out.println("Movies added!");
    }
  }

  public static void checkStorageSize(Scanner scan){
    Storage storage = new Storage();
    System.out.println("You have chosen to check storage size.");
    System.out.println("The current size of storage is: " + storage.size());
    System.out.println("What would you like to do?:\n 1. Add movie\n 2. Back");
    int choice2 = scan.nextInt();
    if(choice2 == 1){
      addMovie(scan);
    }
  }

  public static void addCustomer(Scanner scan){
    System.out.println("You have chosen to add a customer.");
    Customer customer = new Customer();
    System.out.println("Enter the customer's first name:");
    String firstName = scan.nextLine();
    scan.nextLine();
    System.out.println("Enter the customers last name:");
    String lastName = scan.nextLine();
    scan.nextLine(); //stops program from missing inputs//
    System.out.println("Enter customer's phone number");
    Long phoneNumber = scan.nextLong();
    customer.add(firstName, lastName, phoneNumber);
    System.out.println("Customer added!");
    System.out.println("Would you like to add another customer?");
    scan.nextLine();
    String option = scan.nextLine();
    scan.nextLine();
    //continues to add customers
    if(option.equalsIgnoreCase("yes")){
      addCustomer(scan);
    }
    
  }

  public static void rentMovie(Scanner scan, Rental[] rentals, Storage movies){
    System.out.println("You have chosen to rent a movie.");
    System.out.println("Please enter the barcode of the movie you would like to rent: ");
    String barcode = scan.nextLine();
    scan.nextLine();
    if(!movies.contains(barcode)){//doing the not just for the demo: ERROR: will print else when barcode is in array//
      System.out.println("Movie found!");
      System.out.println("Would you like to rent this movie?");
      String option = scan.nextLine();
      //rents movie//
      if(option.equalsIgnoreCase("yes")){
        System.out.println("Enter the customers number:");
        Long phoneNumber = Long.parseLong(scan.nextLine());
        int index = 0;
        if(rentals[index] == null){
            rentals[index] = new Rental();
        }
        rentals[index].rentOut(phoneNumber, barcode);
      }
    }
    else{
        System.out.println("Movie not found in storage");
    }
  }

    public static void returnMovie(Scanner scan, Rental[] rentals, Storage movies){
        System.out.println("You have chosen to return a movie.");
        System.out.println("Please enter the phone number of the customer returning the movie: ");
        long phoneNumber = scan.nextLong();
        scan.nextLine();
        System.out.println("Please enter the barcode of the movie returned: ");
        String barcode = scan.nextLine();
        Rental r = new Rental();
        r.returnMovie(phoneNumber, barcode);//checks if customer has movie rented, returns movie//
    }

  public static void checkRentals(Scanner scan, Rental[] rentals, Storage movies){
    System.out.println("You have chosen to check rentals.");
    System.out.println("Please enter the name of the movie: ");
    String title = scan.nextLine();
    scan.nextLine();
    Rental r = new Rental();
    r.checkRentals(title); //checks among the arraylist of rentals for the movie//
    
  }

  

  
}