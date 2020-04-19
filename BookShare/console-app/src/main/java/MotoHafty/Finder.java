package MotoHafty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Finder extends Library {

    public void printFinderMenuOptions() {

        System.out.println("1: wybranych polach");
        System.out.println("2: gdziekolwiek");
        System.out.println("3: Powrót do menu głównego");
    }

    public void finderMenu () {
        Boolean isFinishedFinder = false;
        String number = "";
        while (!isFinishedFinder) {
            System.out.println("_________________________________");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Wyszukiwanie: ");
            printFinderMenuOptions();
            number = scanner.nextLine();
            switch (number) {
                case "1": {
                    System.out.println("Wpisz fragment tekstu w poniższych polach do wyszukania (pola sa nieobowiązkowe)");
                    System.out.print("autor: ");
                    String searchAuthor = scanner.nextLine();
                    System.out.print("tytuł: ");
                    String searchTitle = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String searchIsbn = scanner.nextLine();
                    System.out.print("kategoria: ");
                    String searchCategory = scanner.nextLine();
                    System.out.print("przeczytane (t/n): ");
                    String searchReadString = scanner.nextLine().toLowerCase();
                    if (searchAuthor.trim().equals("") && searchTitle.trim().equals("") && searchIsbn.trim().equals("") && searchCategory.trim().equals("") && searchReadString.trim().equals("")) {
                        System.out.println("Nie wpisałeś nic do żadnego pola!");
                    }
                    System.out.println("Znalazłem dla Ciebie takie książki:");
                    printTableOfBooksByListOfId(findBookByFields(searchAuthor, searchTitle, searchIsbn, searchCategory, searchReadString));
                    continue;
                }
                case "2": {
                    System.out.println("Wpisz fragment tekstu do wyszukania: ");
                    String searchAny = scanner.nextLine();
                    printTableOfBooksByListOfId(findBookByAny(searchAny));
                    continue;
                }
                case "3": {
                    isFinishedFinder = true;
                }
                default: {
                    System.out.println("!!!Wybrano nieodpowiednią opcję, spróbuj jeszcze raz");
                }
            }
        }
    }

    public List<Integer> findBookByFields(String searchAuthor, String searchTitle, String searchIsbn, String searchCategory, String searchReadString) {
        boolean isReadSelected = false;
        boolean searchRead = false;
        if (searchReadString.equals("t") || searchReadString.equals("tak")) {
            searchRead = true;
            isReadSelected = true;
        } else if (searchReadString.equals("n") || searchReadString.equals("nie")) {
            searchRead = false;
            isReadSelected = true;
        }
        Library finderLibrary = new Library();
        boolean finalIsReadSelected = isReadSelected;
        boolean finalSearchRead = searchRead;
        return finderLibrary.getAllBooks().entrySet().stream()
                .filter(e -> (e.getValue().getMainAuthorName().toLowerCase().contains(searchAuthor.toLowerCase())
                        || e.getValue().getAuthors().toString().contains(searchAuthor.toLowerCase()))
                        && e.getValue().getTitle().contains(searchTitle.toLowerCase())
                        && e.getValue().getIsbn().replaceAll("[^0-9]","").contains(searchIsbn.replaceAll("[^0-9]",""))
                        && e.getValue().getCategory().contains(searchCategory.toLowerCase())
                        && (e.getValue().getRead().equals(finalIsReadSelected ? finalSearchRead : true)
                        || e.getValue().getRead().equals(finalIsReadSelected ? finalSearchRead : false)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Integer> findBookByAny(String searchAny) {
        Library finderLibrary = new Library();
        return finderLibrary.getAllBooks().entrySet().stream()
                .filter(e -> e.getValue().getMainAuthorName().toLowerCase().contains(searchAny.toLowerCase())
                        || e.getValue().getAuthors().toString().contains(searchAny.toLowerCase())
                        || e.getValue().getTitle().contains(searchAny.toLowerCase())
                        || e.getValue().getIsbn().replaceAll("[^0-9]","").contains(searchAny.replaceAll("[^0-9]",""))
                        || e.getValue().getCategory().contains(searchAny.toLowerCase()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Integer> findBookByAuthor(String searchExpression) {
            Library finderLibrary = new Library();
            return finderLibrary.getAllBooks().entrySet().stream()
                .filter(e -> e.getValue().getMainAuthorName().toLowerCase().contains(searchExpression.toLowerCase()) || e.getValue().getAuthors().toString().contains(searchExpression.toLowerCase()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Integer> findBookByTitle(String searchExpression) {
        Library finderLibrary = new Library();
        return finderLibrary.getAllBooks().entrySet().stream()
                .filter(e -> e.getValue().getTitle().toLowerCase().contains(searchExpression.toLowerCase()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public List<Integer> findBookByISBN(String searchExpression) {
        Library finderLibrary = new Library();
        return finderLibrary.getAllBooks().entrySet().stream()
                .filter(e -> e.getValue().getIsbn().toLowerCase().replaceAll("-","").contains(searchExpression.toLowerCase()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public List<Integer> findBookByCategory(String searchExpression) {
        Library finderLibrary = new Library();
        return finderLibrary.getAllBooks().entrySet().stream()
                .filter(e -> e.getValue().getCategory().toLowerCase().contains(searchExpression.toLowerCase()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
