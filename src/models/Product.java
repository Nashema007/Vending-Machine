package models;

import java.util.ArrayList;

public class Product {
    
private double price;
private String productName;
private int numberOfProductsBought;
private static ArrayList<Product> productList = new ArrayList<>();

/**
 * empty constructor
 */
public Product(){}
/**
 * 
 * @param productName
 * @param price
 * @param numberOfProductsBought
 */
public Product(String productName, double price){
    this.price = price;
    this.productName = productName;
    this.numberOfProductsBought = 0;

}
/**
 * 
 * @param numberOfProductsBought
 */
public void setNumberOfProductsBought(int numberOfProductsBought){
    this.numberOfProductsBought = numberOfProductsBought;
}

    /**
     * @return the price
     */
public double getPrice(){
    return price;
}

 /**
 * @return the numberOfProductsBought
 */
public int getNumberOfProductsBought() {
    return numberOfProductsBought;
}

 /**
 * @return the productName
 */
public String getProductName() {
    return productName;
}

/**
 * 
 * @return Product of product price and units bought
 */
public double calTotalAmountDue(){
return getPrice() * getNumberOfProductsBought();
}


    /**
     * 
     * @return the total cost of all products in cart
     */
    public static double productTotal() {
        double total = 0;
        for (int i = 0; i < productList.size(); i++) {
            total += productList.get(i).calTotalAmountDue();
        }
        return total;
    }

  
    public static void addProductToCart(Product product) {
        productList.add(product);
    }

    public static void cancelOrder(Cash cash){
        if(!productList.isEmpty()){
            productList.clear();
        }

        System.out.println(String.format("Selection has been terminated. Please collect your RTGS %.2f from the tray.", cash.getWallet()));
    }
    public static void cancelOrder(){
        if(!productList.isEmpty()){
            productList.clear();
        }
               
    }

    @Override
    public String toString() {
        return "Product: " + getProductName() + "\n Price: " + getPrice() + "\n Amount Bought: "
                + getNumberOfProductsBought();

    }

    public static void main(String[] args) {
        Product product = new Product();
        product.toString();
    }
}