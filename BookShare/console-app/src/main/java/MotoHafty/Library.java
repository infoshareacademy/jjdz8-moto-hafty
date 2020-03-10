package MotoHafty;

import java.util.*;

public class Library extends Book {

   //narazie zrobiłem że jako id w mapie przypisuje się hashcode nowo utworzonej książki.
    //książka dodaje do mapy się w momencie utworzenia (metoda addNewBook)

    private static Map<Integer, Book> books = new LinkedHashMap<>();
    AddNewBook1 addNewBook1 = new AddNewBook1();

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public Library() {}

    public void setBooks(Map<Integer, Book> books) {
        Library.books = books;
    }

    public void printAllBooks (){
        System.out.println("_________________________________");
        System.out.println("W Biblioteczce znajdują się następujące ksiązki:");
        for (Map.Entry<Integer,Book> entry : books.entrySet()) {
            System.out.println("#########################################");
            System.out.println("ID: " + entry.getKey());
            System.out.println("Tytuł: " + entry.getValue().getTitle());
            System.out.println("Główny autor: " + entry.getValue().getAuthors().get(0));
            System.out.println("Wszyscy autorzy: " + entry.getValue().getAuthors().toString());
            System.out.println("Kategoria: " + entry.getValue().getCategory());
            System.out.println("ISBN: " + entry.getValue().getIsbn());
            System.out.println("Data dodania: " + entry.getValue().getInputDate());
            System.out.println("Status książki: " + (entry.getValue().getRead() ? "Przeczytana": "Nieprzeczytana"));
            System.out.println("Opis: " + entry.getValue().getDescription()); }

    }
    public void printAllBooksOnlyAuthorsIdTitle () {
        System.out.println("_________________________________");
        System.out.println("Skrócone dane wszystkich książek:");
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            System.out.println("#########################################");
            System.out.println("ID: " + entry.getKey());
            System.out.println("Tytuł: " + entry.getValue().getTitle());
            System.out.println("Główny autor: " + entry.getValue().getMainAuthorName());
        }
    }
    public void addTestBooksToLibrary(){

        List<String> authorsTestList = new ArrayList<>();
        authorsTestList.add("jakiśtam autor");
        authorsTestList.add("Kolejny autor do testów");
        authorsTestList.add("i następny żeby nie było");

        Book book1 = new Book("Wrócę, gdy będziesz spała", "Patrycja Dołowy",getAuthors(), "Literatura Piękna | Biografia/Pamiętniki", "978-83-8049-830-3", addNewBook1.generateDateInStringNow() ,true,"Książka o dzieciach z holokaustu");
        Book book2 = new Book("Snapchat story", "Billy Gallagher", getAuthors(), "Literatura Użytkowa | Popularnonaukowe", "978-83-240-4889-2", addNewBook1.generateDateInStringNow() ,false,"Historia snapchata i jego twórcy");
        Book book3 = new Book("Polskie badania nad myślą pedagogiczną w latach 1900-1939", "Sławomir Sztobryn", authorsTestList, "Literatura Użytkowa | Naukowe/Specjalistyczne", "83-89574-24-1", addNewBook1.generateDateInStringNow() ,false,"Nudna ksiązka xD");
        Book book4 = new Book("Współczesny behawioryzm - analiza zachowania od A do Z", "Przemysław Bąbel", getAuthors(), "Literatura Użytkowa | Naukowe/Specjalistyczne", "9788374892674", addNewBook1.generateDateInStringNow() ,true,"gfhg");
        Book book5 = new Book("Jekyll i Hyde", "John Rowan", getAuthors(), "Literatura Użytkowa | Popularnonaukowe", "ISBN: 9788389574961", addNewBook1.generateDateInStringNow() ,true,"a");
        Book book6 = new Book("People as care catalysts", "Richard Normann", getAuthors(), "Literatura Użytkowa | Popularnonaukowe", "isbn0-470-01778-3", addNewBook1.generateDateInStringNow() ,true,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi tempus elit et dapibus dictum. Cras consequat volutpat erat, eget rhoncus enim. Cras faucibus finibus lectus id pretium. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut eget neque ac tellus fermentum vulputate eu et augue. Pellentesque iaculis velit a ornare gravida. Nunc tincidunt imperdiet nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse potenti. Cras massa magna, egestas vel feugiat eget, ultricies at ex. ");
        Book book7 = new Book("Viral - jak zarażać ideami i tworzyć wirusowe treści tytuł tej ksiązki już się zakończył, ale chcę mieć długo do testów", "Piotr Bucki",getAuthors(), "Literatura Użytkowa | Popularnonaukowe", "9788301204631", addNewBook1.generateDateInStringNow() ,true,"Super Ksiązka polecam serdecznie ");
        Book book8 = new Book("Efektywne Zarządzanie Firmą Projektową", "Piotr Bilon", getAuthors(), "Literatura Użytkowa | Popularnonaukowe", "ISBN 9788394508005", addNewBook1.generateDateInStringNow() ,true,"blblablwlbalbl");
        Book book9 = new Book("Władza Pokusy i zagrożenia", "Annette Y. Lee-Chai", getAuthors(), "Literatura użytkowa | Podręczniki" , "978-83-7489-018-2" , addNewBook1.generateDateInStringNow() , true , "książka o czymś");
        Book book10 = new Book("Drucker o marketingu", "William A. Cohem", authorsTestList, "Literatura użytkowa | Podręczniki" , "978-83-63566-24-1" , addNewBook1.generateDateInStringNow() , true , "książka o czymś");
        Book book11 = new Book("Morderca za ścianą", "Davis M.Buss", getAuthors(), "Literatura użytkowa | Popularnonaukowe" , "978-83-7489-002-1" , addNewBook1.generateDateInStringNow() , false , "książka o czymś");
        Book book12 = new Book("Machiavelli w Brukseli", "Rinus van Schendelen", getAuthors(), "Literatura użytkowa | Podręczniki" , "83-89574-93-4" , addNewBook1.generateDateInStringNow() , false , "książka o czymś");
        Book book13 = new Book("Wywieranie wpływu na ludzi", "Robert B.", getAuthors(), "Literatura użytkowa | bleble" , "978-83-7489-250-6" , addNewBook1.generateDateInStringNow() , true , "książka o czymś");
        Book book14 = new Book("Błyskawiczne wywieranie wpływu", "Michael V. Pantalon", getAuthors(), "Literatura użytkowa | Podręczniki" , "9788374893466" , addNewBook1.generateDateInStringNow() , false , "książka o czymś");
        Book book15 = new Book("Full Frontal PR", "Richard Laermer", getAuthors(), "Literatura użytkowa | Popularnonaukowa" , "1-57660-099-8" , addNewBook1.generateDateInStringNow() , false , "książka o czymś");
        Book book16 = new Book("Mówisz, masz", "George R. Walther", getAuthors(), "Literatura użytkowa | Podręczniki" , "ISBN 9788389574213" , addNewBook1.generateDateInStringNow() , true , "książka o czymś");

        books.put(book1.hashCode(),book1);
        books.put(book2.hashCode(),book2);
        books.put(book3.hashCode(),book3);
        books.put(book4.hashCode(),book4);
        books.put(book5.hashCode(),book5);
        books.put(book6.hashCode(),book6);
        books.put(book7.hashCode(),book7);
        books.put(book8.hashCode(),book8);
        books.put(book9.hashCode(),book9);
        books.put(book10.hashCode(),book10);
        books.put(book11.hashCode(),book11);
        books.put(book12.hashCode(),book12);
        books.put(book13.hashCode(),book13);
        books.put(book14.hashCode(),book14);
        books.put(book15.hashCode(),book15);
        books.put(book16.hashCode(),book16);
    }
}
