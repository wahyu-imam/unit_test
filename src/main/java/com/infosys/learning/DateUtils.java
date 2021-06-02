package com.infosys.learning;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtils {
    public String dateTimeToFormat(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
}
