package MotoHafty;

import java.util.*;

public class AddNewBook {

    Scanner scanner = new Scanner(System.in);
    List<String> authors = new LinkedList<>();

    public String askForTitle() {
        boolean isTitleOK = false;
        String title = "";
        while (!isTitleOK) {
            try {
                System.out.println("_________________________________");
                System.out.println("Wprowadź tytuł książki: ");
                title = scanner.nextLine();
                if (title.equalsIgnoreCase("") || title.trim().equalsIgnoreCase("")) {
                    System.out.println("Nazwa nie może być pusta");
                } else {
                    System.out.println("Wprowadzony tytuł to: " + title);
                    isTitleOK = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono błędne dane, spróbuj jeszcze raz:");
            }
        }
        return title;
    }

    public String askForName() {
        boolean isNameOK = false;
        String name = "";
        while (!isNameOK) {
            try {
                boolean allAuthorsAdded = false;
                System.out.println("_________________________________");
                System.out.println("Wprowadź imię i nazwisko autora: ");
                name = scanner.nextLine();
                if (name.equalsIgnoreCase("") || name.trim().equalsIgnoreCase("")) {
                    System.out.println("Imię i nazwisko autora nie moogą być puste");
                } else {
                    System.out.println("Wprowadzone dane autora to: " + name);
                    System.out.println("Wpisz \"+\", aby dodać kolejnego autora. Jeśli nie chcesz - naciśnij enter");
                    authors.add(name);
                    while (!allAuthorsAdded) {
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("+")) {
                            break;
                        } else {
                            isNameOK = true;
                            allAuthorsAdded = true;
                        }
                        System.out.println("Głównym autorem jest: " + authors.get(0));
                        System.out.println("Wszyscy autorzy: " + Arrays.toString(authors.toArray()));
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono błędne dane, spróbuj jeszcze raz");
            }
        }
        return name;
    }

    public String askForCategory() {
        boolean isCategoryOK = false;
        String category = "";
        while (!isCategoryOK) {
            try {
                System.out.println("_________________________________");
                System.out.println("Wybierz Dział: ");
                System.out.println("1 - Literatura Piękna");
                System.out.println("2 - Literatura Użytkowa");
                String number = scanner.nextLine();
                switch (number) {
                    case "1": {
                        System.out.println("Wybrano Literaturę Piękną");
                        category = category.concat("Literatura piękna | ");
                        System.out.println("Wybierz kategorię książki");
                        System.out.println("Możesz skorzystać z proponowanych opcji, lub wpisać samodzielnie: ");
                        System.out.println("1 - Poezja/Wiersze");
                        System.out.println("2 - Fantastyka/Science Fiction");
                        System.out.println("3 - Kryminał");
                        System.out.println("4 - Powieść");
                        System.out.println("5 - Dramat");
                        System.out.println("6 - Biografia/Pamiętniki");
                        System.out.println("7 - Bajki/Baśnie/Dla dzieci");
                        System.out.println("8 - Reportaże/Wywiady/Eseje");
                        System.out.println("9 - Wpisz swoją kategorię");

                        try {
                            String categoryNumber1 = scanner.nextLine();
                            switch (categoryNumber1) {
                                case "1": {
                                    category = category.concat("Poezja/Wiersze");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "2": {
                                    category = category.concat("Fantastyka/Science Fiction");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "3": {
                                    category = category.concat("Kryminał");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "4": {
                                    category = category.concat("Powieść");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "5": {
                                    category = category.concat("Dramat");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    break;
                                }
                                case "6": {
                                    category = category.concat("Biografia/Pamiętniki");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "7": {
                                    category = category.concat("Bajki/Baśnie/Dla dzieci");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;

                                }
                                case "8": {
                                    category = category.concat("Reportaże/Wywiady/Eseje");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;

                                }
                                case "9": {
                                    System.out.println("Wpisz nazwę swojej kategorii: ");
                                    String customCategory = scanner.nextLine();
                                    category = category.concat(customCategory);
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                default: {
                                    System.out.println("wybrano nieodpowiednią wartość, spróbuj jeszcze raz");
                                }
                            } break;
                        } catch (InputMismatchException e) {
                            System.out.println("Wprowadzono niepoprawne dane, spróbuj jeszcze raz");
                        }

                    }
                    case "2": {
                        System.out.println("Wybrano Literature Użytkową");
                        category = category.concat("Literatura użytkowa | ");
                        System.out.println("Wybierz kategorię książki");
                        System.out.println("Możesz skorzystać z proponowanych opcji, lub wpisać samodzielnie: ");
                        System.out.println("1 - Słowniki");
                        System.out.println("2 - Hobbystyczne/Poradniki");
                        System.out.println("3 - Podręczniki");
                        System.out.println("4 - Encyklopedie");
                        System.out.println("5 - Naukowe/Specjalistyczne");
                        System.out.println("6 - Przewodniki/Mapy/Atlasy");
                        System.out.println("7 - Popularnonaukowe");
                        System.out.println("8 - Wpisz swoją kategorię");

                        try {
                            String categoryNumber2 = scanner.nextLine();
                            switch (categoryNumber2) {
                                case "1": {
                                    category = category.concat("Słowniki");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "2": {
                                    category = category.concat("Hobbystyczne/Poradniki");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "3": {
                                    category = category.concat("Podręczniki");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "4": {
                                    category = category.concat("Encyklopedie");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "5": {
                                    category = category.concat("Naukowe/Specjalistyczne");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    break;
                                }
                                case "6": {
                                    category = category.concat("Przewodniki/Mapy/Atlasy");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "7": {
                                    category = category.concat("Popularnonaukowe");
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                case "8": {
                                    System.out.println("Wpisz nazwę swojej kategorii: ");
                                    String customCategory = scanner.nextLine();
                                    category = category.concat(customCategory);
                                    System.out.println("Kategoria wprowadzonej książki to: " + category);
                                    isCategoryOK = true;
                                    break;
                                }
                                default: {
                                    System.out.println("wybrano nieodpowiednią wartość, spróbuj jeszcze raz");
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Wprowadzono niepoprawne dane, spróbuj jeszcze raz");
                        }
                        break;
                    }
                    default:
                        System.out.println("Wprowadzono nieodpowiednią wartość, spróbuj jeszcze raz");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane, spróbuj jeszcze raz");
            }
        }
        return category;
    }

    public String askForISBN(){
        boolean isIsbnOk = false;
        String isbn = "";
        while (!isIsbnOk){
            try {
                System.out.println("_________________________________");
                System.out.println("Wprowadź ISBN książki: ");
                isbn = scanner.nextLine();
                if (isbn.matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")){
                    System.out.println("Wprowadzony ISBN to: " + isbn);
                    isIsbnOk = true;
                    break;
                }else {
                    System.out.println("wprowadzony ISBN jest niepoprawny, spróbuj jeszcze raz:");
                }
            }catch (InputMismatchException e ) {
                System.out.println("Wprowadzone dane są nieprawidłowe, spróbuj jeszcze raz");
        }
    }return isbn;
    }
}


