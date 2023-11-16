package factory;

import products.Laptop;

public class LaptopFactory extends ProductFactory{

    @Override
    public Product createProduct(double price, String description) {
        return new Laptop(price,description);
    }
}
