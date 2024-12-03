package ebal2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class arrayListIterator {
    public static void main(String[] args) {
        // ArrayList sortu
        ArrayList<String> array = new ArrayList<>();
        // Scanner sortu
        Scanner teklatua = new Scanner(System.in);
        System.out.println("Sartu stringak (sartu ' ' (string zuria) amaitzeko):");
        
        // Sartu stringak ArrayList-ean
        while (true) {
            String input = teklatua.nextLine(); // Irakurri input-a
            if (input.isEmpty()) { // String zuriak amaitzen du
                break;
            }
            array.add(input); // Sartu stringa listan
        }
        
        // Iterator sortu
        Iterator<String> iterator = array.iterator();
        
        // Sartutako string guztiak pantailaratzea iterator bidez
        System.out.println("Sartutako stringak:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // Hurrengo elementua atera eta pantailaratu
        }
        
        teklatua.close(); // Scanner itxi
    }
}