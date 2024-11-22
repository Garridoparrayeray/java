package eba1l;
import java.util.Scanner;

public class batubikoitiw {
    public static void main(String[] args) {
        int n;
        int batura = 0;
        int i = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Sartu zenbaki oso bat: ");
        n = scanner.nextInt();
        scanner.close();
        while (n < 0) {
            System.out.print("Error. Sartu zenbaki oso positibo bat: ");
            n = scanner.nextInt();
        }

        while (i <= n) {
            if (i % 2 == 0) {
                batura += i;
            }
            i++;
        }
        System.out.println(batura);
    }
}