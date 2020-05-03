package MotoHafty;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonConverter extends Library {

    ObjectMapper mapper = new ObjectMapper();

    public void jsonConverterMenu() {
        Boolean isJsonConverterMenuDone = false;
        String number;
        while (!isJsonConverterMenuDone) {
            System.out.println("_________________________________");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Wybierz odpowiednią opcję: ");
            printJsonConverterMenuOptions();
            number = scanner.nextLine();
            switch (number) {
                case "1": {
                    importUserJsonFileToLibrary();
                    continue;
                }
                case "2": {
                    exportUserLibraryToJsonFile();
                    continue;
                }
                case "3": {
                    isJsonConverterMenuDone = true;
                    continue;
                }
                default: {
                    System.out.println("!!!Wybrano nieodpowiednią opcję, spróbuj jeszcze raz");
                }
            }
        }
    }

    public void printJsonConverterMenuOptions() {
        System.out.println("1: Import biblioteczki z pliku do aplikacji");
        System.out.println("2: Eksport biblioteczki z aplikacji do pliku");
        System.out.println("3: Powrót do menu głównego");
    }

    public void importUserJsonFileToLibrary() {
        boolean isUserJsonFileAddedToLIbrary = false;
        String fileName;
        while (!isUserJsonFileAddedToLIbrary) {
            System.out.println("Na początku umieść plik ze swoją biblioteczką w katalogu aplikacji,\na następnie " +
                    "podaj nazwę Twojego pliku, aby program zaimportował Twoje książki do biblioteczki.");
            fileName = scanner.nextLine();
            try {
                Book[] books = mapper.readValue(new File(fileName), Book[].class);
                for (Book book : books) {
                    getAllBooks().put(id, book);
                    id++;
                }
                System.out.println("Twoja biblioteczka została dodana do aplikacji.");
                isUserJsonFileAddedToLIbrary = true;
            } catch (IOException e) {
                System.out.println("Nazwa pliku, którą wpisałeś, nie odpowiada nazwie pliku załadowanego przez " +
                        "Ciebie do folderu BookShare.\nSpróbuj jeszcze raz, uważnie podążając za moimi " +
                        "poleceniami: ");
            }
        }
    }

    public void exportUserLibraryToJsonFile() {
        String fileName;
        boolean isUserLibraryExportedToJsonFile = false;
        while (!isUserLibraryExportedToJsonFile) {

            System.out.println("Podaj nazwę pliku do jakiego chcesz zapisać całą zaktualizowaną biblioteczkę");
            fileName = scanner.nextLine();
            System.out.println("Plik o nazwie " + fileName + ".json został zapisany. Po zakończeniu działania " +
                    "programu plik " + fileName + ".json będzie znajdował się w folderze BookShare");
            try {
                mapper.writeValue(new File(fileName + ".json"), getAllBooks());
            } catch (IOException e) {
                e.printStackTrace();
            }
            isUserLibraryExportedToJsonFile = true;
        }
    }
}
