/**
 * Created by 46406163y on 23/01/17.
 */
public class Soci {

    private int soci_id;
    private String nom;
    private String cognom;
    private int edat;
    private String direccio;
    private int telefon;

    public Soci() {}

    public Soci(int soci_id, String nom, String cognom, int edat, String direccio, int telefon) {
        this.soci_id = soci_id;
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.direccio = direccio;
        this.telefon = telefon;
    }

    public int getSoci_id() {
        return soci_id;
    }

    public void setSoci_id(int soci_id) {
        this.soci_id = soci_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio() {
        this.direccio = direccio;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
}
