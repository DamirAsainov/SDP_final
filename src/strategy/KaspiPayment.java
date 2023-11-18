package strategy;

public class KaspiPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " in Kaspi");
    }
}