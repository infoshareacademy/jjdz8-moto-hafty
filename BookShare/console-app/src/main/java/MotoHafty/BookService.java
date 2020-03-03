package MotoHafty;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookService {

    public String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public LocalDateTime generateTime() {
        return LocalDateTime.now();
    }

}
