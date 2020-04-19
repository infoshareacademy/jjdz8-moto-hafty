package MotoHafty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Finder extends Library {

    public void printFinderMenuOptions() {

        System.out.println("1: po wybranych polach");
        System.out.println("2: gdziekolwiek");
        System.out.println("3: po ID");
        System.out.println("4: Powrót do menu głównego");
    }

    public void printFinderByFieldsOption() {

    }

    public void finderMenu () {
        Boolean isFinishedFinder = false;
        String number = "";
        while (!isFinishedFinder) {
            System.out.println("Wyszukiwanie: ");
            printFinderMenuOptions();
            number = scanner.nextLine();
            switch (number) {
                case "1": {
                    clearScreen();
                    System.out.println("Wybrano opcję nr 1");
                    System.out.println("Wyszukiwanie po wybranych polach");
                    printLineOfChars('-', true);
                    System.out.println("Wpisz fragment tekstu w poniższych polach do wyszukania (pola sa nieobowiązkowe)");
                    System.out.print("autor: ");
                    String searchAuthor = scanner.nextLine();
                    System.out.print("tytuł: ");
                    String searchTitle = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String searchIsbn = scanner.nextLine();
                    System.out.print("kategoria: ");
                    String searchCategory = scanner.nextLine();
                    System.out.print("przeczytana (tak/nie): ");
                    String searchReadString = "";
                    while (true) {
                        searchReadString = scanner.nextLine();
                        if (searchReadString.toLowerCase().trim().equals("tak")
                                || searchReadString.toLowerCase().trim().equals("t")
                                || searchReadString.toLowerCase().trim().equals("nie")
                                || searchReadString.toLowerCase().trim().equals("n")
                                || searchReadString.toLowerCase().trim().equals("")
                                || searchReadString.toLowerCase().trim().equals("+")) {
                            break;
                        } else {
                            System.out.print("Musisz wprowadzić tak/nie lub zostawić puste. Przeczytana (tak/nie):");
                        }
                    }

                    printLineOfChars('-', true);
                    if (searchAuthor.trim().equals("") && searchTitle.trim().equals("") && searchIsbn.trim().equals("")
                            && searchCategory.trim().equals("") && searchReadString.trim().equals("")) {
                        System.out.println("Nie wpisałeś nic do żadnego pola. Musisz uzupełnić conajmniej jedno pole.");
                        break;
                    }
                    System.out.println("Znalazłem dla Ciebie takie książki:");
                    printTableOfBooksByListOfId(findBookByFields(searchAuthor, searchTitle, searchIsbn, searchCategory, searchReadString));
                    continue;
                }
                case "2": {
                    clearScreen();
                    System.out.println("Wybrano opcję nr 2");
                    System.out.println("Wyszukiwanie gdziekolwiek");
                    printLineOfChars('-', true);
                    System.out.print("Wpisz fragment tekstu do wyszukania: ");
                    String searchAny = scanner.nextLine();
                    printLineOfChars('-', true);
                    System.out.println("Znalazłem dla Ciebie takie książki:");
                    printTableOfBooksByListOfId(findBookByAny(searchAny));
                    continue;
                }
                case "3": {
                    clearScreen();
                    System.out.println("Wybrano opcję nr 3");
                    System.out.println("Wyszukiwanie po ID");
                    printLineOfChars('-', true);
                    System.out.print("Wpisz numer ID książki do wyszukania: ");
                    String searchId = "";
                    while (true) {
                        searchId = scanner.nextLine();
                        if (searchId.trim().matches("\\d+")) {
                            break;
                        } else {
                            System.out.print("Musisz wprowadzić liczbę dodatnią. Wpisz numer ID książki do wyszukania: ");
                        }
                    }
                    printLineOfChars('-', true);
                    if (checkIsBookInLibrary(Integer.valueOf(searchId))) {
                        System.out.println("Poniżej szczegółowe informacje o książce:");
                        printLineOfChars('-', true);
                        printOneBookDetails(Integer.valueOf(searchId));
                    } else {
                        System.out.println("Nie znalazłem książki o takim ID");
                        printLineOfChars('-', true);
                    }
                    continue;
                }
                case "4": {
                    isFinishedFinder = true;
                    break;
                }
                default: {
                    System.out.println("!!!Wybrano nieodpowiednią opcję, spróbuj jeszcze raz:");
                }
            }
        }
    }

    public List<Integer> findBookByFields(String searchAuthor, String searchTitle, String searchIsbn, String searchCategory, String searchReadString) {
        boolean isReadSelected = false;
        boolean searchRead = false;
        if (searchReadString.toLowerCase().trim().equals("t") || searchReadString.toLowerCase().trim().equals("tak")
                || searchReadString.toLowerCase().trim().equals("+")) {
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
}
