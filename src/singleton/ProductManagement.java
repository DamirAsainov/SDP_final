package singleton;
import factory.Product;

public interface ProductManagement {
    void addProduct(Product product);
    void deleteProduct(int index);
    void deleteProduct(Product product);
    int getProductID(Product product);
    Product getProduct(int index);
    int getProductsLen();
    void changeByIndex(int index, Product product);
}
