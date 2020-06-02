package MotoHafty.service;

import MotoHafty.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@LocalBean
@Stateful
public class JsonService {

    public Map<Integer, Book> importBooksJsonFile(String fileName) {
        Map<Integer, Book> booksMap = new LinkedHashMap<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(fileName);
            Book[] books = mapper.readValue(file, Book[].class);
            Integer id = 1;
            for (Book book : books) {
                if (book.getImgUrl().isBlank()){
                    book.setImgUrl("https://dictionary.cambridge.org/pl/images/thumb/book_noun_001_01679.jpg?version=5.0.97");
                }
                String fixedIsbn = book.getIsbn().replaceAll("\\D","");
                book.setIsbn(fixedIsbn);
                booksMap.put(id, book);
                id++;
            }
        } catch (IOException e) {
            System.out.println("File not found or broken: " + e.getMessage()); // ToDo replace with logger
            return Collections.emptyMap();
        }
        return booksMap;
    }

    public void exportBooksToJsonFile(Map<Integer, Book> books) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Book> booksList = new ArrayList<>();
        books.forEach((key, value) -> booksList.add(value));
        try {
            objectMapper.writeValue(
                    new FileOutputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("Books.json")).getPath()), booksList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
