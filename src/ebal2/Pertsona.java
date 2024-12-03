package ebal2;

public class Pertsona {
    protected String nan; // Se cambia a protected para que haya una herencia y se pueda acceder a la variable desde Ikaslea(es subclase)
    protected String izena;
    protected String abizena;
   
    //funcion de validacion
    public void balidatuString(String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " Ezin da izan nulo edo hutsik");
        }
    }
    //validacion de cada variable con la funcion balidatuString
    public void balidatuPertsona(String nan, String izena, String abizena) {
        balidatuString(nan, "NAN");
        balidatuString(izena, "Izena");
        balidatuString(abizena, "Abizena");
    }

    public Pertsona(String izena, String abizena, String nan) {
        this.nan = nan;
        this.izena = izena;
        this.abizena = abizena;
    }

    public String getNan() {
        return nan;
    }

    public void setNan(String nan) {
        this.nan = nan;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }  
    
}
