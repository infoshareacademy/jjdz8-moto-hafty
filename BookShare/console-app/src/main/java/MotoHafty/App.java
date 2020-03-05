package MotoHafty;

public class App {
    public static void main(String[] args) {
        new AddNewBook().addNewBook();
        Library library = new Library();
        System.out.println(library.getBooks().values().toString());
    }


}
