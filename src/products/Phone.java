package products;

import factory.Product;

public class Phone implements Product {

    private double price;
    private String description;
    public Phone(){};
    public Phone(double price, String description){
        this.description = description;
        this.price = price;
    }
    @Override
    public void displayInfo() {
        getPrice();
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
