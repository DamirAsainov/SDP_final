package adapter;

public class StoreFeedbackSystem implements StoreFeedbackInterface {

    public void submitFeedback(String name,String feedback) {
        System.out.println("System received feedback: " + feedback);
    }
}
