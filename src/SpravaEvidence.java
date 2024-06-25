package wogi;
import java.util.ArrayList;

/**
 * @author wogi
 */
public class SpravaEvidence {
    private ArrayList<Pojisteny> pojisteni = new ArrayList<>(); //deklarace listu pro seznam uzivatelu

    //metoda příjímá informace o novém pojištěnci, vytváří objekt nového pojíštěnce a vkládá ho do seznamu
    public void pridatPojisteneho(String jmeno, String prijmeni, String telCislo, int vek) {
        Pojisteny novyPojisteny = new Pojisteny(jmeno, prijmeni, telCislo, vek);
        pojisteni.add(novyPojisteny);
    }
    // vrací seznam všech pojištěných
    public ArrayList<Pojisteny>vypsatVsechny() {
        return pojisteni;
    }
    //metoda vyhledá pojištence podle jména a příjmení
    public Pojisteny vyhledatJednoho(String jmeno, String prijmeni) { //cyklus foreach projde vsechny polozky v seznamu
        for (Pojisteny p : pojisteni) {
            if (p.getJmeno().equalsIgnoreCase(jmeno) && p.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                return p;
            }
        }
        return null;
    }
}

