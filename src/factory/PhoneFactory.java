package factory;

import products.Laptop;
import products.Phone;

public class PhoneFactory extends ProductFactory{
    @Override
    public Product createProduct(double price, String description) {
        return new Phone(price,description);
    }
}
