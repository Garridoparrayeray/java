package ebal2;

public class Ikaslea extends Pertsona {   
    private String maila;
    private String zikloa;

    public Ikaslea(String nan, String izena, String abizena, String maila, String zikloa) {
        super(nan, izena, abizena);//necesitas llamar al constructor de la clase padre para que funcione
        super.balidatuPertsona(nan, izena, abizena);
        this.balidatuIkaslea(maila, zikloa);
       /*------NO ES NECESARIO POR K LO LLAMAS DESDE SUPER------
        this.nan = nan;
        this.izena = izena;
        this.abizena = abizena; */
        this.maila = maila;
        this.zikloa = zikloa;
    }
    public void balidatuIkaslea(String maila, String zikloa){
        super.balidatuString(maila, "maila");
        super.balidatuString(zikloa, "zikloa");
    }
    public String getNan() {
        return nan;
    }

    public String getIzena() {
        return izena;
    }

    public String getAbizena() {
        return abizena;
    }

    public String getMaila() {
        return maila;
    }

    public String getZikloa() {
        return zikloa;
    }

    @Override
    public String toString() {
        return "Ikaslea{" +
                "nan='" + nan + '\'' +
                ", izena='" + izena + '\'' +
                ", abizena='" + abizena + '\'' +
                ", maila='" + maila + '\'' +
                ", zikloa='" + zikloa + '\'' +
                '}';
    }
}