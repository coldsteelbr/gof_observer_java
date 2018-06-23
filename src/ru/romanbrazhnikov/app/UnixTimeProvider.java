package ru.romanbrazhnikov.app;

import ru.romanbrazhnikov.observer.Subject;

public class UnixTimeProvider extends Subject {
    private int mTimeStampInSeconds = 0;

    public void setTimeStampInSeconds(int seconds) {
        mTimeStampInSeconds = seconds;
        notifySubscribers();
    }

    public int getTimeStamp() {
        return mTimeStampInSeconds;
    }

}
