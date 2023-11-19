package factory;

import products.Laptop;
/**
 * The LaptopFactory class is a concrete subclass of ProductFactory.
 * It specializes in creating instances of the Laptop product.
 */
public class LaptopFactory extends ProductFactory{
    /**
     * Creates a new Laptop product with the specified price and description.
     *
     * @param price       The price of the Laptop.
     * @param description The description of the Laptop.
     * @return A new Laptop object with the given price and description.
     */
    @Override
    public Product createProduct(double price, String description) {
        return new Laptop(price,description);
    }
}
