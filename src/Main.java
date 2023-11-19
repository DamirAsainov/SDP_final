import strategy.*;
import adapter.*;
import products.*;
import decorator.*;
import factory.*;
import singleton.*;
import observer.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.start();
        // Singleton Pattern

        // Factory Pattern
//        Product phone = (Product) ProductFactory.createProduct("Phone");
//        Product laptop = (Product) ProductFactory.createProduct("Laptop");
//
//        phone.toString();
//        laptop.toString();

        // Adapter Pattern
        /*
        FeedbackSystem existingFeedbackSystem = new DefaultFeedbackSystem();
        existingFeedbackSystem.submitFeedback("Good service!");

        // Using the new feedback system through the adapter
        NewFeedbackSystem newFeedbackSystem = new NewFeedbackSystem();
        FeedbackSystem newFeedbackSystemAdapter = new NewFeedbackSystemAdapter(newFeedbackSystem);
        newFeedbackSystemAdapter.submitFeedback("Great experience!"); */
        // НОВЫЙ ДОБАВЛЕННЫЙ ДЕФОЛТ, НАШ ЭТО СТОРЕФИДБЕК. ОБРАЩАЕМ В АДАПТЕРЕ ДЕФОЛТ В СТОРФИДБЕК \\ ПРОВАЙД ---> САБМИТ
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
        Product acer = baseProduct.createProduct(15000,"Game Laptop Acer"); //создаем конкретный продукт
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
        ProductManagement productManager = database.getProductManager();
        productManager.addProduct(base);
        productManager.addProduct(discountedProduct);
        productManager.addProduct(discountedGiftProduct);

        for(int i = 0; i < productManager.getProductsLen(); i++){
            Product pr = productManager.getProduct(i);
            System.out.println("Base Product: " + pr.getDescription() + ", Price: $" + pr.getPrice());
        }

    }


}
