package objetuak;

import java.io.Serializable;

public class Bezero implements Serializable, Comparable<Bezero> {
    private static final long serialVersionUID = 1L;
    private String izena;
    private String abizenak;
    private String nan;
    private int bezeroZenbakia;
    private double aurreztutakoDirua;
    private static int hurrengoBezeroZenbakia = 1000;

    public Bezero() {
        this.bezeroZenbakia = hurrengoBezeroZenbakia++;
    }

    public Bezero(String izena, String abizenak, String nan, double aurreztutakoDirua) {
        this();
        this.izena = izena;
        this.abizenak = abizenak;
        this.nan = nan;
        this.aurreztutakoDirua = aurreztutakoDirua;
    }

    public Bezero(Bezero besteBezero) {
        this(besteBezero.izena, besteBezero.abizenak, besteBezero.nan, besteBezero.aurreztutakoDirua);
    }

    // Getters y Setters
    public String getIzena() { return izena; }
    public void setIzena(String izena) { this.izena = izena; }
    public String getAbizenak() { return abizenak; }
    public void setAbizenak(String abizenak) { this.abizenak = abizenak; }
    public String getNan() { return nan; }
    public void setNan(String nan) { this.nan = nan; }
    public int getBezeroZenbakia() { return bezeroZenbakia; }
    public double getAurreztutakoDirua() { return aurreztutakoDirua; }
    public void setAurreztutakoDirua(double aurreztutakoDirua) { this.aurreztutakoDirua = aurreztutakoDirua; }

    @Override
    public String toString() {
        return bezeroZenbakia + "-" + izena + "_" + abizenak + "-" + aurreztutakoDirua + "€";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bezero bezero = (Bezero) obj;
        return bezeroZenbakia == bezero.bezeroZenbakia;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(bezeroZenbakia);
    }

    @Override
    public int compareTo(Bezero besteBezero) {
        return Double.compare(besteBezero.aurreztutakoDirua, this.aurreztutakoDirua);
    }
}
