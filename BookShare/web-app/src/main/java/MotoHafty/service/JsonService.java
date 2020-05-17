package MotoHafty.service;

import MotoHafty.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@LocalBean
@Stateful
public class JsonService {
    Map<Integer, Book> booksMap = new LinkedHashMap<>();
    public Map<Integer, Book> importUserJsonFileBooks(String fileName) {

        boolean isUserJsonFileAdded = false;
        while (!isUserJsonFileAdded) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                Book[] books = mapper.readValue(new File(fileName), Book[].class);
                Integer id = 0;
                for (Book book : books) {
                    booksMap.put(id, book);
                    id++;
                }
                isUserJsonFileAdded = true;
            } catch (IOException e) {

            }
        }
        return booksMap;
    }
}
