import products.Product;

import java.util.ArrayList;
import java.util.List;

public class ElectronicStore {
    private List<Product> inventory = new ArrayList<>();

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : inventory) {
            System.out.println(product);
        }
        System.out.println();
    }
}
