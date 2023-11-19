package singleton;


/**
 * The Database class represents a singleton instance that manages a product database.
 * It ensures that there is only one instance of the database throughout the application.
 */
public class Database {
    private static volatile Database instance;
    private ProductManagement productManager;
    /**
     * Private constructor to prevent direct instantiation of the Database class.
     * Initializes the product manager.
     */
    private Database() {
        productManager = new ProductManager();
    }


    /**
     * Gets the singleton instance of the Database class.
     *
     * @return The singleton instance of the Database class.
     */
    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    /**
     * Gets the product manager associated with the database instance.
     *
     * @return The product manager.
     */
    public ProductManagement getProductManager() {
        return productManager;
    }
}