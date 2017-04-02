package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps track of all scanned Products
 */
public class Order {

    /** Total sum of money for products*/
    private double totalAmount = 0;

    /** Product list*/
    private List<Product> productList;

    /**
     * Creates empty order list
     */
    public Order() {
        this.productList = new ArrayList<>();
    }

    /**
     * Creates new list of products and sums the total cost
     * @param productList
     */
    public Order(List<Product> productList) {
        this.productList = productList;
        this.totalAmount = productList.stream().mapToDouble(o -> o.getPrice()).sum();
    }

    /**
     * Adds new product to the current list
     * @param prod Product
     */
    public void addProduct(Product prod){
        productList.add(prod);
        totalAmount += prod.getPrice();
    }

    /**
     * Prints order list
     */
    public void printOrder(){
        productList.forEach(o -> System.out.println(o));
    }

    /**
     * Getter on Cost
     * @return total cost
     */
    public double getTotalAmount() {
        return totalAmount;
    }
}
