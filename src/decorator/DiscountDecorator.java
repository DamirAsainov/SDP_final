package decorator;

import factory.Product;

public class DiscountDecorator extends ProductDecorator{
    private double discount;
    public DiscountDecorator(Product decoratedProduct, double discount) {
        super(decoratedProduct);
        this.discount = discount;
    }
    @Override
    public double getPrice() {
        // Применяем скидку к базовой цене
        return decoratedProduct.getPrice() * (1 - discount);
    }
}
