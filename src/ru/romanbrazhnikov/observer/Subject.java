package ru.romanbrazhnikov.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> mObservers = new ArrayList<>();

    /** Subscribing new observer */
    public void attach(Observer observer) {
        if (!mObservers.contains(observer)) {
            mObservers.add(observer);
        }
    }

    /** Unsubscribing given observer */
    public void detach(Observer observer) {
        mObservers.remove(observer);
    }

    /** Notifying all observers */
    protected void notifySubscribers() {
        for (Observer o : mObservers) {
            o.update();
        }
    }
}
