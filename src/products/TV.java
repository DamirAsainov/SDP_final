package products;

public class TV extends Product{
    private int screenSize;

    public TV(String brand, String model, double price, int screenSize) {
        super(brand, model, price);
        this.screenSize = screenSize;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        return super.toString() + " (Screen Size: " + screenSize + " inches)";
    }
}
