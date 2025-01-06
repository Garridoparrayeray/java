package objektuak;

public class Salmenta{
    private String artikulua;
    private int kantitatea;
    private double prezioa;
    private double gustizkoa;
    private Bezero bezeroa;
    private int salmenta_kod;
    private static int salmenta_hurrengo = 1;

    /*Konstruktore hutsa*/
    public Salmenta(){
        this.artikulua = "";
        this.kantitatea = 0;
        this.prezioa = 0.0;
        this.gustizkoa = 0.0;
        this.salmenta_kod = 0;
        this.bezeroa = null;//hasi objektu huts bezala
    }
    
    /*Kostruktorea datuak sartzeko */
    public Salmenta(String artikulua, int kantitatea, double prezioa, double gustizkoa, Bezero bezeroa, int salmenta_kod){
        if (kantitatea <= 0) {
            throw new IllegalArgumentException("Kantitatea 0 baino handiagoa izan behar da");
        }
        if (prezioa <= 0) {
            throw new IllegalArgumentException("Prezioa 0 baino handiagoa izan behar da");
        }
        this.artikulua = artikulua;
        this.kantitatea = kantitatea;
        this.prezioa = prezioa;
        this.gustizkoa = gustizkoa;
        this.bezeroa = bezeroa;
        this.salmenta_kod = salmenta_hurrengo++;
    }
    
    /*Konstruktore kopia bat*/
    public Salmenta(Salmenta otro){
        this.artikulua = otro.artikulua;
        this.kantitatea = otro.kantitatea;
        this.prezioa = otro.prezioa;
        this.gustizkoa = otro.gustizkoa;
        this.bezeroa = otro.bezeroa;
        this.salmenta_kod = otro.salmenta_kod;
    }

    /*GETTERAK eta SETTERRAK */

    public String getArtikulua() {
        return artikulua;
    }

    public void setArtikulua(String artikulua) {
        this.artikulua = artikulua;
    }

    public int getKantitatea() {
        return kantitatea;
    }

    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    public double getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }

    public double getGustizkoa() {
        return gustizkoa;
    }

    public void setGustizkoa(double gustizkoa) {
        this.gustizkoa = gustizkoa;
    }

    public Bezero getBezeroa() {
        return bezeroa;
    }

    public void setBezeroa(Bezero bezeroa) {
        this.bezeroa = bezeroa;
    }

    public int getSalmenta_kod() {
        return salmenta_kod;
    }

    public void setSalmenta_kod(int salmenta_kod) {
        this.salmenta_kod = salmenta_kod;
    }

    public static int getSalmenta_hurrengo() {
        return salmenta_hurrengo;
    }

    public static void setSalmenta_hurrengo(int salmenta_hurrengo) {
        Salmenta.salmenta_hurrengo = salmenta_hurrengo;
    }

    /*toString metodoa*/
    
    @Override
    public String toString() {
        return "Salmenta [artikulua=" + artikulua + ", kantitatea=" + kantitatea + ", prezioa=" + prezioa
                + ", gustizkoa=" + gustizkoa + ", bezeroa=" + bezeroa + ", salmenta_kod=" + salmenta_kod + "]";
    }

    /*hashcode eta equals metodoak*/
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + salmenta_kod;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Salmenta other = (Salmenta) obj;
        if (salmenta_kod != other.salmenta_kod)
            return false;
        return true;
    }
    
    
}
