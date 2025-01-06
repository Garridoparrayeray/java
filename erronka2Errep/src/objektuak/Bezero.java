package objektuak;

public class Bezero extends Pertsona implements Comparable<Bezero> {
	private int bez_zenb;
	private static int bez_hurrengo = 1000;//Static izan behar da, bestela, bezeroak bere kontadore pertsonala izango zuen

	/*Konstruktore hutsa*/
	public Bezero() {
		super();
		this.bez_zenb = bez_hurrengo++;
	}
	
	/*Eraikitzailaren kopia*/
	public Bezero(Bezero otro){
        super(otro.getNan(), otro.getIzena(), otro.getAbizena(), otro.getAurreztu_diru());//erabiltzen dugu get() metodoa pertsonatik deitzen dugulako
		
        this.bez_zenb = otro.bez_zenb;//bezeroaren kopia nahi badugu ez dugu behar inkrementatu
    }

	/*Datuak sartzeko eraikitzailea */
	public Bezero(String nan, String izena, String abizena, double aurreztu_diru) {//Nan, izena, abizena, aurreztu_diru sartzeko eraikitzailea
		super(izena, abizena, nan, aurreztu_diru);
		this.bez_zenb = bez_hurrengo++;
	}

	/*GETTERAK eta SETTERRAK */
	
	public int getBez_zenb() {
		return bez_zenb;
	}

	public void setBez_zenb(int bez_zenb) {
		this.bez_zenb = bez_zenb;
	}

	
	/*toString metodoa*/
	@Override
	public String toString() {
		
		return bez_zenb + "-" + getIzena() + "-" + getAbizena() + "-" + getAurreztu_diru();
		/*return bez_zenb + "-" + Izena + "-" + Abizena + "-" + aurreztu_diru;*/
		/*gaizki dago, deitu behar dugu pertsonatik pribatuak direnez, pertsonatik hartzen dugu. getters eta setterrak erabiltzen */
	}

	/*hashcode eta equals metodoak*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bez_zenb;
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
		Bezero other = (Bezero) obj;
		if (bez_zenb != other.bez_zenb)
			return false;
		return true;
	}


	public int compareTo(Bezero otro) {
        return Double.compare(this.getAurreztu_diru()
		, otro.getAurreztu_diru());/*Primitiboa denez , compareTo metodo normala ezin dugu erabili*/
    }

}
