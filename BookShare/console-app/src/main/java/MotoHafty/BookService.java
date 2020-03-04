package MotoHafty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookService {

    public String dateStringNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(new Date());
    }

}
