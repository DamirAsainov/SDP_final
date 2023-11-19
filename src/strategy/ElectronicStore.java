package strategy;

/**
 * The ElectronicStore class represents a store that processes orders with different payment strategies.
 */
public class ElectronicStore {
    private PaymentStrategy paymentStrategy;

    /**
     * Constructs a new ElectronicStore instance with the specified initial payment strategy.
     *
     * @param paymentStrategy The initial payment strategy.
     */
    public ElectronicStore(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Sets a new payment strategy for the store.
     *
     * @param paymentStrategy The new payment strategy.
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Processes an order with the current payment strategy and the specified amount.
     *
     * @param amount The amount to be paid for the order.
     */
    public void processOrder(double amount) {
        System.out.println("Processing order...");
        paymentStrategy.pay(amount);
    }
}
