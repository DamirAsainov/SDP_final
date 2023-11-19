package strategy;

/**
 * The CreditCardPayment class implements the PaymentStrategy interface.
 * It represents a payment strategy using a credit card.
 */
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    /**
     * Constructs a new CreditCardPayment instance with the specified card number and cardholder name.
     *
     * @param cardNumber The credit card number.
     * @param name       The name of the cardholder.
     */
    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    /**
     * Performs the payment using a credit card with the specified amount.
     *
     * @param amount The amount to be paid.
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using credit card: " + cardNumber);
    }
}
