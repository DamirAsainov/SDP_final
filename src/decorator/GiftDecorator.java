package decorator;

import factory.Product;
import observer.*;

public class GiftDecorator extends ProductDecorator{
    private String gift;
    public GiftDecorator(Product decoratedProduct, String gift, StoreNotifier storeNotifier) {
        super(decoratedProduct, storeNotifier);
        this.gift = gift;
        notifyGift();
    }
    @Override
    public String getDescription() {
        return decoratedProduct.getDescription() + " with a free gift: " + gift;
    }
    private void notifyGift() {     if (storeNotifier != null) {
        storeNotifier.notifyObservers("Gift added: " + gift + " with " + decoratedProduct.getDescription());}}
}
