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
import singleton.Database;

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


        double originalPrice = 100.0;

        System.out.println("Original Price: $" + originalPrice);

        System.out.println("///////////////////////////////////////////////////////////" +
                "\n------------Testing decorator---------------");


        ProductFactory baseProduct = new LaptopFactory(); //создаем фактори конкретного продукта
        Product acer = baseProduct.createProduct(15000,"game laptop"); //создаем конкретный продукт
        Product base = new BaseProduct(acer.getPrice(),acer.getDescription()); // передаем значения конкретного продукта в общие продукты.
        Product discountedProduct = new DiscountDecorator(base, 0.1,storeNotifier);
        // Декорируем товар с подарком
        Product giftProduct = new GiftDecorator(base, "Wireless Mouse",storeNotifier);

        // Декорируем товар с скидкой и подарком
        Product discountedGiftProduct = new DiscountDecorator(new GiftDecorator(acer, "Wireless Mouse",storeNotifier), 0.2,storeNotifier);

        // Выводим информацию о товарах
        System.out.println("Base Product: " + base.getDescription() + ", Price: $" + acer.getPrice());
        System.out.println("Discounted Product: " + discountedProduct.getDescription() + ", Price: $" + discountedProduct.getPrice());
        System.out.println("Gift Product: " + giftProduct.getDescription() + ", Price: $" + giftProduct.getPrice());
        System.out.println("Discounted Gift Product: " + discountedGiftProduct.getDescription() + ", Price: $" + discountedGiftProduct.getPrice());


        System.out.println("////////////////////////////////////////////////////////////" +
                "\n------------------------------Testing SINGLETON--------------------------\n\n");
        Database database = Database.getInstance();
        database.addProduct(base);
        database.addProduct(discountedProduct);
        database.addProduct(discountedGiftProduct);

        for(int i = 0; i < database.getProductsLen(); i++){
            Product pr = database.getProduct(i);
            System.out.println("Base Product: " + pr.getDescription() + ", Price: $" + pr.getPrice());
        }

    }
}
