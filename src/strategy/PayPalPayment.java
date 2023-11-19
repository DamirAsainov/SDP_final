package strategy;

/**
 * The PayPalPayment class implements the PaymentStrategy interface.
 * It represents a payment strategy using PayPal.
 */
public class PayPalPayment implements PaymentStrategy {
    private String email;

    /**
     * Constructs a new PayPalPayment instance with the specified email.
     *
     * @param email The email associated with the PayPal account.
     */
    public PayPalPayment(String email) {
        this.email = email;
    }

    /**
     * Performs the payment using PayPal with the specified amount.
     *
     * @param amount The amount to be paid.
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal account: " + email);
    }
}
