package objektuak;

public class Pertsona {
    protected String Izena;
    protected String Abizena;
    protected String nan;
    protected Double aurreztu_diru;
    
    public Pertsona() {
        Izena = "";
        Abizena = "";
        nan = "";
        aurreztu_diru = 0.0;
    }

    public Pertsona(Pertsona otro) {
        Izena = otro.Izena;
        Abizena = otro.Abizena;
        nan = otro.nan;
        aurreztu_diru = otro.aurreztu_diru;
    }
    
    public Pertsona(String izena, String abizena, String nan, Double aurreztu_diru) {
        Izena = izena;
        Abizena = abizena;
        this.nan = nan;
        if(aurreztu_diru < 0) {
            throw new IllegalArgumentException("Aurreztu dirua negatiboa ez da onartua.");
        }
        this.aurreztu_diru = aurreztu_diru;
    }

    public String getIzena() {
        return Izena;
    }

    public void setIzena(String izena) {
        Izena = izena;
    }

    public String getAbizena() {
        return Abizena;
    }

    public void setAbizena(String abizena) {
        Abizena = abizena;
    }

    public String getNan() {
        return nan;
    }

    public void setNan(String nan) {
        this.nan = nan;
    }

    public Double getAurreztu_diru() {
        return aurreztu_diru;
    }

    public void setAurreztu_diru(Double aurreztu_diru) {
        this.aurreztu_diru = aurreztu_diru;
    }
    
    
}
