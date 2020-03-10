package MotoHafty;

public class App {
    public static void main(String[] args) {
        new Library().addTestBooksToLibrary();
        new Menu().start();
//        new Library().printAllBooks();
//        new JsonConverter().convertLibraryToJsonFile();
        new Library().printAllBooksOnlyAuthorsIdTitle();
    }
}
