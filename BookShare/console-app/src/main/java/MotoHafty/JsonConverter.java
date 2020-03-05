package MotoHafty;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonConverter {

    public void convertLibraryToJsonFile() {
        Library library = new Library();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("booksInJson.json"), library.getBooks());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
