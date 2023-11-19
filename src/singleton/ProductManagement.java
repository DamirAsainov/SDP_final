package singleton;

import factory.Product;

/**
 * The ProductManagement interface defines operations for managing products in a database.
 */
public interface ProductManagement {

    /**
     * Adds a product to the database.
     *
     * @param product The product to be added.
     */
    void addProduct(Product product);

    /**
     * Deletes a product from the database by index.
     *
     * @param index The index of the product to be deleted.
     */
    void deleteProduct(int index);

    /**
     * Deletes a specific product from the database.
     *
     * @param product The product to be deleted.
     */
    void deleteProduct(Product product);

    /**
     * Gets the unique identifier (ID) of a product in the database.
     *
     * @param product The product to retrieve the ID for.
     * @return The ID of the product.
     */
    int getProductID(Product product);

    /**
     * Gets a product from the database by index.
     *
     * @param index The index of the product to be retrieved.
     * @return The product at the specified index.
     */
    Product getProduct(int index);

    /**
     * Gets the number of products in the database.
     *
     * @return The number of products in the database.
     */
    int getProductsLen();

    /**
     * Changes the product at a specific index in the database.
     *
     * @param index   The index of the product to be changed.
     * @param product The new product to replace the existing one.
     */
    void changeByIndex(int index, Product product);
}
