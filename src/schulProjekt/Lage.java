package schulProjekt;

import java.util.Scanner;

public class Lage {
    static Scanner scan = new Scanner(System.in);

    public static void mainMenu() {
        String vorzug = "";
        do {
            System.out.println("\t\t\t---Main Menu---\n" +
                    "\t 1- Scululeinformation Ansehen\n" +
                    "\t 2- Lehrer Menü\n" +
                    "\t 3- Schüler Menü\n" +
                    "\t 4- Quit\n");
            System.out.println("Bitte wählen Sie aus dem Menu");
            vorzug = scan.nextLine();
        }
        while (!vorzug.equalsIgnoreCase("q"));
    }
}
