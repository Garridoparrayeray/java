package ebal2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class arrayListIterator {

    public static void main(String[] args) {
        // ArrayList sortu string-ak gordetzeko
        ArrayList<String> stringList = new ArrayList<>();
        
        // Scanner objektua erabiltzailearen sarrera jasotzeko
        Scanner teklatua = new Scanner(System.in);
        System.out.println("Idatzi kateak (zuriunea sartzean amaituko da):");

        while (true) {
            // Sarrerako kate bat irakurri
            String input = teklatua.nextLine();
            
            // Zuriunea bada, bukatu
            if (input.isEmpty()) {
                break;
            }
            
            // Katea ArrayList-era gehitu
            stringList.add(input);
        }

        // Scanner itxi
        teklatua.close();
        
        // ArrayList edukia Iterator bidez erakutsi
        System.out.println("ArrayList-eko elementuak:");
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
