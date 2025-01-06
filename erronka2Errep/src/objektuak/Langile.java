package objektuak;

public class Langile extends Pertsona implements Comparable<Langile> {
	private double soldata;
    private String saila;
	private int Langile_zenb;
	private static int langile_hurreng = 1;//Static izan behar da, bestela, langile bakoitza bere kontadore pertsonala izango zuen

    /*Konstruktore hutsa*/
    public Langile() {
	    super();
        this.saila = "";
		this.soldata = 0.0;
        this.Langile_zenb = langile_hurreng++;
    }

    /*Eraikitzailaren kopia*/
    public Langile(Langile otro) {
        super(otro.getIzena(), otro.getAbizena(), otro.getNan(), otro.getAurreztu_diru());
        this.saila = otro.saila;
		this.soldata = otro.soldata;
        this.Langile_zenb = otro.Langile_zenb;
    }
    
    /*Datuak sartzeko eraikitzailea */
    public Langile(String izena, String abizena, String nan, double aurreztu_diru, double soldata, String saila) {
        super(izena, abizena, nan, aurreztu_diru);
        if (soldata < 0) {
            throw new IllegalArgumentException("Soldata negatiboa ez da onartua.");
        }
        this.saila = saila;
        this.soldata = soldata;
        this.Langile_zenb = langile_hurreng++;
    }
    
    /*GETTERAK eta SETTERRAK */
    
    public String getSaila() {
        return saila;
    }
    public void setSaila(String saila) {
        this.saila = saila;
    }
    public double getSoldata() {
        return soldata;
    }

    public void setSoldata(double soldata) {
        this.soldata = soldata;
    }

    public int getLangile_zenb() {
        return Langile_zenb;
    }

    public void setLangile_zenb(int langile_zenb) {
        Langile_zenb = langile_zenb;
    }


    /*toString metodoa*/

    @Override
    public String toString() {
        return Langile_zenb + "-" + getIzena() + "-" + getAbizena() + "-" + soldata;
    }

    /*hashcode eta equals metodoak*/

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(soldata);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((saila == null) ? 0 : saila.hashCode());
        result = prime * result + Langile_zenb;
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
        Langile other = (Langile) obj;
        if (Double.doubleToLongBits(soldata) != Double.doubleToLongBits(other.soldata))
            return false;
        if (saila == null) {
            if (other.saila != null)
                return false;
        } else if (!saila.equals(other.saila))
            return false;
        if (Langile_zenb != other.Langile_zenb)
            return false;
        return true;
    }

    /*CompareTo metodoa*/

    public int compareTo(Langile otro) {
        return Double.compare(this.getAurreztu_diru()
        , otro.getAurreztu_diru());/*Primitiboa denez , compareTo metodo normala ezin dugu erabili*/
    }
}
