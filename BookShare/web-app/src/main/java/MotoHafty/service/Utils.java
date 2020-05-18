package MotoHafty.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String generateDateInStringNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(new Date());
    }

}
