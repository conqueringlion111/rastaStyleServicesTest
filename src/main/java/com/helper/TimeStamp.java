package com.helper;

import java.util.Calendar;

public class TimeStamp {

    public TimeStamp() {
        getCurrentTimeMS();
    }

    private static long timeStampMS;

    private void getCurrentTimeMS() {
        Calendar calendar = Calendar.getInstance();
        setTimeStamp(calendar.getTimeInMillis());
    }

    private static void setTimeStamp(long ts) {
        timeStampMS = ts;
    }

    public static long getTimeStampMS() {
        return timeStampMS;
    }
}
