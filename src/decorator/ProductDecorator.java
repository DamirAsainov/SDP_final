package decorator;

import factory.Product;
import observer.*;

abstract class ProductDecorator implements Product {
    protected Product decoratedProduct;

    protected StoreNotifier storeNotifier;
    public ProductDecorator(Product decoratedProduct, StoreNotifier storeNotifier) {
        this.decoratedProduct = decoratedProduct;
        this.storeNotifier = storeNotifier;
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
