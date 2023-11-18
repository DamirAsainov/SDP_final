package strategy;

public class ElectronicStore {
    private PaymentStrategy paymentStrategy;

    public ElectronicStore(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processOrder(double amount) {
        System.out.println("Processing order...");
        paymentStrategy.pay(amount);
    }
}