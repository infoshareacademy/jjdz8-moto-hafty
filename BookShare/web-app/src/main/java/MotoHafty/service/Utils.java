package MotoHafty.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsService {

    public static String generateDateInStringNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(new Date());
    }

}
