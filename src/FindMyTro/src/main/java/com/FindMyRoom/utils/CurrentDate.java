package com.FindMyRoom.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CurrentDate {
    public static Date getCurrentDate() throws ParseException {
        LocalDate localDate = LocalDate.now();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(localDate.toString());
    }
}
