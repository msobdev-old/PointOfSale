package service;

import db.Database;
import model.Order;
import model.Product;

/**
 * Created by sob1 on 02.04.2017.
 */
public class PointOfSale {

    /** DataBase*/
    private Database db;

    /** Current client order*/
    private Order order;

    /** Error input message*/
    private String errorMsg = "";

    /**
     * Creates simple point of sale
     * @param db Database
     * @param order Order
     */
    public PointOfSale(Database db, Order order) {
        this.db = db;
        this.order = order;
    }

    /**
     * Find Product in db and adds to Order list
     * @param barCode Product Bar code
     */
    public void scanTheProduct(String barCode){

        if(barCode == ""){
            errorMsg = "Invalid bar-code";
            printErrorOnLCD();
            return;
        }else if(barCode == "exit"){
            printOnPrinter();
            printOnLCD();
            return;
        }

        Product prod = db.containsProduct(barCode);

        if(prod == null){
            errorMsg = "Product not found";
            printErrorOnLCD();
        }else{
            order.addProduct(prod);
            printOnLCD(prod);
        }
    }

    /**
     * Mocks LCD display with error message
     */
    private void printErrorOnLCD(){
        System.out.println("LCD DISPLAY");
        System.out.println(errorMsg);
        System.out.println("-----------");
    }

    /**
     * Mocks LCD display and prints product details
     * @param product
     */
    private void printOnLCD(Product product){
        System.out.println("LCD DISPLAY");
        System.out.println(product);
        System.out.println("-----------");
    }

    /**
     * Mocks LCD display and prints total cost
     */
    private void printOnLCD(){
        System.out.println("LCD DISPLAY");
        System.out.println("Total amount of money: " + order.getTotalAmount());
        System.out.println("-----------");
    }

    /**
     * Prints on printer all ordered products and cost
     */
    private void printOnPrinter(){
        System.out.println("PRINTER");
        order.printOrder();
        System.out.println("Total amount of money: " + order.getTotalAmount());
        System.out.println("-----------");
    }
}
