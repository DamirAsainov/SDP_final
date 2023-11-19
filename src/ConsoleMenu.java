import decorator.DiscountDecorator;
import decorator.GiftDecorator;
import factory.LaptopFactory;
import factory.PhoneFactory;
import factory.Product;
import factory.ProductFactory;
import observer.Customer;
import observer.StoreNotifier;
import singleton.Database;
import singleton.ProductManagement;
import strategy.CreditCardPayment;
import strategy.ElectronicStore;
import strategy.KaspiPayment;
import strategy.PayPalPayment;

import java.io.File;
import java.util.Scanner;

public class ConsoleMenu {
    private Scanner scanner = new Scanner(System.in);
    private Database database = Database.getInstance();
    private ProductManagement productManager = database.getProductManager();
    private StoreNotifier storeNotifier;
    boolean exit = false;

    public ConsoleMenu(){storeNotifier = new StoreNotifier();}

    public void start(){
        System.out.println("Please write your name");
        Customer newCustomer = new Customer(scanner.nextLine());
        storeNotifier.addObserver(newCustomer);
        customerMode();
    }
    public void customerMode(){
        while (!exit){
            System.out.println("////////////////////////////////////////////" +
                    "\n-----------------Hardware Store---------------" +
                    "\n\n#- - -CUSTOMER MODE- - -#" +
                    "\n1. Display all products" +
                    "\n2. Buy by index" +
                    "\n3. Feedback" +
                    "\n4. ADMIN MODE" +
                    "\n\nYour Input: ");
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    for(int i = 0; i < productManager.getProductsLen(); i++){
                        System.out.println(i + ": "+ productManager.getProduct(i).getDescription() + " - " + productManager.getProduct(i).getPrice());
                    }
                    break;
                case "2":
                    buyByIndex();
                    break;
                case "3":
                    System.out.println("3 Abylai nado sdelat");
                    break;
                case "4":
                    adminMode();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    public void adminMode(){
        while (!exit){
            System.out.println("////////////////////////////////////////////" +
                    "\n-----------------Hardware Store---------------" +
                    "\n\n#- - -ADMIN MODE- - -#" +
                    "\n1. Display all products" +
                    "\n2. Add product" +
                    "\n3. Delete product" +
                    "\n4. Set discount and gift" +
                    "\n5. CUSTOMER MODE" +
                    "\n\nYour Input: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    for (int i = 0; i < productManager.getProductsLen(); i++) {
                        System.out.println(i + ": " + productManager.getProduct(i).getDescription());
                    }
                }
                case "2" -> {
                    Product newProduct = null;
                    System.out.println("Which product you want add\n1. Laptop\n2. Phone\n3. TV");
                    String prInput = scanner.nextLine();
                    String input1;
                    double price;
                    switch (prInput) {
                        case "1" -> {
                            System.out.println("Laptop title and description");
                            input1 = scanner.nextLine();
                            System.out.println("Price: ");
                            price = Double.parseDouble(scanner.nextLine());
                            ProductFactory laptopFactory = new LaptopFactory();
                            newProduct = laptopFactory.createProduct(price, input1);
                        }
                        case "2" -> {
                            System.out.println("Phone title and description");
                            input1 = scanner.nextLine();
                            System.out.println("Price: ");
                            price = Double.parseDouble(scanner.nextLine());
                            ProductFactory phoneFactory = new PhoneFactory();
                            newProduct = phoneFactory.createProduct(price, input1);
                        }
                        case "3" -> {
                            System.out.println("TV title and description");
                            input1 = scanner.nextLine();
                            System.out.println("Price: ");
                            price = Double.parseDouble(scanner.nextLine());
                            ProductFactory tvFactory = new PhoneFactory();
                            newProduct = tvFactory.createProduct(price, input1);
                        }
                        default -> {
                            System.out.println("Wrong input");
                            continue;
                        }
                    }
                    productManager.addProduct(newProduct);
                }
                case "3" -> {
                    System.out.println("Write product index");
                    try {
                        productManager.deleteProduct(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println("Wrong index");
                    }
                }
                case "4" -> {
                    System.out.println("1. Set discount" +
                            "\n2. Set gift" +
                            "\n3. Set discount and gift");
                    switch (scanner.nextLine()){
                        case "1" -> {
                            System.out.println("Index of product: ");
                            int index = Integer.parseInt(scanner.nextLine());
                            System.out.println("Discount in percent %: ");
                            double percent = Integer.parseInt(scanner.nextLine());
                            Product product = productManager.getProduct(index);
                            productManager.changeByIndex(index, new DiscountDecorator(product,percent / 100, storeNotifier));
                        } case "2" -> {
                            System.out.println("Index of product: ");
                            int index = Integer.parseInt(scanner.nextLine());
                            System.out.println("Name of gift");
                            String gift = scanner.nextLine();
                            Product product = productManager.getProduct(index);
                            productManager.changeByIndex(index, new GiftDecorator(product,gift, storeNotifier));
                        } case "3" -> {
                            System.out.println("Index of product: ");
                            int index = Integer.parseInt(scanner.nextLine());
                            System.out.println("Discount in percent %: ");
                            double percent = Integer.parseInt(scanner.nextLine());
                            System.out.println("Name of gift");
                            String gift = scanner.nextLine();
                            Product product = productManager.getProduct(index);
                            productManager.changeByIndex(index, new GiftDecorator(new DiscountDecorator(product, percent / 100, storeNotifier),gift, storeNotifier));
                        }

                    }
                }
                case "5" -> customerMode();
                default -> System.out.println("Wrong input");
            }
        }
    }

    private void buyByIndex(){
        System.out.println("Index: ");
        int index = Integer.parseInt(scanner.nextLine());
        if(index >= 0 && index < productManager.getProductsLen()) {
            Product product = productManager.getProduct(index);
            System.out.println("Product:" + product.getDescription() + "\nPrice: " + product.getPrice() + "\n\nWhich payment do you prefer?(10% discount for Kaspi Bank users)\n1. Kaspi Payment\n2. Credit Card\n3. PayPal");
            String payInput = scanner.nextLine();
            ElectronicStore payment = null;
            switch (payInput) {
                case "1" -> {
                    payment = new ElectronicStore(new KaspiPayment());
                    product = new DiscountDecorator(product,0.1, storeNotifier);
                }
                case "2" -> {
                    System.out.println("Card number:");
                    String cardNumber = scanner.nextLine();
                    System.out.println("Name:");
                    String name = scanner.nextLine();
                    payment = new ElectronicStore(new CreditCardPayment(cardNumber, name));
                }
                case "3" -> {
                    System.out.println("Email:");
                    payment = new ElectronicStore(new PayPalPayment(scanner.nextLine()));
                }
                default -> {
                    System.out.println("Wrong input");
                    return;
                }
            }
            payment.processOrder(product.getPrice());
        }else {
            System.out.println("This product is not exist");
        }
    }
}
