package ebal2;

import java.util.Objects;
import java.util.Scanner;

// Clase ariketa1 (representa un número complejo)
public class ariketa1 {
    private double erreala;
    private double irudikari;

    // Constructor vacío
    public ariketa1() {
        this.erreala = 0;
        this.irudikari = 0;
    }

    // Constructor copia
    public ariketa1(ariketa1 otro) {
        this.erreala = otro.erreala;
        this.irudikari = otro.irudikari;
    }

    // Constructor intercambiador
    public ariketa1(double irudikari, double erreala) {
        this.erreala = irudikari;
        this.irudikari = erreala;
    }

    // Métodos getter y setter
    public double getReal() {
        return erreala;
    }

    public void setReal(double erreala) {
        this.erreala = erreala;
    }

    public double getirudikari() {
        return irudikari;
    }

    public void setirudikari(double irudikari) {
        this.irudikari = irudikari;
    }

    // Método para pedir ambos valores al usuario
    public void pedirValores() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sartu parte erreala: ");
        this.erreala = scanner.nextDouble();
        System.out.print("Sartu parte irudikaria: ");
        this.irudikari = scanner.nextDouble();
        scanner.close();
    }
    /*---------ARIKETA LEHENENGO PARTEA------- ->*/
//  Formatoa ipintzeko metodoa
    public String formatear() {
        if (irudikari >= 0) {
            return erreala + " + " + irudikari + "i";
        } else {
            return erreala + " - " + (-irudikari) + "i";
        }
    }

    // Método para comparar dos números complejos
    public boolean esIgual(ariketa1 otro) {
        return this.erreala == otro.erreala && this.irudikari == otro.irudikari;
    }
    //de otro modo
    public int hashCode(){
        return Objects.hash(irudikari, erreala);//crea un hash entre irudikari y erreala
    }
}
/* ------------------- BIGARREN PARTEA ---------------*/
class ResolvedorEcuaciones {

    public static void main(String[] args) {
        // Verificar constructores de la clase ariketa1
        System.out.println("Ariketa 1 frogak:");

        // Constructor vacío
        ariketa1 hutsik_funtzioa = new ariketa1();
        System.out.println("Hutsik funtzioa:");
        System.out.println(hutsik_funtzioa.formatear());

        // Constructor con valores intercambiados
        ariketa1 trukatua = new ariketa1(5, -3);
        System.out.println("Funtzio trukatzailea:");
        System.out.println(trukatua.formatear());

        // Constructor copia
        ariketa1 kopia = new ariketa1(trukatua);
        System.out.println("Kopiaketa funtzioa:");
        System.out.println(kopia.formatear());

        // Probar la resolución de ecuaciones de segundo grado
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ekuazioa: ax^2 + bx + c = 0");
        System.out.print("Sartu a: ");
        double a = scanner.nextDouble();
        System.out.print("Sartu b: ");
        double b = scanner.nextDouble();
        System.out.print("Sartu c: ");
        double c = scanner.nextDouble();
        scanner.close();

        double x = b * b - 4 * a * c;

        System.out.println("Erresultadoak:");
        if (x > 0) {
            // Raíces reales
            double raiz1 = (-b + Math.sqrt(x)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(x)) / (2 * a);

            System.out.println("Erro erreala:");
            System.out.println("x1 = " + raiz1);
            System.out.println("x2 = " + raiz2);
        } else if (x == 0) {
            // Raíz doble
            double raiz = -b / (2 * a);

            System.out.println("Erro doble erreala:");
            System.out.println("x = " + raiz);
        } else {
            // Raíces imaginarias
            double ParteErreala = -b / (2 * a);
            double parteIrudikaria = Math.sqrt(-x) / (2 * a);

            ariketa1 raiz1 = new ariketa1(ParteErreala, parteIrudikaria);
            ariketa1 raiz2 = new ariketa1(ParteErreala, -parteIrudikaria);

            System.out.println("Erro irudikaria:");

            System.out.println("x1 = " + raiz1.formatear());
            System.out.println("x2 = " + raiz2.formatear());
        }
    }
}


