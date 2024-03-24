public class Storage{
  Movie[] list;

  public Storage(){
    list = new Movie[100];
  
    list[0] = new Movie("The Matrix", "883929116966");
    list[1] = new Movie("Star Wars", "086162113031");
    list[2] = new Movie("Avengers", "786936826487");
    list[3] = new Movie("The Cat in the Hat", "025192147623");
    list[4] = new Movie("Avatar", "024543713678");
    list[5]= new Movie("Shrek", "024543009597");
    list[6] = new Movie("The Lion King", "786936853742");
    list[7] = new Movie("Madagascar", "032429146663");
    list[8] = new Movie("The Grinch", "025192309311");
 }
  public  int size(){
    int count = 0;
    for(Movie movie : list){
      if(movie != null){
        count++;
      }
    }
    return count;
  }

  public void remove(String barcode){
    for(int i = 0; i < list.length; i++){
        if(list[i] != null && list[i].getBarcode().equals(barcode)){
            list[i] = null;
        }
    }
    return;
  }

  public String getTitle(String barcode){
   for(Movie movie : list){
    if (movie != null && movie.getBarcode().equals(barcode)){
        return movie.getTitle();
    }
   }
   return null;
  }
  
  public void add(Movie movie) {
    //if(movie.getBarcode().length() != 12){
      //System.out.println("Movie cannot be added"); --> Error: throws an exception due to Movie being null
    //}
    //else{
      for(int i = 0; i < list.length; i++){
        if(list[i] == null){
            list[i] = movie;
            break;
        }
      }
    //}
  }

  public boolean contains(String barcode){
    for(int i = 0; i < list.length; i++){
      if(list[i] != null){
        System.out.println("Checking for barcode:" + list[i].getBarcode());
        if(list[i].getBarcode().equals(barcode)){
          return true;
        }
      }
    }
    return false;
  }

  public Movie getMovie(String barcode){
    for( int i = 0; i < list.length; i++){
      if(list[i].getBarcode().equals(barcode)){
        return list[i];
      }
    }
    return null;
  }

}