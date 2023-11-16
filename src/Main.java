import adapter.LegacySystem;
import adapter.LegacySystemAdapter;
import adapter.NewSystem;
import decorator.*;
import factory.LaptopFactory;
import factory.Product;
import factory.ProductFactory;
import observer.Customer;
import observer.Observer;
import observer.StoreNotifier;
import products.Laptop;
import products.Phone;
import singleton.DatabaseConnection;
import strategy.DiscountStrategy;
import strategy.RegularCustomerDiscount;
import strategy.VIPCustomerDiscount;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "\n-----------------Online Shop---------------" +
                "\n\n1. Display all products" +
                "\n2. Buy by index" +
                "\n3. Upgrade account" +
                "\n4. Add product" +
                "\n\n/////////////////////////////////////////////");
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
        ProductFactory aser = new LaptopFactory();
        Product nitro5 = aser.createProduct(400,"ultrabook");
        double originalPrice = 100.0;

        System.out.println("Original Price: $" + originalPrice);
        System.out.println("Regular Customer Price: $" + regularCustomerDiscount.applyDiscount(originalPrice));
        System.out.println("VIP Customer Price: $" + vipCustomerDiscount.applyDiscount(originalPrice));


        System.out.println("///////////////////////////////////////////////////////////" +
                "\n------------Testing decorator---------------");
        Product baseProduct = new Laptop(15000, "Acer Swift 3");
        Product discountedProduct = new DiscountDecorator(baseProduct, 0.1);
        // Декорируем товар с подарком
        Product giftProduct = new GiftDecorator(baseProduct, "Wireless Mouse");

        // Декорируем товар с скидкой и подарком
        Product discountedGiftProduct = new DiscountDecorator(new GiftDecorator(baseProduct, "Wireless Mouse"), 0.2);

        // Выводим информацию о товарах
        System.out.println("Base Product: " + baseProduct.getDescription() + ", Price: $" + baseProduct.getPrice());
        System.out.println("Discounted Product: " + discountedProduct.getDescription() + ", Price: $" + discountedProduct.getPrice());
        System.out.println("Gift Product: " + giftProduct.getDescription() + ", Price: $" + giftProduct.getPrice());
        System.out.println("Discounted Gift Product: " + discountedGiftProduct.getDescription() + ", Price: $" + discountedGiftProduct.getPrice());
        nitro5.displayInfo();
    }
}
