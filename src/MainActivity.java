import java.util.Scanner;
import models.*;

class MainActivity {
    
    private static Product lays = new Product("Lays Chips", 12.99);
    private static Product fanta = new Product("Fanta Orange", 3);
    private static Product snackBar = new Product("SnackBar Chocolate", 4);
    private static Product peanuts = new Product("Roasted peanuts", 1.3);
    private static Product gummyBear = new Product("Gummy Bears", 2);
    private static Cash cash = new Cash();

    public static void main(String[] args) {
        
        System.out.println("Welcome to Nash Vending Machines.\nPress 0 at anytime to terminate selection");
        initMenu();
        firstMenu();
      
    
    }

    private static void initMenu(){
        Scanner sc = new Scanner(System.in); 
        System.out.
            printf("The Vending machine takes the following denominations. Penny, Dime, Quarter, 1 Dollar, 5 Dollars\n");
        System.out.print("Please indicate each denomination inserted and seperate each value with a comma: ");
        String amounts = sc.next();
        try{
            cash.insertCash(amounts);
        }catch(IndexOutOfBoundsException e){
           // e.printStackTrace();
            System.out.println("Please enter the correct amount of values for money inserted.\nFor blank places enter zero");
            initMenu();
        }catch(NumberFormatException e) {
           // e.printStackTrace();
            System.out.println("Please enter numbers between the commas");
            initMenu();
        }
              
          displayWalletValue();
    }

    private static void displayWalletValue() {
        Scanner walletValue = new Scanner(System.in);
        System.out.println("Enter 0 to continue..");
        String isFinishedInsetMoney = walletValue.next();
        if (isFinishedInsetMoney.equals("0")) {
            cash.totalCash();
            System.out.printf("Wallet: RTGS %.2f\n", cash.getWallet());
        } else {
            System.out.println("Please enter a zero to continue");
            displayWalletValue();
        }
    }
  
    private static void firstMenu(){
        Scanner inputMenu = new Scanner(System.in);
        System.out.println("Please choose what you wanna buy.");
        System.out.printf("1.%s\n2.%s\n3.%s\n4.%s\n5.%s\n6.Cancel order\n", lays.getProductName(),                  fanta.getProductName(),snackBar.getProductName(), peanuts.getProductName(),
            gummyBear.getProductName());        
        String menuOptions = inputMenu.next();
        switch (menuOptions) {
            case "0":
            Product.cancelOrder(cash);
            break;
            case "1":            
                System.out.println(lays.getProductName());
                secondMenu(lays, cash);
                break;
            case "2":
                System.out.println(fanta.getProductName());
                secondMenu(fanta, cash);
                break;
            case "3":
              System.out.println(snackBar.getProductName());
              secondMenu(snackBar, cash);
              break;
            case "4":
                System.out.println(peanuts.getProductName());
                secondMenu(peanuts, cash);
                break;
            case "5":
                System.out.println(gummyBear.getProductName());
                secondMenu(gummyBear, cash);
                break;
            case "6":
                Product.cancelOrder(cash);
                break;
            default:
                System.out.println("Please choose the correct menu option");
                firstMenu();
                break;
        }
       
    }

    private static void secondMenu(Product product, Cash cash){
        Scanner sc = new Scanner(System.in);
        System.out.printf("How much of the %s would you like to buy? ", product.getProductName());
        int numProduct = sc.nextInt();       
        product.setNumberOfProductsBought(numProduct);
        //System.out.println(String.format(""))
        System.out.println("Press 1 to conclude selection, 2 to buy another item or 3 to cancel order. ");
        Scanner menu = new Scanner(System.in);        
        String menuSelection = menu.next();     
        switch(menuSelection){
            case "0":
            Product.cancelOrder(cash);
            break;
            case "1":
                // conclude selection  
                Product.addProductToCart(product);
                MainActivity.finalMenu(cash);
                break;
            case "2":
                // go to first menu
                Product.addProductToCart(product);
                firstMenu();
                break;
            case "3":
                Product.cancelOrder();
                firstMenu();
                break;
            default:
                System.out.println("Please Select correct option");
                break;
       }     
      
    }


    private static void finalMenu(Cash cash){
        if (cash.getWallet() < Product.productTotal()){
            System.out.println("You have insuffcient Funds to perform transaction.");
        }
        else {
            System.out.printf("Thank you for your purchase the total amount used is RTGS %S",  
            String.valueOf(Product.productTotal()));
            String change = String.format("%.2f",(cash.getWallet() - Product.productTotal()));
            System.out.printf(" and your change is RTGS %s", change) ;            
        }
    }

 
   
   
}