package factory;
/**
 * The ProductFactory abstract class represents a factory for creating instances of products.
 * Concrete subclasses must implement the createProduct method to instantiate specific types of products.
 */
public abstract class ProductFactory {
    /**
     * Creates a new product with the specified price and description.
     *
     * @param price       The price of the product.
     * @param description The description of the product.
     * @return A new product object with the given price and description.
     */
    public abstract Product createProduct(double price, String description);
}
