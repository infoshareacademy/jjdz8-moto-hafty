package MotoHafty;

public class JsonConverter extends Library {

    public Integer id = 9;

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
                    continue;
                }
                case "2": {
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

}

