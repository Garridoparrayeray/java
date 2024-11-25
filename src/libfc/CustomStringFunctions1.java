package libfc;

public class CustomStringFunctions1 {
   
		/*---------------------FT_STRLEN----------------*/
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
    
    
    /*------------------FT_STRCPY----------------*/
    public static String ft_strcpy(String src) {
      // Paso 1: Verificar si la cadena src es nula
      if (src == null) {
          return null;  // Si la cadena src es nula, devolvemos null
      }
      int length= ft_strlen(src);

      // Paso 2: Crear un arreglo de caracteres con el mismo tamaño que src
      char[] dest = new char[length];  // Se crea un arreglo de caracteres con el mismo tamaño que src

      // Paso 3: Recorrer la cadena src e ir copiando los caracteres uno por uno al arreglo dest
      for (int i = 0; i < length; i++) {
          dest[i] = src.charAt(i);  // Copiamos cada carácter de src a dest
      }

      // Paso 4: Crear una nueva cadena a partir del arreglo de caracteres dest y devolverla
      return new String(dest);  // Convertimos el arreglo de caracteres dest en una nueva cadena y la devolvemos
    }
    
    /*---------------------FT_SUBSTRING--------------*/
    // Función que simula substring
    public static String ft_substring(String str, int start, int end) {
        // Comprobamos que los índices estén dentro de la longitud de la cadena
        if (str == null || start < 0 || end > ft_strlen(str) || start >= end) {
            return "";  // Si no es válido, devolvemos una cadena vacía
        }

        // Creamos un contenedor para los caracteres
        char[] result = new char[end - start];

        // Copiamos los caracteres entre 'start' y 'end' en el arreglo
        for (int i = start; i < end; i++) {
            result[i - start] = str.charAt(i);  // Copiamos letra por letra
        }

        // Convertimos el arreglo de caracteres a una nueva cadena
        return new String(result);
    }


    /*//--------------------MAIN-------------------------
    public static void main(String[] args) {
        String testStr = "Hola Mundo";
        System.out.println("La longitud de la cadena es: " + ft_strlen(testStr));
        System.out.println("La copia es: " + ft_strcpy(testStr);
        String sub = ft_substring(testStr, 0, 4);
        System.out.println("Subcadena: " + sub);
    }*/
}

