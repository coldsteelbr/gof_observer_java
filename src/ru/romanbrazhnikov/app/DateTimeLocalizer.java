package ru.romanbrazhnikov.app;

import ru.romanbrazhnikov.observer.Observer;
import ru.romanbrazhnikov.observer.Subject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimeLocalizer implements Observer {
    private final SimpleDateFormat dtFormatter;
    private Calendar mCalendar = GregorianCalendar.getInstance(); // TODO: TimeZone + Locale
    private long mTimeStamp = 0;

    private UnixTimeProvider mProvider;

    //
    //  Observer
    //

    @Override
    public void update() {
        setTimeStamp(mProvider.getTimeStamp());
    }

    //
    //  Constructor
    //
    public DateTimeLocalizer() {
        dtFormatter = new SimpleDateFormat("dd-MM-YYYY");
    }

    //
    // Subscribing
    //

    public void setProvider(UnixTimeProvider provider) {
        mProvider = provider;
        mProvider.attach(this);
    }

    //
    // LOGIC
    //
    public void setTimeStamp(long seconds) {
        mTimeStamp = seconds;
        mCalendar.setTimeInMillis(mTimeStamp * 1000);
    }

    public String getLocalizedDate() {
        return dtFormatter.format(mCalendar.getTime());
    }


    public void removeProvider() {
        if(mProvider == null) {
            return;
        }

        mProvider.detach(this);
        mProvider = null;
    }
}
