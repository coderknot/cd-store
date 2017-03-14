import java.io.Console;
import java.util.List;
import java.util.ArrayList;

public class App{
  public static void main(String[] args){
    Console myConsole = System.console();
    CD rem = new CD ("REM", "Darkside", 1995, 20);
    CD metallica = new CD ("Metallica", "Self-Titled", 1989, 18);
    CD kanye = new CD ("Kanye", "All About Me", 2012, 100);
    CD swift = new CD ("Taylor Swift", "1989", 2013, 17);
    List<CD> allCD = new ArrayList<CD>();
    allCD.add(rem);
    allCD.add(metallica);
    allCD.add(kanye);
    allCD.add(swift);


    boolean youShopping = true;

    while (youShopping){
      System.out.println("Welcome to CD store. What would you like to do?"+"\n"+"1 - See all CDs"+"\n"+"2 - Search by Release Year"+"\n"+"3 - Search by price"+"\n"+"4 - See all artists"+"\n"+"5 - Enter Coupon Code"+"\n"+"6 - Leave Store"+"\n");

      int userChoice = Integer.parseInt(myConsole.readLine());

      if(userChoice == 1) {
        displayCD(allCD);
      } else if (userChoice == 2) {
        searchByReleaseYear(allCD);
      } else if (userChoice == 3) {
        searchByPrice(allCD);
      } else if (userChoice == 5) {
        couponCheck(allCD);
      } else {
        System.out.println("Not a valid choice!");
      }

    }
  }

  public static void displayCD(List<CD> allCD){
    System.out.println("");
    for (CD eachCD: allCD){
      System.out.println(eachCD.mAlbumName + " by " + eachCD.mArtistName + ", released "+ eachCD.mReleaseYear +", $" + eachCD.mPrice);
    }
    System.out.println("");
  }

  public static void searchByReleaseYear(List<CD> allCD) {
    Console yearConsole = System.console();

    System.out.println("Enter year: ");
    int year = Integer.parseInt(yearConsole.readLine());

    List<CD> yearList = new ArrayList<CD>();

    for(CD eachCD : allCD) {
      if(eachCD.mReleaseYear == year) {
        yearList.add(eachCD);
      }
    }
    displayCD(yearList);
  }

  public static void searchByPrice(List<CD> allCD) {
    Console priceConsole = System.console();

    System.out.println("Enter low Price: ");
    int lowPrice = Integer.parseInt(priceConsole.readLine());
    System.out.println("Enter high Price: ");
    int highPrice = Integer.parseInt(priceConsole.readLine());

    List<CD> priceList = new ArrayList<CD>();

    for(CD eachCD : allCD) {
      if(lowPrice <= eachCD.mPrice && highPrice >= eachCD.mPrice) {
        priceList.add(eachCD);
      }
    }
    displayCD(priceList);
  }

  public static void couponCheck(List<CD> allCD) {
    Console couponConsole = System.console();

    System.out.println("Enter Coupon Code: ");
    String code = couponConsole.readLine();

    List<CD> couponList = new ArrayList<CD>();
    for (CD eachCD: allCD) {
      couponList.add(new CD(eachCD));
    }

    for(CD eachCD : couponList) {
      if(code.equals("ten")) {
        eachCD.mPrice *= .9;
      } else if (code.equals("20")) {
        eachCD.mPrice *= .8;
      } else if (code.equals("special")) {
        eachCD.mPrice *= .7;
      }
    }
    displayCD(couponList);
  }
}
