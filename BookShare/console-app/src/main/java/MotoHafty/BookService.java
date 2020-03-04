package MotoHafty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookService {

    //metoda wypluwa aktualny dzień w stringu

    public String dateStringNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(new Date());
    }

}
