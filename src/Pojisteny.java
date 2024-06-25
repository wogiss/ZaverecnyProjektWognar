package wogi;

/**
 * @author wogi
 */
public class Pojisteny {
    //založení proměnných
    private String jmeno;
    private String prijmeni;
    private String telCislo;
    private int vek;


    //konstruktor
    public Pojisteny(String jmeno, String prijmeni, String telCislo, int vek) {
        this.setJmeno(jmeno);
        this.setPrijmeni(prijmeni);
        this.setTelCislo(telCislo);
        this.setVek(vek);
    }
    //metoda vracející textový výstup
    @Override
    public String toString() {
        System.out.println();
        return getJmeno() + "  " + getPrijmeni() + "   " + getVek() + "       " + getTelCislo();
    }
    //gettery a settery
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public void setTelCislo(String telCislo) {
        this.telCislo = telCislo;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }
}

