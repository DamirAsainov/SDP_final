package factory;

import products.Laptop;

public class LaptopFactory extends ProductFactory{
    @Override
    public Product createProduct() {
        return new Laptop();
    }
}
