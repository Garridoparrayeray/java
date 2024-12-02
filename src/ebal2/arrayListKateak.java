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
            String input = scanner.nextLine();
            if (input.isEmpty()) { // String zuriak amaitzen du
                break;
            }
            stringList.add(input); // Sartu stringa listan
        }
        
        // Sartutako string guztiak pantailaratzea
        System.out.println("Sartutako stringak:");
        for (String str : stringList) {
            System.out.println(str);
        }
        
        scanner.close();
    }
}
