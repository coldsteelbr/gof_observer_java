package ru.romanbrazhnikov.app;

public class UnixTimeProvider {
    private int mTimeStampInSeconds = 0;

    public void setTimeStampInSeconds(int seconds) {
        mTimeStampInSeconds = seconds;
    }

    public int getTimeStamp() {
        return mTimeStampInSeconds;
    }

}
