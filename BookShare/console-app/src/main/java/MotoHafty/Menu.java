package MotoHafty;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    //Do zrobienia: osobne klasy dla każdej z opcji w menu, tak aby dało się uzupełnić switcha w metodzie start
    //Sugeruję, aby każda klasa z opcją miała na końcu nazwy numerek (ten który trzeba wcisnąć w menu)

    public void start() {
        System.out.println("########################################################");
        System.out.println("Cześć, jestem BookShare. ");
        System.out.println("Daj znać co chcesz zrobić, wybierając odpowiednią cyfrę:");
        printMainMenuOptions();
        String number = askUserForNumber();
        Boolean isFinished = false;
        while (!isFinished) {
            switch (number) {
                case "1": {
                    System.out.println("Aby dodać nową książkę, podążaj za moimi poleceniami");
                    new AddNewBook1().addNewBook();
                    isFinished = true;
                    break;
                }
                case "3": {
                    System.out.println("Aby zmienić dane dotyczące konkretnej ksiązki, podążaj za moimi poleceniami");
                    new BookDetailsUpdate3().updateBookDetails();
                }
                case "6": {
                    System.out.println("Program zostanie zamknięty");
                    System.out.println("Miłego dnia");
                    isFinished = true;
                    break;
                }
                default:
                    System.out.println("Wprowadzone dane są nieprawidłowe, spróbuj jeszcze raz");
                    break;
            }
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
                System.out.println("Wybrano opcję nr " + number);
                isNumberPicked = true;
            } else {
                System.out.println("Wybrano nieodpowiednią cyfrę, spróbuj jeszcze raz:");
                printMainMenuOptions();
                isNumberPicked = false;
            }
        }
        return number;
    }
}
