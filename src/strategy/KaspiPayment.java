package strategy;

/**
 * The KaspiPayment class implements the PaymentStrategy interface.
 * It represents a payment strategy using Kaspi QR.
 */
public class KaspiPayment implements PaymentStrategy {

    /**
     * Performs the payment using Kaspi QR with the specified amount.
     *
     * @param amount The amount to be paid.
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " in Kaspi QR");
    }
}
