package observer;
/**
 * The Customer class represents an observer that receives notifications from a subject.
 */
public class Customer implements Observer{
    private String name;
    /**
     * Constructs a new Customer with the specified name.
     *
     * @param name The name of the customer.
     */
    public Customer(String name) {
        this.name = name;
    }
    /**
     * Updates the customer with a received notification message.
     *
     * @param message The message or information associated with the update.
     */
    @Override
    public void update(String message) {
        System.out.println(name + " received a notification: " + message);
    }
}
