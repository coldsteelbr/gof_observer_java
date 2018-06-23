package ru.romanbrazhnikov;

import ru.romanbrazhnikov.app.DateTimeLocalizer;
import ru.romanbrazhnikov.app.UnixTimeProvider;

public class Main {
    private static void printAll(UnixTimeProvider u, DateTimeLocalizer l){

        System.out.printf("TimeStamp: %d\n", u.getTimeStamp());
        System.out.printf("Localized: %s\n\n", l.getLocalizedDate());

    }
    public static void main(String[] args) {
        UnixTimeProvider provider = new UnixTimeProvider();
        DateTimeLocalizer localizer = new DateTimeLocalizer();
        printAll(provider, localizer);

        localizer.setTimeStamp(provider.getTimeStamp());
        printAll(provider, localizer);

        provider.setTimeStampInSeconds(1529736743);
        localizer.setTimeStamp(provider.getTimeStamp());
        printAll(provider, localizer);

        //
        //  Subscribing
        //

        localizer.setProvider(provider);

        provider.setTimeStampInSeconds(537840000);
        printAll(provider, localizer);

        provider.setTimeStampInSeconds(1093996800);
        printAll(provider, localizer);

        //
        //  Unsubscribing
        //

        localizer.removeProvider();
        provider.setTimeStampInSeconds(0);
        printAll(provider, localizer);
    }
}
