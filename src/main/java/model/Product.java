package model;

/**
 * Sales product
 */
public class Product {
    /** name of the product*/
    private String name;
    /** price of the product*/
    private double price;

    /**
     * Creates new product
     * @param name name of the product
     * @param price price of the product
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Getter for the name of the product
     * @return name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the product
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the price of the product
     * @return price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for the price of the product
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}
