package ebal2;
import ebal2.Zenbaketa;

class ZenbaketaMain {
    public static void main(String[] args) {
        Zenbaketa zenbaketa1 = new Zenbaketa("Objektu 1", 5);
        Zenbaketa zenbaketa2 = new Zenbaketa("Objektu 2", 5);

        // Accede al campo estático zenbat mediante la clase Zenbaketa
        System.out.println("Instantziatu diren objektu kopurua: " + Zenbaketa.getZenbat());
    }
}