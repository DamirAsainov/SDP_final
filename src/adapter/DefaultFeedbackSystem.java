package adapter;

public class DefaultFeedbackSystem implements FeedbackInterface {
    @Override
    public void provideFeedback(String customerName, String feedbackText) {
        System.out.println(customerName + " provided feedback: " + feedbackText);
    }
}