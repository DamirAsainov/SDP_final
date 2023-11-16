package singleton;

import factory.Product;

import java.util.ArrayList;

public class Database {
    private static Database instance;
    private ArrayList<Product> productStorage;
    private Database() {
        productStorage = new ArrayList<>();
    }
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    public void addProduct(Product product){
        productStorage.add(product);
    }
    public void deleteProduct(int index){
        productStorage.remove(index);
    }
    public void deleteProduct(Product product){
        productStorage.remove(product);
    }
    public int getProductID(Product product){
        return productStorage.indexOf(product);
    }
    public Product getProduct(int index){
        return productStorage.get(index);
    }
    public int getProductsLen(){
        return productStorage.size();
    }
}
