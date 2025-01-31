package objetuak;

import java.io.Serializable;

public class Salmenta implements Serializable {
    private static final long serialVersionUID = 1L;
    private String artikulua;
    private int kantitatea;
    private double prezioa;
    private double gustizkoa;
    private Bezero bezero;//Bezeroaren objektua implementatzen dogu
    private int salmentaKod;
    private static int hurrengoSalmentaKod = 1;

    public Salmenta() {
        this.salmentaKod = hurrengoSalmentaKod++;
    }

    public Salmenta(String artikulua, int kantitatea, double prezioa, Bezero bezero) {
        this();
        this.artikulua = artikulua;
        this.kantitatea = kantitatea;
        this.prezioa = prezioa;
        this.gustizkoa = kantitatea * prezioa;
        this.bezero = bezero;
    }

    public Salmenta(Salmenta besteSalmenta) {
        this(besteSalmenta.artikulua, besteSalmenta.kantitatea, besteSalmenta.prezioa, besteSalmenta.bezero);
    }

    // Getters y Setters
    public String getArtikulua() { return artikulua; }
    public void setArtikulua(String artikulua) { this.artikulua = artikulua; }
    public int getKantitatea() { return kantitatea; }
    public void setKantitatea(int kantitatea) { this.kantitatea = kantitatea; }
    public double getPrezioa() { return prezioa; }
    public void setPrezioa(double prezioa) { this.prezioa = prezioa; }
    public double getGustizkoa() { return gustizkoa; }
    public Bezero getBezero() { return bezero; }
    public void setBezero(Bezero bezero) { this.bezero = bezero; }
    public int getSalmentaKod() { return salmentaKod; }

    @Override
    public String toString() {
        return "Salmenta [artikulua=" + artikulua + ", kantitatea=" + kantitatea + ", prezioa=" + prezioa + "€, gustizkoa=" + gustizkoa + "€, salmentaKod=" + salmentaKod + ", " + bezero.getBezeroZenbakia() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Salmenta salmenta = (Salmenta) obj;
        return salmentaKod == salmenta.salmentaKod;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(salmentaKod);
    }
}