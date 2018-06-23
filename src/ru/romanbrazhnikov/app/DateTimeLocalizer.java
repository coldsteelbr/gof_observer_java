package ru.romanbrazhnikov.app;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeLocalizer {
    private final SimpleDateFormat dtFormatter;
    private Calendar mCalendar = GregorianCalendar.getInstance(); // TODO: TimeZone + Locale
    private long mTimeStamp = 0;

    public DateTimeLocalizer(){
        dtFormatter = new SimpleDateFormat("dd-MM-YYYY");
    }

    public void setTimeStamp(long seconds) {
        mTimeStamp = seconds;
        mCalendar.setTimeInMillis(mTimeStamp * 1000);
    }

    public String getLocalizedDate() {
        return dtFormatter.format(mCalendar.getTime());
    }
}
