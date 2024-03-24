public class Movie{
    String title;
    String barcode;//using string due to some barcodes starting with zeros//
  
    public Movie(String title, String barcode){
      this.title = title;
      
      if(barcode.length() < 12 || barcode.length() > 12){
        System.out.println("Invalid barcode");
      }
      else{
        this.barcode = barcode;
      }
    }
  
    public String getTitle(){
      return title;
    }
  
    public String getBarcode(){
      return barcode;
    }
 }