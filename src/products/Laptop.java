package products;

import factory.Product;

public class Laptop implements Product {
    private double price;
    private String description;
    public Laptop(double price, String description){
        this.description = description;
        this.price = price;
    }
    @Override
    public void displayInfo() {
        System.out.println(description);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
