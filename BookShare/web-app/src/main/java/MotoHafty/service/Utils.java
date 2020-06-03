package MotoHafty.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

    public static List<String> getCategoryList() {
        return List.of("AUDIOBOOKI","BIOGRAFIE", "BIZNES", "EKONOMIA", "MARKETING", "DLA DZIECI", "DLA MłODZIEŻY", "FANTASY", "HISTORIA", "HORROR", "INFORMATYKA", "KOMIKS", "KRYMINAŁ", "SENSACJA", "THRILLER", "KSIĄŻKA REGIONALNA", "KUCHNIA I DIETY", "LEKTURY I POMOCE SZKOLNE", "LITERATURA FAKTU", "REPORTAŻ", "LITERATURA OBYCZAJOWA", "LITERATURA PIĘKNA OBCA", "LITERATURA PIĘKNA POLSKA", "NAUKA JĘZYKÓW", "NAUKI SPOŁECZNE I HUMANISTYCZNE", "NAUKI ŚCISŁE", "MEDYCYNA", "OBCOJĘZYCZNE", "PODRĘCZNIKI AKADEMICKIE", "PODRĘCZNIKI SZKOLNE", "EDUKACJA", "POEZJA", "AFORYZM", "DRAMAT", "PORADNIKI", "PRAWO", "RELIGIE I WYZNANIA", "ROZWÓJ OSOBISTY", "SCIENCE FICTION", "SPORT I WYPOCZYNEK", "SZTUKA", "TURYSTYKA I PODRÓŻE", "ZDROWIE", "RODZINA", "ZWIĄZKI");
    }

    public static String generateDateInStringNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(new Date());
    }


}
