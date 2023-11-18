package decorator;
import factory.*;
public class BaseProduct implements Product {
    private double price;
    private String description;

    public BaseProduct(double price, String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public void displayInfo() {

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