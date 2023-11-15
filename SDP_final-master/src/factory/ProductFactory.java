package factory;

import products.*;
public class ProductFactory {
    public static Product createProduct(String type) {
        if ("Phone".equalsIgnoreCase(type)) {
            return (Product) new Phone();
        } else if ("Laptop".equalsIgnoreCase(type)) {
            return (Product) new Laptop();
        }
        return null;
    }
}
