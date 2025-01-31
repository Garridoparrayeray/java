package objetuak;

import java.io.Serializable;

public class Langile implements Serializable, Comparable<Langile> {
    private static final long serialVersionUID = 1L;
    private String izena;
    private String abizenak;
    private String nan;
    private String saila;
    private int langileZenbakia;
    private double soldata;
    private static int hurrengoLangileZenbakia = 1;

    /*Konstruktore hutsa */
    public Langile() {
        this.langileZenbakia = hurrengoLangileZenbakia++;
    }

    /*Konstruktore normala */
    public Langile(String izena, String abizenak, String nan, String saila, double soldata) {
        this();
        this.izena = izena;
        this.abizenak = abizenak;
        this.nan = nan;
        this.saila = saila;
        this.soldata = soldata;
    }

    /*Konstruktore kopia */
    public Langile(Langile besteLangile) {
        this(besteLangile.izena, besteLangile.abizenak, besteLangile.nan, besteLangile.saila, besteLangile.soldata);
    }

    // Getters y Setters
    public String getIzena() { return izena; }
    public void setIzena(String izena) { this.izena = izena; }
    public String getAbizenak() { return abizenak; }
    public void setAbizenak(String abizenak) { this.abizenak = abizenak; }
    public String getNan() { return nan; }
    public void setNan(String nan) { this.nan = nan; }
    public String getSaila() { return saila; }
    public void setSaila(String saila) { this.saila = saila; }
    public int getLangileZenbakia() { return langileZenbakia; }
    public double getSoldata() { return soldata; }
    public void setSoldata(double soldata) { this.soldata = soldata; }

    @Override
    public String toString() {
        return langileZenbakia + "-" + izena + "_" + abizenak + "-" + soldata + "€";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Langile langile = (Langile) obj;
        return langileZenbakia == langile.langileZenbakia;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(langileZenbakia);
    }

    @Override
    public int compareTo(Langile besteLangile) {
        return Double.compare(besteLangile.soldata, this.soldata);
    }
}