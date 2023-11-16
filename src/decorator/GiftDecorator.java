package decorator;

import factory.Product;

public class GiftDecorator extends ProductDecorator{
    private String gift;
    public GiftDecorator(Product decoratedProduct, String gift) {
        super(decoratedProduct);
        this.gift = gift;
    }
    @Override
    public String getDescription() {
        return decoratedProduct.getDescription() + " with a free gift: " + gift;
    }
}
