package ebal2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Langilea extends Pertsona {
    String saila;
    String lanpostua;
    double soldata;

    // inicializar todo
    public Langilea() {
        super();// llamamos al constructor vacio de Pertsona() que ya está inicializado alli par
                // inicializarlo aqui tambien
        this.saila = "";
        this.lanpostua = "";
        this.soldata = 0.0;
    }

    // constructor para meter langile y pertsona
    public Langilea(String nan, String izena, String abizena, String saila, String lanpostua, double soldata) {
        super(nan, izena, abizena);
        this.saila = saila;
        this.lanpostua = lanpostua;
        this.soldata = soldata;
    }

    // Constructor para ir metiendo datos de Langile
    public Langilea(String saila, String lanpostua, double soldata) {
        this.saila = saila;
        this.lanpostua = lanpostua;
        this.soldata = soldata;
    }

    // hacer una copia de langile, recoges los atributos del super y los de langile
    // propio
    public Langilea(Langilea otro) {// haces una copia del objeto langile(otro)
        super(otro.getNan(), otro.getIzena(), otro.getAbizena());
        this.saila = otro.saila;
        this.lanpostua = otro.lanpostua;
        this.soldata = otro.soldata;
    }

    /* -----------------GETTERS Y SETTERS------------- */
    public String getSaila() {
        return saila;
    }

    public void setSaila(String saila) {
        this.saila = saila;
    }

    public String getLanpostua() {
        return lanpostua;
    }

    public void setLanpostua(String lanpostua) {
        this.lanpostua = lanpostua;
    }

    public double getSoldata() {
        return soldata;
    }

    public void setSoldata(double soldata) {
        this.soldata = soldata;
    }

    /* --------------------EQUALS, HASHCODE Y TO STRING--------------------- */

    @Override
    public String toString() {
        return "Langilea [nan=" + nan + ", saila=" + saila + ", lanpostua=" + lanpostua + ", soldata=" + soldata
                + ", izena=" + izena + ", abizena=" + abizena + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((saila == null) ? 0 : saila.hashCode());
        result = prime * result + ((lanpostua == null) ? 0 : lanpostua.hashCode());
        long temp;
        temp = Double.doubleToLongBits(soldata);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Langilea other = (Langilea) obj;
        if (saila == null) {
            if (other.saila != null)
                return false;
        } else if (!saila.equals(other.saila))
            return false;
        if (lanpostua == null) {
            if (other.lanpostua != null)
                return false;
        } else if (!lanpostua.equals(other.lanpostua))
            return false;
        if (Double.doubleToLongBits(soldata) != Double.doubleToLongBits(other.soldata))
            return false;
        return true;
    }

    public int hashCodeNan() {
        return this.toString().hashCode();
    }

    public int compareTo(Langilea other) {
        return this.getNan().compareTo(other.getNan());
    }

    public void irakurri() {
        Scanner teklatua = new Scanner(System.in);

       
        do {
            System.out.print("Sartu nortasuna: ");
            this.nan = teklatua.nextLine().trim();//trim erabiltzen da hutsuneak ipintzen badituzu, ez edukitzeko erroreak. Ezbeharrezko hutsuneak ipintzen badituzu
            if (this.nan.isEmpty()) {
                System.out.println("Nortasuna ezin da hutsik egon. Saiatu berriro.");
            }
        } while (this.nan.isEmpty());
        setNan(nan);

     
        do {
            System.out.print("Sartu izena: ");
            this.izena = teklatua.nextLine().trim();
            if (this.izena.isEmpty()) {
                System.out.println("Izena ezin da hutsik egon. Saiatu berriro.");
            }
        } while (this.izena.isEmpty());
        setIzena(izena);

        do {
            System.out.print("Sartu abizena: ");
            this.abizena = teklatua.nextLine().trim();
            if (this.abizena.isEmpty()) {
                System.out.println("Abizena ezin da hutsik egon. Saiatu berriro.");
            }
        } while (this.abizena.isEmpty());
        setAbizena(abizena);

     
        do {
            System.out.print("Saila: ");
            this.saila = teklatua.nextLine().trim();
            if (this.saila.isEmpty()) {
                System.out.println("Saila ezin da hutsik egon. Saiatu berriro.");
            }
        } while (this.saila.isEmpty());
        setSaila(saila);

        do {
            System.out.print("Lanpostua: ");
            this.lanpostua = teklatua.nextLine().trim();
            if (this.lanpostua.isEmpty()) {
                System.out.println("Lanpostua ezin da hutsik egon. Saiatu berriro.");
            }
        } while (this.lanpostua.isEmpty());
        setLanpostua(lanpostua);

        boolean sold = false;
        while (!sold) {
            System.out.print("Soldata: ");
            try {
                this.soldata = teklatua.nextDouble();
                teklatua.nextLine();
                if (this.soldata < 0) {
                    System.out.println("Soldata ezin da negatibo izan. Saiatu berriro.");
                } else {
                    setSoldata(soldata);
                    sold = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Soldata ez da zenbaki bat. Saiatu berriro.");
                teklatua.nextLine(); // Consumir la entrada inválida
            }
        }

        System.out.println("Langilearen datuak ondo sartu dira.");
    }
    
    public static void main(String[] args) {
        Langilea langilea = new Langilea();
        langilea.irakurri();
        System.out.println(langilea);
    }

}
