/**
 * Created by 46406163y on 23/01/17.
 */
public class Prestec {

    private int llibre_id;
    private int soci_id;
    private String llibre;
    private String soci;
    private String data_inici;
    private String data_final;

    public Prestec(int llibre_id, int soci_id, String llibre, String soci, int data_inici, int data_final) {}

    public Prestec(int llibre_id, int soci_id, String llibre, String soci, String data_inici, String data_final) {
        this.llibre_id = llibre_id;
        this.soci_id = soci_id;
        this.llibre = llibre;
        this.soci = soci;
        this.data_inici = data_inici;
        this.data_final = data_final;
    }

    public int getLlibre_id() {return llibre_id;}

    public void setLlibre_id(int llibre_id) {this.llibre_id = llibre_id;}

    public int getSoci_id() {return soci_id;}

    public void setSoci_id(int soci_id) {this.soci_id = soci_id;}

    public String getLlibre() {return llibre;}

    public void setLlibre(String llibre) {this.llibre = llibre;}

    public String getSoci() {return soci;}

    public void setSoci(String soci) {this.soci = soci;}

    public String getData_inici() {return data_inici;}

    public void setData_inici(String data_inici) {this.data_inici = data_inici;}

    public String getData_final() {return data_final;}

    public void setData_final(String data_final) {this.data_final = data_final;}
}
