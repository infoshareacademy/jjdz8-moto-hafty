package MotoHafty;

import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void start() {
        printMainMenuOptions();
        askUserForNumber();
    }

    public void printMainMenuOptions(){
        System.out.println("########################################################");
        System.out.println("Cześć, jestem BookShare. ");
        System.out.println("Daj znać co chcesz zrobić, wybierając odpowiednią cyfrę:");
        System.out.println("1 - Dodaj nową książkę");
        System.out.println("2 - Wyszukaj książkę w biblioteczce");
        System.out.println("3 - Zaktualizuj dane o książce");
        System.out.println("4 - Półka z książkami przeznaczonymi do wypożyczenia");
        System.out.println("5 - Importuj/Eksportuj biblioteczkę do pliku");
        System.out.println("6 - Zakończ działanie programu");
        System.out.println("########################################################");
    }

    public Integer askUserForNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wybierz odpowiednią liczbę:");
        return scanner.nextInt();
    }

}
