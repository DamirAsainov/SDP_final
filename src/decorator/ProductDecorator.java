package decorator;

import factory.Product;

public class ProductDecorator implements Product {
    protected Product decoratedProduct;
    public ProductDecorator(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }


    @Override
    public String getDescription() {
        return decoratedProduct.getDescription();
    }

    @Override
    public void displayInfo() {
        decoratedProduct.displayInfo();
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice();
    }
}
