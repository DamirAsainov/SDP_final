import adapter.LegacySystem;
import adapter.LegacySystemAdapter;
import adapter.NewSystem;
import decorator.*;
import factory.LaptopFactory;
import factory.PhoneFactory;
import factory.Product;
import factory.ProductFactory;
import observer.Customer;
import observer.Observer;
import observer.StoreNotifier;
import products.Laptop;
import singleton.Database;
import strategy.CreditCardPayment;
import strategy.ElectronicStore;
import strategy.KaspiPayment;
import strategy.PayPalPayment;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        app();
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
        database.addProduct(base);
        database.addProduct(discountedProduct);
        database.addProduct(discountedGiftProduct);

        for(int i = 0; i < database.getProductsLen(); i++){
            Product pr = database.getProduct(i);
            System.out.println("Base Product: " + pr.getDescription() + ", Price: $" + pr.getPrice());
        }

    }

    private static void app(){
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getInstance();
        while (!exit){
            System.out.println("////////////////////////////////////////////" +
                    "\n-----------------Hardware Store---------------" +
                    "\n\n#- - -CUSTOMER MODE- - -#" +
                    "\n1. Display all products" +
                    "\n2. Buy by index" +
                    "\n3. Upgrade account" +
                    "\n4. ADMIN MODE" +
                    "\n\nYour Input: ");
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    for(int i = 0; i < database.getProductsLen(); i++){
                        System.out.println(i + ": "+ database.getProduct(i).getDescription() + " - " + database.getProduct(i).getPrice());
                    }
                    break;
                case "2":
                    System.out.println("Index: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    if(index >= 0 && index < database.getProductsLen()){
                        Product product = database.getProduct(index);
                        System.out.println("Product:" + product.getDescription() + "\nPrice: " + product.getPrice() + "\n\nWhich payment do you prefer?\n1. Kaspi Payment\n2. Credit Card\n3. PayPal");
                        String payInput = scanner.nextLine();
                        ElectronicStore payment = null;
                        switch (payInput){
                            case "1":
                                payment = new ElectronicStore(new KaspiPayment());
                                break;
                            case "2":
                                System.out.println("Card number:");
                                String cardNumber = scanner.nextLine();
                                System.out.println("Name:");
                                String name = scanner.nextLine();
                                payment = new ElectronicStore(new CreditCardPayment(cardNumber, name));
                                break;
                            case "3":
                                System.out.println("Email:");
                                payment = new ElectronicStore(new PayPalPayment(scanner.nextLine()));
                                break;
                            default:
                                System.out.println("Wrong input");
                                continue;
                        }
                        payment.processOrder(product.getPrice());
                    }
                    break;
                case "3":
                    System.out.println("3 aaDA");
                    break;
                case "4":
                    adminMode();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }


    private static void adminMode(){
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getInstance();
        while (!exit){
            System.out.println("////////////////////////////////////////////" +
                    "\n-----------------Hardware Store---------------" +
                    "\n\n#- - -ADMIN MODE- - -#" +
                    "\n1. Display all products" +
                    "\n2. Add product" +
                    "\n3. Delete product" +
                    "\n4. CUSTOMER MODE" +
                    "\n\nYour Input: ");
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    for(int i = 0; i < database.getProductsLen(); i++){
                        System.out.println(i + ": "+ database.getProduct(i).getDescription());
                    }
                    break;
                case "2":
                    Product newProduct = null;
                    System.out.println("Which product you want add\n1. Laptop\n2. Phone\n3. TV");
                    String prInput = scanner.nextLine();
                    String input1;
                    double price;
                    switch (prInput){
                        case "1":
                            System.out.println("Laptop title and description");
                            input1 = scanner.nextLine();
                            System.out.println("Price: ");
                            price = scanner.nextDouble();
                            ProductFactory laptopFactory = new LaptopFactory();
                            newProduct = laptopFactory.createProduct(price, input1);
                            break;
                        case "2":
                            System.out.println("Phone title and description");
                            input1 = scanner.nextLine();
                            System.out.println("Price: ");
                            price = Double.parseDouble(scanner.nextLine());
                            ProductFactory phoneFactory = new PhoneFactory();
                            newProduct = phoneFactory.createProduct(price, input1);
                            break;
                        case "3":
                            System.out.println("TV title and description");
                            input1 = scanner.nextLine();
                            System.out.println("Price: ");
                            price = scanner.nextDouble();
                            ProductFactory tvFactory = new PhoneFactory();
                            newProduct = tvFactory.createProduct(price, input1);
                            break;
                        default:
                            System.out.println("Wrong input");
                            continue;
                    }
                    database.addProduct(newProduct);
                    break;
                case "3":
                    System.out.println("Write product index");
                    try {
                        database.deleteProduct(scanner.nextInt());
                    }catch (Exception e){
                        System.out.println("Wrong index");
                    }
                    break;
                case "4":
                    app();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
