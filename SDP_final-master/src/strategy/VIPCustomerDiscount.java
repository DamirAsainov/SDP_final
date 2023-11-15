package strategy;

public class VIPCustomerDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.90; // 10% discount for VIP customers
    }
}
