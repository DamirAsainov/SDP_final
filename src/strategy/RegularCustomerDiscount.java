package strategy;

public class RegularCustomerDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.95; // 5% discount for regular customers
    }
}
