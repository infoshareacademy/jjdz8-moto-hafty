package MotoHafty;

public class App {
    public static void main(String[] args) {
        new Menu().start();
        new Library().printAllBooks();
        new JsonConverter().convertLibraryToJsonFile();
    }
}
