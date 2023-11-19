package singleton;



public class Database {
    private static volatile Database instance;
    private ProductManagement productManager;

    private Database() {
        productManager = new ProductManager();
    }

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

    public ProductManagement getProductManager() {
        return productManager;
    }
}