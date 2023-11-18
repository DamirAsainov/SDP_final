package decorator;

import factory.Product;
import observer.*;

public class DiscountDecorator extends ProductDecorator{
    private double discount;
    public DiscountDecorator(Product decoratedProduct, double discount, StoreNotifier storeNotifier) {
        super(decoratedProduct, storeNotifier);
        this.discount = discount;
        notifyDiscount();
    }

    private void notifyDiscount() {
        if (storeNotifier != null) {
            storeNotifier.notifyObservers("Discount applied: " + discount * 100 + "% on " + decoratedProduct.getDescription());
        }
    }

    @Override
    public double getPrice() {
        double discountedPrice = super.getPrice() * (1 - discount);
        return Math.round(discountedPrice * 100.0) / 100.0; // Rounded to two decimal places
    }

}
