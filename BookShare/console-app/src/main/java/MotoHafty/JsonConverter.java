package MotoHafty;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonConverter {

    Library library = new Library();
    ObjectMapper mapper = new ObjectMapper();

    public void convertLibraryToJsonFile() {
        try {
            mapper.writeValue(new File("booksInJson.json"), library.getBooks());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Szczegółowe informacje o wszystkich książkach zostały zapisane do pliku");
        System.out.println("Plik o nazwie booksInJson.json znajduje się w folderze programu ");
    }

}
