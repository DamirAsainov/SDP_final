package observer;

import java.util.ArrayList;
import java.util.List;
/**
 * The StoreNotifier class represents a subject that notifies its observers about changes.
 */
public class StoreNotifier {
    private List<Observer> observers = new ArrayList<>();

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Notifies all registered observers about a change by calling their update method.
     *
     * @param message The message or information associated with the update.
     */
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
