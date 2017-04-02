package db;

import model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Mocks the database
 */
public class Database {

    /** List of available products*/
    private Map<String, Product> products;

    /**
     * Populates DB from the List
     * @param products List of products
     */
    public Database(Map<String, Product> products) {
        this.products = products;
    }

    /**
     * Populates DB from the file
     * @param path Name of the file with data set
     */
    public Database(String path){

        products = new HashMap<>();

        populateDataBaseFromFile(path);
    }

    /**
     * Populates DB from the path file
     * @param path
     */
    private void populateDataBaseFromFile(String path) {
        List<String> lines = new ArrayList<>();

        lines = getLines(path);

        List<String> splittedString = new ArrayList<>();

        for(int i = 0; i < lines.size(); i++) {
            splittedString = Arrays.stream(lines.get(i).split(" ")).collect(Collectors.toList());

            String barCode = splittedString.get(0);
            String name = splittedString.get(1);
            Double price = Double.parseDouble(splittedString.get(2));
            products.put(barCode, new Product(name, price));
        }
    }

    /**
     * Gets List of Products with barCode, name and price from the file
     * @param path Name of the file
     * @return List of string containing information about the product
     */
    private List<String> getLines(String path){
        List<String> lines = new ArrayList<>();

        try (InputStream is = getFileInputStream(path)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error occured while opening the file " + path);
            throw new RuntimeException(e);
        }
        return lines;
    }

    /**
     * Returns input stream of resources
     * @param path Path to resources
     * @return Input stream of resource
     */
    private InputStream getFileInputStream(String path) {
        return Database.class.getClassLoader().getResourceAsStream(path);
    }


    /**
     * Creates new db entry
     * @param barCode Product bar code
     * @param product Product
     */
    public void addNewEntry(String barCode, Product product){
        products.put(barCode, product);
    }

    /**
     * Prints DB products with barCodes
     */
    public void printDBEntries(){
        products.forEach((k, v)-> System.out.println("Item : " + k + " Product : " + v));
    }

    /**
     * Checks whether DB contains product or not
     * @param barCode Bar code for the specific product
     * @return True if contains the product, otherwise returns false
     */
    public Product containsProduct(String barCode){

        if(products.containsKey(barCode))
            return products.get(barCode);
        return null;
    }

}
