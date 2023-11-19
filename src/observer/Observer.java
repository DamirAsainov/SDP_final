package observer;
/**
 * The Observer interface represents an observer that can receive updates from a subject.
 */
public interface Observer {
    /**
     * This method is called by the subject to notify the observer about a change.
     *
     * @param message The message or information associated with the update.
     */
    void update(String message);
}
