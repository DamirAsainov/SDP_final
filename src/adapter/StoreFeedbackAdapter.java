package adapter;

public class StoreFeedbackAdapter implements StoreFeedbackInterface{
    private DefaultFeedbackSystem defaultFeedbackSystem;

    public StoreFeedbackAdapter(DefaultFeedbackSystem defaultFeedbackSystem) {
        this.defaultFeedbackSystem = defaultFeedbackSystem;
    }

    @Override
    public void submitFeedback(String feedback) {
        // Assume a default customer name for simplicity
        String defaultCustomerName = "Anonymous Customer";
        defaultFeedbackSystem.provideFeedback(defaultCustomerName, feedback);
    }
}
