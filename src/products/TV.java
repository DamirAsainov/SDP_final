package products;
import factory.Product;
public class TV implements Product{

    private double price;
    private String description;
    public TV(double price, String description){
        this.description = description;
        this.price = price;
    }
    @Override
    public void displayInfo() {
        getPrice();
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
