package MotoHafty;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    //Do zrobienia: osobne klasy dla każdej z opcji w menu, tak aby dało się zrobić ładnego switcha w metodzie start.

    public void start() {
        System.out.println("########################################################");
        System.out.println("Cześć, jestem BookShare. ");
        System.out.println("Daj znać co chcesz zrobić, wybierając odpowiednią cyfrę:");
        printMainMenuOptions();
        askUserForNumber();
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

    public Integer askUserForNumber() {
        boolean isNumberPicked = false;
        Integer number = null;
        while (!isNumberPicked) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Wybierz odpowiednią cyfrę:");
                number = scanner.nextInt();
                if (number >= 1 && number <= 6) {
                    System.out.println("Wybrano opcję nr " + number);
                    isNumberPicked = true;
                } else {
                    System.out.println("Wybrano nieodpowiednią cyfrę, spróbuj jeszcze raz:");
                    printMainMenuOptions();
                    isNumberPicked = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono błędną wartość");
                System.out.println("Spróbuj jeszcze raz:");
                printMainMenuOptions();
                isNumberPicked = false;
            }
        }
        return number;

    }
}
