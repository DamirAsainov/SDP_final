package factory;

import products.Laptop;
import products.Phone;
/**
 * The PhoneFactory class is a concrete subclass of ProductFactory.
 * It specializes in creating instances of the Phone product.
 */
public class PhoneFactory extends ProductFactory{
    /**
     * Creates a new Phone product with the specified price and description.
     * @param price       The price of the Phone.
     * @param description The description of the Phone.
     * @return A new Phone object with the given price and description.
     */
    @Override
    public Product createProduct(double price, String description) {
        return new Phone(price,description);
    }
}
