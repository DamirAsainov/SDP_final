package adapter;

public class StoreFeedbackAdapter implements StoreFeedbackInterface{
    private DefaultFeedbackSystem defaultFeedbackSystem;

    public StoreFeedbackAdapter(DefaultFeedbackSystem defaultFeedbackSystem) {
        this.defaultFeedbackSystem = defaultFeedbackSystem;
    }

    @Override
    public void submitFeedback(String name,String feedback) {
        String defaultCustomerName = name;
        defaultFeedbackSystem.provideFeedback(defaultCustomerName, feedback);
    }
}
