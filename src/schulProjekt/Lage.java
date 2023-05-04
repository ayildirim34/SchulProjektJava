package schulProjekt;

import java.util.Scanner;

public class Lage {
    public static Scanner scan = new Scanner(System.in);

 static void mainMenu() throws InterruptedException {
        String vorzug = "";
        do {
            System.out.println("\t\t\t---Main Menu---\n" +
                    "\t 1- Scululeinformation Ansehen\n" +
                    "\t 2- Lehrer Menü\n" +
                    "\t 3- Schüler Menü\n" +
                    "\t Q- Quit\n");
            System.out.println("Bitte wählen Sie aus dem Menu");
            vorzug = scan.nextLine();

            switch (vorzug) {
                    case "1"    :
                        Lage.notierendieAngabezurSchule();
                        break;
                    case "2"    :
                        Lehrer.lehrerMenu();
                        break;
                    case "3"    :
                        Schüler.schülerMenu();
                        break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Bitte gebe -sie acccetable vorzug ein");
            }
        }
        while (!vorzug.equalsIgnoreCase("q"));
        Lage.projeStop();
    }

    public static void notierendieAngabezurSchule() throws InterruptedException {
        System.out.println("\t\t\t---Stern---\n" +
                "\t Adress : " + Schule.adress+
                "\n\t Telefon Nummer : " + Schule.telNum);
        Thread.sleep(3000);
    }


    public static void projeStop() {
        System.out.println("Sie sind aus dem Projekt ausgestiegen");
    }
}
