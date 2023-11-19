package adapter;

public class StoreFeedbackSystem implements StoreFeedbackInterface {

    public void submitFeedback(String feedback) {
        System.out.println("DefaultFeedbackSystem received feedback: " + feedback);
    }
}
