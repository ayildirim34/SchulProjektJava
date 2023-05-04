package schulProjekt;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import static schulProjekt.Lage.scan;

public class Lehrer {
    static Map <String, String> lehrerMap = new HashMap<>();
    public static void fackeLehrerHinzufügen () {
        lehrerMap.put("11", "Ahmet, Yil, 1982, Mathe");
        lehrerMap.put("22", "Nagihan, Yil, 1984, Englisch");
        lehrerMap.put("33", "Nil, Yil, 1985, Deutsch");
        lehrerMap.put("44", "Burak, Yil, 1986, Sport");
    }
    public static void lehrerMenu() throws InterruptedException {
        String vorzug = "";
        do {
            System.out.println("\t\t\t---Lehrer Menu---\n" +
                    "\t 1- Lehrerinformation Ansehen\n" +
                    "\t 2- Lehrer Finden mit Vornamen\n" +
                    "\t 3- Lehrer Einfügen\n" +
                    "\t 4- Lehrer Delete nit Nummer\n" +
                    "\t A- Main Menu\n" +
                    "\t Q- Quit\n");
            vorzug = scan.nextLine();
            switch (vorzug) {
                case "1"    :
                    notierendieAngabezurLehrer();
                    break;
                case "2"    :
                    lehrerFinden();
                    break;
                case "3"    :
                    lehrerEinfügen();
                    break;
                case "4"    :
                    lehrerDelete();

                    break;
                case "A"    :
                    Lage.mainMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Bitte geben Sie acccetable vorzug ein");
            }

        } while(!vorzug.equalsIgnoreCase("q"));
    }
    public static void lehrerDelete() {
        System.out.println("Sei geben Nummer ein");
        String nummerDelete = scan.nextLine();

        String deleteValue = lehrerMap.get(nummerDelete);

        String ergebnisValue = lehrerMap.remove(nummerDelete);

        try {
            boolean ergebnis = (ergebnisValue.equals(deleteValue));
        } catch (Exception e) {
            System.out.println("Lehrer konnte nicht finden");
        }
    }
    public static void lehrerFinden() throws InterruptedException {
        System.out.println("Welche Lehrer Suchen Sie");
        String lehrerName = scan.nextLine();

        Set<Map.Entry<String, String>> lehrerEntrySet = lehrerMap.entrySet();

        System.out.println("\t\t\t---Lehrer List mit Vornamen---\n" +
                "No:    Vorname        Name     Geb.Year      Fach : ");

        for (Map.Entry<String, String> each: lehrerEntrySet
        ) {
            String eachKey = each.getKey();;
            String eachValue = each.getValue();

            String eachValuarr [] = eachValue.split(", ");

            if(lehrerName.equalsIgnoreCase(eachValuarr[0]))
            System.out.printf("%2s      %-8s    %-11s  %4s      %s \n", eachKey, eachValuarr[0],  eachValuarr[1], eachValuarr[2],  eachValuarr[3]);
        } Thread.sleep(3000);
    }
    public static void notierendieAngabezurLehrer() throws InterruptedException {
        Set<Map.Entry<String, String>> lehrerEntrySet = lehrerMap.entrySet();

        System.out.println("\t\t\t---Lehrer List---\n" +
                "No:    Vorname        Name     Geb.Year     Fach : ");

        for (Map.Entry<String, String> each: lehrerEntrySet
             ) {
            String eachKey = each.getKey();;
            String eachValue = each.getValue();

            String eachValuarr [] = eachValue.split(", ");

            System.out.printf("%2s      %-8s    %-11s  %4s      %s \n", eachKey, eachValuarr[0],  eachValuarr[1], eachValuarr[2],  eachValuarr[3]);
        } Thread.sleep(3000);
    }
    public static void lehrerEinfügen() {

        System.out.println("Nummer");
        String nummer = scan.nextLine();
        System.out.println("Name");
        String name = scan.nextLine();
        System.out.println("Nachname");
        String nachName = scan.nextLine();
        System.out.println("Geburt Year");
        String gebYear = scan.nextLine();
        System.out.println("Fach");
        String branch = scan.nextLine();

        String hinzufügenValue = name+ ", "+ nachName+ ", "+  gebYear+ ", "+branch;
        lehrerMap.put(nummer, hinzufügenValue);
    }
}
