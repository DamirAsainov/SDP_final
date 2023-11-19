package strategy;

/**
 * The PaymentStrategy interface defines the contract for payment strategies.
 * Implementing classes should provide a specific payment method.
 */
public interface PaymentStrategy {

    /**
     * Performs the payment with the specified amount.
     *
     * @param amount The amount to be paid.
     */
    void pay(double amount);
}
