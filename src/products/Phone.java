package products;

public class Phone extends Product{
    private String operatingSystem;
    public Phone(){};

    public Phone(String brand, String model, double price, String operatingSystem) {
        super(brand, model, price);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public String toString() {
        return super.toString() + " (OS: " + operatingSystem + ")";
    }
}
