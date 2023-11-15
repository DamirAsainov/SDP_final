import adapter.LegacySystem;
import adapter.LegacySystemAdapter;
import adapter.NewSystem;
import decorator.BaseStore;
import decorator.PremiumStoreDecorator;
import decorator.Store;
import observer.Customer;
import observer.Observer;
import observer.StoreNotifier;
import singleton.DatabaseConnection;
import strategy.DiscountStrategy;
import strategy.RegularCustomerDiscount;
import strategy.VIPCustomerDiscount;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Singleton Pattern
        try {
            Connection connection = DatabaseConnection.getConnection();
            // Use the connection for database operations
        } catch (SQLException e) {
            System.out.println(e);
        }

        // Factory Pattern
//        Product phone = (Product) ProductFactory.createProduct("Phone");
//        Product laptop = (Product) ProductFactory.createProduct("Laptop");
//
//        phone.toString();
//        laptop.toString();

        // Adapter Pattern
        NewSystem newSystem = new LegacySystemAdapter(new LegacySystem());
        newSystem.processData();

        // Decorator Pattern
        Store baseStore = new BaseStore();
        Store premiumStore = new PremiumStoreDecorator(baseStore);

        baseStore.sell();
        System.out.println("-----");
        premiumStore.sell();
        System.out.println("////////////////////////////////");
        // Observer Pattern
        StoreNotifier storeNotifier = new StoreNotifier();
        Observer customer1 = new Customer("John");
        Observer customer2 = new Customer("Alice");

        storeNotifier.addObserver(customer1);
        storeNotifier.addObserver(customer2);

        storeNotifier.notifyObservers("New products are available!");

        // Strategy Pattern
        DiscountStrategy regularCustomerDiscount = new RegularCustomerDiscount();
        DiscountStrategy vipCustomerDiscount = new VIPCustomerDiscount();

        double originalPrice = 100.0;

        System.out.println("Original Price: $" + originalPrice);
        System.out.println("Regular Customer Price: $" + regularCustomerDiscount.applyDiscount(originalPrice));
        System.out.println("VIP Customer Price: $" + vipCustomerDiscount.applyDiscount(originalPrice));
    }
}
