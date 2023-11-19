package factory;

import products.TV;
/**
 * The TVFactory class is a concrete subclass of ProductFactory.
 * It specializes in creating instances of the TV product.
 */
public class TVFactory extends ProductFactory{
    /**
     * Creates a new TV product with the specified price and description.
     *
     * @param price       The price of the TV.
     * @param description The description of the TV.
     * @return A new TV object with the given price and description.
     */
    @Override
    public Product createProduct(double price, String description) {
        return new TV(price,description);
    }
}
