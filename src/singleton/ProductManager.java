package singleton;

import factory.Product;
import java.util.ArrayList;

/**
 * The ProductManager class implements the ProductManagement interface.
 * It manages products in an ArrayList as a simple in-memory database.
 */
public class ProductManager implements ProductManagement {
    private ArrayList<Product> productStorage;

    /**
     * Constructs a new ProductManager with an empty product storage.
     */
    public ProductManager() {
        productStorage = new ArrayList<>();
    }

    /**
     * Adds a product to the product storage.
     *
     * @param product The product to be added.
     */
    @Override
    public void addProduct(Product product) {
        productStorage.add(product);
    }

    /**
     * Deletes a product from the product storage by index.
     *
     * @param index The index of the product to be deleted.
     */
    @Override
    public void deleteProduct(int index) {
        productStorage.remove(index);
    }

    /**
     * Deletes a specific product from the product storage.
     *
     * @param product The product to be deleted.
     */
    @Override
    public void deleteProduct(Product product) {
        productStorage.remove(product);
    }

    /**
     * Gets the index of a product in the product storage.
     *
     * @param product The product to retrieve the index for.
     * @return The index of the product in the product storage.
     */
    @Override
    public int getProductID(Product product) {
        return productStorage.indexOf(product);
    }

    /**
     * Gets a product from the product storage by index.
     *
     * @param index The index of the product to be retrieved.
     * @return The product at the specified index.
     */
    @Override
    public Product getProduct(int index) {
        return productStorage.get(index);
    }

    /**
     * Gets the number of products in the product storage.
     *
     * @return The number of products in the product storage.
     */
    @Override
    public int getProductsLen() {
        return productStorage.size();
    }

    /**
     * Changes the product at a specific index in the product storage.
     *
     * @param index   The index of the product to be changed.
     * @param product The new product to replace the existing one.
     */
    @Override
    public void changeByIndex(int index, Product product) {
        productStorage.set(index, product);
    }
}
