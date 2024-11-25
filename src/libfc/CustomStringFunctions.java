package libfc;

public class CustomStringFunctions {

  // Implementación de strlen sin usar .length() y con un bucle for
  public static int ft_strlen(String str) {
      // Si la cadena es nula, retornamos 0
      if (str == null) {
          return 0;
      }

      int length = 0;

      // Usamos un bucle for para iterar sobre la cadena
      for (int i = 0; ; i++) {
          try {
              // Intentamos acceder al siguiente caracter
              str.charAt(i);
              length++;
          } catch (StringIndexOutOfBoundsException e) {
              // Cuando lleguemos al final de la cadena, lanzamos la excepción y salimos
              break;
          }
      }

      return length;
  }

  public static void main(String[] args) {
      String testStr = "Hola Mundo";
      System.out.println("La longitud de la cadena es: " + ft_strlen(testStr)); // Salida: 10
  }
}