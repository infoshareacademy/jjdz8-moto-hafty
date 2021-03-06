package MotoHafty;

import java.util.Scanner;

public class Menu extends Library {

    public void start() {

        addTestBooksToLibrary();
        System.out.println("########################################################");
        System.out.println("Cześć, jestem BookShare. ");
        while (true) {
            clearScreen();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Daj znać co chcesz zrobić, wybierając odpowiednią cyfrę:");
            printMainMenuOptions();
            String number = askUserForNumber();
            switch (number) {
                case "1": {
                    System.out.println("Aby dodać nową książkę, podążaj za moimi poleceniami");
                    new AddNewBook1().addNewBook();
                    continue;
                }
                case "2": {
                    System.out.println("Aby wyszukać książkę, wybierz jedną z poniższych opcji");
                    printLineOfChars('-', true);
                    new Finder().finderMenu();
                    continue;
                }
                case "3": {
                    System.out.println("Aby zmienić dane dotyczące konkretnej ksiązki, podążaj za moimi poleceniami");
                    new BookDetailsUpdate3().updateBookDetails();
                    continue;
                }
                case "4": {
                    System.out.println("Aby zarządzać półką do wypożyczania, podążaj za moimi poleceniami");
                    printLineOfChars('-', true);
                    new Shelf().shelfMenu();
                    continue;
                }
                case "5": {
                    System.out.println("Aby importować/eksportować biblioteczkę do pliku, podążaj za moimi poleceniami");
                    new JsonConverter().jsonConverterMenu();
                    continue;
                }
                case "6": {
                    System.out.println("Program zostanie zamknięty");
                    System.out.println("Miłego dnia");
                    break;
                }
            }
            break;
        }
    }

    public void printMainMenuOptions() {
        System.out.println("1 - Dodaj nową książkę");
        System.out.println("2 - Wyszukaj książkę w biblioteczce");
        System.out.println("3 - Zaktualizuj dane o książce");
        System.out.println("4 - Półka z książkami przeznaczonymi do wypożyczenia");
        System.out.println("5 - Importuj/Eksportuj biblioteczkę do pliku");
        System.out.println("6 - Zakończ działanie programu");
        System.out.println("########################################################");
    }

    public String askUserForNumber() {
        boolean isNumberPicked = false;
        String number = "";
        while (!isNumberPicked) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybierz odpowiednią cyfrę:");
            number = scanner.nextLine();
            if (number.equals("1") || number.equals("2") || number.equals("3") || number.equals("4") || number.equals("5") || number.equals("6")) {
                clearScreen();
                System.out.println("Wybrano opcję nr " + number);
                isNumberPicked = true;
            } else {
                System.out.println("!!!Wybrano nieodpowiednią cyfrę, spróbuj jeszcze raz:");
                printMainMenuOptions();
                isNumberPicked = false;
            }
        }
        return number;
    }
}
