package ebal2;

import java.util.Scanner;

public class Ikasgai implements Comparable<Ikasgai> {
    private double nota;
    private String azalpena;
    private String Kode;
   
    public Ikasgai(){//CONSTRUCTOR PRINCIPAL DE LA CLASE Ikasgai. Se llaman igual//inicializar(lehenetsia) con "" todos los String
        this.azalpena = "";//poner this no es necesario pero es mejor ponerlo para luego erencias
        this.Kode = "";
        this.nota = 0.0;//nota no se puede inicializar con "" sino con 0.0
    }

    //CONSTRUCTOR PARA METER VALORES SIEMRPE EL MISMO NOMBRE QUE EL CONSTRUCTOR PRINCIPAL
    public Ikasgai(String nota, String azalpena, String kode){//metodo para meterle valores a lo seleccionado
        this.nota = nota;
        this.azalpena = azalpena;
        this.Kode = kode;
    }
    //CONTRUCTOR PARA HACER UNA COPIA
    public Ikasgai(Ikasgai bestebat){//CONSTRUCTOR PARA HACER UNA COPIA
        this.azalpena = bestebat.azalpena;
        this.Kode = bestebat.Kode;
        this.nota = bestebat.nota;
    }

    //getters y setters:
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getAzalpena() {
        return azalpena;
    }

    public void setAzalpena(String azalpena) {
        this.azalpena = azalpena;
    }

    public String getKode() {
        return Kode;
    }

    public void setKode(String kode) {
        Kode = kode;
    }

    /*TO STRING COMO USAR*/
    //PRIMERO DECLARA @Override antes de la declaración del método y definiendo cómo deseas que se represente tu objeto en forma de cadena.
    //Se puede crear como los getters y setters de forma automatica
    @Override
    //toString metodoa hurrengo testua bueltatzen duena "kodea – nota" bueltatzen duena
    public String toString() {
        return Kode + "-" + nota;//RETORNA EL KODE Y NOTA EN FORMATO DE STRING
    }//Con el to string con el override lo que haremos es que cuando llamemos a Ikasgai, en vez que darnos el valor inicializado nos lo va a sustituir por esa linea de codigo
    //el return-^

    /*nuestros metodos: */
     public void IrakurriDatuak(Scanner teklatua) {
        
        // Leer el Kode
        System.out.println("Sartu Kode: ");
        this.Kode = teklatua.nextLine();
        
        // Leer la Azalpena
        System.out.println("Sartu Azalpena: ");
        this.azalpena = teklatua.nextLine();
        
        // Leer la Nota
        System.out.println("Sartu nota(Zenbakia): ");
        while (true) {
            try {
                this.nota = Double.parseDouble(teklatua.nextLine());
                break; // Salir del bucle si la entrada es válida
            } catch (NumberFormatException e) {
                System.out.println("Sartu zenbaki egoki bat: ");
            }
        }
        
       
    }
    /* Generados automaticamente con source*/ 
    /* EQUALS Y HASHCODE GENERADOS automaticamente con source */ 

    @Override
    public boolean equals(Object obj) {
        // 1. Compara si ambos objetos son la misma instancia
        if (this == obj)
            return true;
        
        // 2. Verifica si el objeto pasado es nulo
        if (obj == null)
            return false;
        
        // 3. Verifica si los objetos son de la misma clase
        if (getClass() != obj.getClass())
            return false;
        
        // 4. Realiza un casting del objeto a Ikasgai para poder acceder a sus atributos
        Ikasgai other = (Ikasgai) obj;
        
        // 5. Compara las notas utilizando Double para evitar problemas de precisión
        if (nota != other.nota)
            return false;
        
        // 6. Compara el atributo 'azalpena', verificando si es nulo
        if (azalpena == null) {
            if (other.azalpena != null)
                return false; // Si el otro objeto tiene un 'azalpena' no nulo, no son iguales
        } else if (!azalpena.equals(other.azalpena))
            return false; // Compara el contenido de 'azalpena' si no es nulo
        
        // 7. Compara el atributo 'Kode', verificando si es nulo
        if (Kode == null) {
            if (other.Kode != null)
                return false; // Si el otro objeto tiene un 'Kode' no nulo, no son iguales
        } else if (!Kode.equals(other.Kode))
            return false; // Compara el contenido de 'Kode' si no es nulo
        
        // 8. Si todas las comparaciones son verdaderas, los objetos son iguales
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31; // Un número primo para reducir colisiones en el hash
        int result = 1; // Inicializa el resultado
        long temp;
        
        // 1. Convierte la nota a bits y calcula su hash
        temp = Double.doubleToLongBits(nota);
        result = prime * result + (int) (temp ^ (temp >>> 32)); // Mezcla el hash de nota
        
        // 2. Agrega el hash de 'azalpena', considerando el caso nulo
        result = prime * result + ((azalpena == null) ? 0 : azalpena.hashCode());
        
        // 3. Agrega el hash de 'Kode', considerando el caso nulo
        result = prime * result + ((Kode == null) ? 0 : Kode.hashCode());
        
        // 4. Devuelve el valor hash final
        return result;
    }
        /*EDO
        public int hashCode(){
            return Objects.hash(irudikari, erreala);//crea un hash entre irudikari y erreala
        }
    
    */

    //COMPARAZIOA compareTo()
    @Override
    public int compareTo(Ikasgai other) {
        // Primero compara por Kode
        int kodeComparazioa = this.Kode.compareTo(other.Kode);
        
        // Si Kode es diferente retorna el resultado de la comparación
        if (kodeComparazioa != 0) {
            return kodeComparazioa;
        }
        
        // Si Kode es igual, compara por nota
        return Double.compare(this.nota, other.nota);
    }
    

}
