package ebal2;
import java.util.ArrayList;
import java.util.Scanner;

public class arrayListKateak {
    public static void main(String[] args) {
        //Array listak sortu
        ArrayList <String> array = new ArrayList<>();
        //Scanner sortu
        Scanner teklatua = new Scanner(System.in);
        System.out.println("Sartu stringak (sartu ' ' (string zuria) amaitzeko):");
        while (true) {
            String input = teklatua.nextLine();
            if (input.isEmpty()) { // String zuriak amaitzen du
                break;
            }
            array.add(input); // Sartu stringa listan
        }
        
        // Sartutako string guztiak pantailaratzea
        System.out.println("Sartutako stringak:");
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        
        teklatua.close();
    }
}
