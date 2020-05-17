package MotoHafty.service;

import MotoHafty.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@LocalBean
@Stateful
public class JsonService {

    public Map<Integer, Book> importUserJsonFileBooks(String fileName) {
        Map<Integer, Book> booksMap = new LinkedHashMap<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(fileName);
            Book[] books = mapper.readValue(file, Book[].class);
            Integer id = 0;
            for (Book book : books) {
                booksMap.put(id, book);
                id++;
            }
        } catch (IOException e) {
            System.out.println("File not found or broken: " + e.getMessage()); // ToDo replace with logger
            return Collections.emptyMap();
        }
        return booksMap;
    }
}