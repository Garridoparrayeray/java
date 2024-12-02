package ebal2;

import ebal2.Ikasgai;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IkasgaiMain {
    public static void main(String[] args) {
        // Crear una lista para almacenar objetos Ikasgai
        List<Ikasgai> ikasgaiList = new ArrayList<>();
        Scanner teklatua = new Scanner(System.in);

        // Crear y leer datos para los objetos Ikasgai
        int numberOfIkasgai = 2; // Cambia este número si necesitas más objetos
        int count = 0;

        while (count < numberOfIkasgai) {
            Ikasgai ikasgai = new Ikasgai();
            ikasgai.IrakurriDatuak(teklatua);
            ikasgaiList.add(ikasgai);
            count++;
        }

        // Imprimir los objetos leídos
        System.out.println("Ikasgaiak:");
        for (int i = 0; i < ikasgaiList.size(); i++) {
            System.out.println(ikasgaiList.get(i));
        }

        // Probar el método equals
        System.out.println("Ikasgai konparaketa:");
        if (ikasgaiList.size() >= 2 && ikasgaiList.get(0).equals(ikasgaiList.get(1))) {
            System.out.println("Ikasgaiak berdinak dira.");
        } else {
            System.out.println("Ikasgaiak ezberdinak dira.");
        }

        // Probar el método hashCode
        System.out.println("Hash codes:");
        if (ikasgaiList.size() >= 2) {
            System.out.println("Hash code Ikasgai 1: " + ikasgaiList.get(0).hashCode());
            System.out.println("Hash code Ikasgai 2: " + ikasgaiList.get(1).hashCode());
        }

        // Probar el método compareTo
        Collections.sort(ikasgaiList);
        System.out.println("Ikasgaiak ordenatuak:");
        for (int i = 0; i < ikasgaiList.size(); i++) {
            System.out.println(ikasgaiList.get(i));
        }

        teklatua.close();
    }
}