package singleton;

import factory.Product;
import java.util.ArrayList;
public class ProductManager implements ProductManagement {
    private ArrayList<Product> productStorage;

    public ProductManager() {
        productStorage = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        productStorage.add(product);
    }

    @Override
    public void deleteProduct(int index) {
        productStorage.remove(index);
    }

    @Override
    public void deleteProduct(Product product) {
        productStorage.remove(product);
    }

    @Override
    public int getProductID(Product product) {
        return productStorage.indexOf(product);
    }

    @Override
    public Product getProduct(int index) {
        return productStorage.get(index);
    }

    @Override
    public int getProductsLen() {
        return productStorage.size();
    }
}