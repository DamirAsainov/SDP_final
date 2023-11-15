package products;

public class Product{
        private String brand;
        private String model;
        private double price;
        public Product(){}

        public Product(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return brand + " " + model + " - $" + price;
        }
}
