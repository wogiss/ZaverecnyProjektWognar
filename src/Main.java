package wogi;
import java.util.Scanner;

/**
 * @author wogi
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        //inicializace třídy SpravaEvidence
        SpravaEvidence spravaEvidence = new SpravaEvidence();

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("         Evidence pojištěných");
            System.out.println("----------------------------------------");

            System.out.println("Vyberte si akci:");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");
            try {
                int volba = Integer.parseInt(scanner.nextLine());
                switch (volba) {
                    case 1:
                        pridatPojisteneho(spravaEvidence);
                        vratSeNaZacatek();
                        break;
                    case 2:
                        vypsatVsechny(spravaEvidence);
                        vratSeNaZacatek();
                        break;
                    case 3:
                        vyhledatJednoho(spravaEvidence);
                        vratSeNaZacatek();
                        break;
                    case 4:
                        System.out.println("Díky za použití mojí parádní evidence.");
                        return;
                    default:
                        System.out.println("Neplatná volba zkuste to znovu.");
                }
            } catch (NumberFormatException e) { //validace číselného vstupu
                System.out.println("Neplatná volba, zkuste to znovu.");
            }
        }
    }
    //metoda uloží nového pojištěného
    private static void pridatPojisteneho(SpravaEvidence spravaEvidence) {
        String jmeno = zadatVstup("Zadejte jméno pojištěného:", 2, 30);
        String prijmeni = zadatVstup("Zadejte příjmení:", 2, 30);
        String telCislo = zadatTelCislo();
        int vek = zadatVek();

        spravaEvidence.pridatPojisteneho(jmeno, prijmeni, telCislo, vek);
        System.out.println("Data byla uložena.");
    }
    //metoda vypíše všechny pojištěné v seznamu
    private static void vypsatVsechny(SpravaEvidence spravaEvidence) {
        if (spravaEvidence.vypsatVsechny().isEmpty()) {
            System.out.println("Žádní pojištěnci nejsou evidováni.");
        } else {
            System.out.println("Seznam pojištěnců:");//cyklus foreach pro vypsání všech pojištěnců
            for (Pojisteny p : spravaEvidence.vypsatVsechny()) {
                System.out.println(p);
            }
        }
    }
    //metoda vyhledá pojištěnce podle jména a příjmení
    private static void vyhledatJednoho(SpravaEvidence spravaEvidence) {
        String jmeno = zadatVstup("Zadejte jméno pojištěného:", 2, 30);
        String prijmeni = zadatVstup("Zadejte příjmení pojištěného:", 2, 30);

        Pojisteny nalezeny = spravaEvidence.vyhledatJednoho(jmeno, prijmeni);
        if (nalezeny != null) {
            System.out.println(nalezeny);
        } else {
            System.out.println("Takový pojištěnec není v evidenci.");
        }
    }
    //metoda ziská textovy vstup jmena nebo prijmeni a zvaliduje jej
    private static String zadatVstup(String hlaska, int minDelka, int maxDelka) {
        String vstup;
        do {
            System.out.println(hlaska);
            vstup = scanner.nextLine().trim();
            if (vstup.length() < minDelka || vstup.length() > maxDelka) {
                System.out.println("Váš vstup je příliš krátký nebo dlouhý. Zadejte ho znovu.");
            }
        } while (vstup.length() < minDelka || vstup.length() > maxDelka);
        return vstup;
    }
    //ziská telefonní číslo a zaliduje jej
    private static String zadatTelCislo() {
        String telCislo;
        do {
            System.out.println("Zadejte telefonní číslo:");
            telCislo = scanner.nextLine().trim().replaceAll("\\s+", "");
            if (!telCislo.matches("\\d+")) {
                System.out.println("Toto není číselný vstup. Opakujte pokus.");
            }
        } while (!telCislo.matches("\\d+"));
        return telCislo;
    }
    //získá číselný vstup pro věk a zvaliduje jej
    private static int zadatVek() {
        int vek;
        while (true) {
            System.out.println("Zadejte věk:");
            try {
                vek = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Toto není číselný vstup. Opakujte pokus.");
            }
        }
        return vek;
    }

    // metoda nás vrátí zpátky do menu
    private static void vratSeNaZacatek() {
        System.out.println();
        System.out.println("Pokračujte libovolnou klávesou..");
        scanner.nextLine();
    }
}
