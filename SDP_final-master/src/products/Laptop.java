package products;

public class Laptop extends Product{
    private String processor;

    public Laptop(){};
    public Laptop(String brand, String model, double price, String processor) {
        super(brand, model, price);
        this.processor = processor;
    }

    public String getProcessor() {
        return processor;
    }

    @Override
    public String toString() {
        return super.toString() + " (Processor: " + processor + ")";
    }
}
