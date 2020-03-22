package MotoHafty;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonConverter extends Library {

    public void convertLibraryToJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("booksInJson.json"), getAllBooks());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Szczegółowe informacje o wszystkich książkach zostały zapisane do pliku");
        System.out.println("Plik o nazwie booksInJson.json znajduje się w folderze programu ");
    }
}
