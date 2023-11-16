package factory;

import products.TV;

public class TVFactory extends ProductFactory{
    @Override
    public Product createProduct(double price, String description) {
        return new TV(price,description);
    }
}
