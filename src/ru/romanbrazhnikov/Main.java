package ru.romanbrazhnikov;

import ru.romanbrazhnikov.app.DateTimeLocalizer;
import ru.romanbrazhnikov.app.UnixTimeProvider;

public class Main {

    public static void main(String[] args) {
        UnixTimeProvider provider = new UnixTimeProvider();
        DateTimeLocalizer localizer = new DateTimeLocalizer();

        System.out.printf("UnixTime stamp: %d\n", provider.getTimeStamp());
        System.out.printf("Localized: %s\n", localizer.getLocalizedDate());

        localizer.setTimeStamp(provider.getTimeStamp());

        System.out.printf("UnixTime stamp: %d\n", provider.getTimeStamp());
        System.out.printf("Localized: %s\n", localizer.getLocalizedDate());

        provider.setTimeStampInSeconds(1529736743);
        localizer.setTimeStamp(provider.getTimeStamp());

        System.out.printf("UnixTime stamp: %d\n", provider.getTimeStamp());
        System.out.printf("Localized: %s\n", localizer.getLocalizedDate());
    }
}
