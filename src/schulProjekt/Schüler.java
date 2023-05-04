package schulProjekt;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static schulProjekt.Lage.scan;

public class Schüler {

    static Map <String, String>  schülerMap = new HashMap<>();

    public static void fackeSchülerHinzufügen () {
        schülerMap.put("111", "Ali, Can, 2008, A");
        schülerMap.put("222", "Veli, Yan, 2009, A");
        schülerMap.put("333", "Ayse, Can, 2010, B");
        schülerMap.put("444", "Ali, San, 2011, B");
    }
    public static void schülerMenu() throws InterruptedException {
        String vorzug = scan.nextLine();
        do {
            System.out.println("\t\t\t---Schüler Menu---\n" +
                    "\t 1- Schülerinformation Ansehen\n" +
                    "\t 2- Schüler Finden mit Vornamen\n" +
                    "\t 3- Schüler Einfügen\n" +
                    "\t 4- Schüler Delete mit Nummer\n" +
                    "\t A- Main Menu\n" +
                    "\t Q- Quit\n");
            vorzug = scan.nextLine();
            switch (vorzug) {
                case "1":
                    notierendieAngabezurSchüler();
                    break;
                case "2":
                    schülerFinden();
                    break;
                case "3":
                    schülerEinfügen();
                    break;
                case "4":
                    schülerDelete();

                    break;
                case "A":
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
        public static void notierendieAngabezurSchüler () throws InterruptedException {

        Set<Map.Entry <String, String>> meinEnrySet = schülerMap.entrySet();

        System.out.println("\t\t\t---Schüler List---\n" +
                    "No:    Vorname        Name     Geb.Year     Klass : ");
        for (Map.Entry<String, String> each : meinEnrySet)
        {
            String eachKey = each.getKey();;
            String eachValue = each.getValue();

            String eachValuarr [] = eachValue.split(", ");

            System.out.printf("%2s      %-8s    %-11s  %4s      %s \n", eachKey, eachValuarr[0],  eachValuarr[1], eachValuarr[2],  eachValuarr[3]);
        } Thread.sleep(4000);
        }
        public static void schülerFinden () throws InterruptedException {
            System.out.println("Welche Schüler Suchen Sie");
            String schülerName = scan.nextLine();

            Set<Map.Entry<String, String>> meinEnrySet = schülerMap.entrySet();

            System.out.println("\t\t\t---Schüler List mit Vornamen---\n" +
                    "No:    Vorname        Name     Geb.Year      Klass : ");

            for (Map.Entry<String, String> each : meinEnrySet) {
                String eachKey = each.getKey();
                ;
                String eachValue = each.getValue();

                String eachValuarr[] = eachValue.split(", ");

                if (schülerName.equalsIgnoreCase(eachValuarr[0])) {
                    System.out.printf("%2s      %-8s    %-11s  %4s      %s \n", eachKey, eachValuarr[0], eachValuarr[1], eachValuarr[2], eachValuarr[3]);
                }
            } Thread.sleep(4000);
        }
        public static void schülerEinfügen () {
            System.out.println("Nummer");
            String nummer = scan.nextLine();
            System.out.println("Name");
            String name = scan.nextLine();
            System.out.println("Nachname");
            String nachName = scan.nextLine();
            System.out.println("Geburt Year");
            String gebYear = scan.nextLine();
            System.out.println("Klass");
            String klass = scan.nextLine();

            String hinzufügenValue = name+ ", "+ nachName+ ", "+  gebYear+ ", "+klass;
            schülerMap.put(nummer, hinzufügenValue);
        }

        public static void schülerDelete () {
            System.out.println("Sei geben Nummer ein");
            String nummerDelete = scan.nextLine();

            String deleteValue = schülerMap.get(nummerDelete);

            String ergebnisValue = schülerMap.remove(nummerDelete);

            try {
                boolean ergebnis = (ergebnisValue.equals(deleteValue));
            } catch (Exception e) {
                System.out.println("Schüler konnte nicht finden");
            }
        }
    }