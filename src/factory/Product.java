package factory;
/**
 * The Product interface represents a generic product.
 * It defines methods for displaying information, getting the price, and getting the description of the product.
 */
public interface Product {

    /**
     * Displays information about the product.
     */
    void displayInfo();
    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    double getPrice();
    /**
     * Gets the description of the product.
     *
     * @return The description of the product.
     */
    String getDescription();
}
