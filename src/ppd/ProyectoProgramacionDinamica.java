package ppd;

import java.io.*;

/*
   UNIVERSIDAD DEL VALLE
   FACULTAD DE INGENIERIA
   MATERIA FADA, TEMA OPTIMIZACIÓN
   PROYECTO JUSTIFICACIÓN DE TEXTO 

   Planteamiento:
 */
public class ProyectoProgramacionDinamica {

    public String Justificar(String words[], int width, int b) {

        String Variable1 = "";
        String Variable2 = "";

        int cost[][] = new int[words.length][words.length];

        //Acontinuación se representan dos bucles que me calcularan el costo 
        //de poner palabras de i a j  en una linea
        // Si las palabras  no encajan  en una linea, entonces ponemos un entero max_value
        for (int i = 0; i < words.length; i++) {
            cost[i][i] = width - words[i].length();
            for (int j = i + 1; j < words.length; j++) {
                cost[i][j] = cost[i][j - 1] - words[j].length() - 1;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (cost[i][j] < 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                    //System.out.print("prueba1 " + cost[i][j] + " |");
                } else {
                    cost[i][j] = (int) Math.pow(cost[i][j], 3);
                    // System.out.print("prueba2 " + cost[i][j] + " |");
                }
            }
        }
        //Muestra la matriz  cost
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                System.out.print(cost[i][j] + "\t");
            }
            System.out.println();
        }

        //minCost from i to len is found by trying
        //j between i to len and checking which
        //one has min value
        int minCost[] = new int[words.length];
        int result[] = new int[words.length];
        for (int i = words.length - 1; i >= 0; i--) {
            minCost[i] = cost[i][words.length - 1];
            result[i] = words.length;
            for (int j = words.length - 1; j > i; j--) {
                if (cost[i][j - 1] == Integer.MAX_VALUE) {
                    continue;
                }
                if (minCost[i] > minCost[j] + cost[i][j - 1]) {
                    minCost[i] = minCost[j] + cost[i][j - 1];
                    result[i] = j;
                }
            }
        }
        int n = 0;
        int Auxiliar1;

//        System.out.println("El Costo Minimo Es: " + minCost[0]);
//        System.out.println("\n");

        /*
          Finalmente pone todas las palabras con una nueva línea 
          agregada en el búfer de cadena y lo impríme.
         */
        StringBuilder builder = new StringBuilder();
        /*
        Un objeto StringBuilder es una secuencia de caracteres mutable, 
        su contenido y capacidad puede cambiar en cualquier momento. Además,
        a diferencia de los Strings, los builders cuentan con una capacidad (capacity),
        la cantidad de espacios de caracteres asignados. 
        Ésta es siempre mayor o igual que la longitud (length) y
        se expande automáticamente para acomodarse a más caracteres.
        
        Los operadores principales de la clase StringBuilder son append e insert. 
        Éstos se implementaron sobrecargados para aceptar cualquier tipo de datos.
        Cada uno convierte un dato en String y concatena o inserta los caracteres de dicho String al StrinBuilder.
        El método append agrega los caracteres al final de builder mientras que insert los agrega en un punto específico.
         */
        do {
            Auxiliar1 = result[n];
            for (int i = n; i < Auxiliar1; i++) {
                builder.append(words[i] + " ");

            }

            builder.append("\n");
            //System.out.println(builder.append("1"));
            n = Auxiliar1;
        } while (Auxiliar1 < words.length);

        if (b == 1) {
            return Variable1 = builder.toString();
        } else {
            return Variable2 = Integer.toString(minCost[0]);
        }

    }

    /*
        El Metodo @LongitudMaximaString saca la longitud maxima de un elemento en un arreglo 
        como podria ser una palabra, esto con el fin de hacer una validación 
        para el ancho del texto requerido y no genere conflicto con  el metodo 
        justificar; @LongitudString sacara la palabra mas larga del arreglo y 
        LNumbMaximo sacara  el tamaño en un dato numero  de la palabra mas larga
        en el arreglo.
     */
    public int LongitudMaximaString(String[] array) {

        int LongitudMax = 0;
        String LongitudString = null;
        for (String AuxMax : array) {
            if (AuxMax.length() > LongitudMax) {
                LongitudMax = AuxMax.length();
                LongitudString = AuxMax;
            }
        }
        //  System.out.println("Maximo Es: " + LongitudString);
        int LNumbMaximo = LongitudString.length();
        //  System.out.println("Maximo num Es: " + LMaximo);
        return LNumbMaximo;
    }

    public String[] LeerArchivo(File direccion) {

        String Texto = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String Aux = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                // haz ciclo, mientras bfRead tiene datos
                Aux = Aux + bfRead; // guardado el texto del archivo 
            }
            Texto = Aux;
            // variable donde queda guardado el texto
        } catch (Exception e) {
            System.err.println("No se encontro el archivo");
        }
        String[] arreglo = Texto.split(" ");

        return arreglo;
    }

}
