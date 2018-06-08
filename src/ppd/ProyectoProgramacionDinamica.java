package ppd;

import java.io.*;

/*
   UNIVERSIDAD DEL VALLE
   FACULTAD DE INGENIERIA
   MATERIA FADA, TEMA OPTIMIZACIÓN
   PROYECTO JUSTIFICACIÓN DE TEXTO 
   
   Integrantes:
        Santiago Rivera Escobar ? 1664066
        Cristian Correa Serna - 1556137
        Víctor Hugo Romero García ? 1663967

   Planteamiento:

    Sea m[ j ] el vector que recibe las palabras del texto y sea C[ i ][ j-1 ]
    la matriz que guarda los costos de cada una de las líneas del texto. Teniendo
    en cuenta la sucesión de las palabras basados en el ancho asignado.
    Primero calculamos los costos de todas las líneas posibles en una matriz de dos 
    dimensiones C [i] [j]. El valor C[i] [j] indica el costo de poner palabras de i a j 
    en una sola línea donde i y j son índices de palabras en las secuencias de entrada. 
    Si una secuencia de palabras de i a j no cabe en una sola línea, entonces C[i] [j] 
    se considera infinito (para evitar que forme parte de la solución). Una vez que tenemos
    la matriz C [i] [j] construida, podemos calcular el costo total usando la recursividad 
    propuesta en el siguiente punto.
        m[ j ] + C[ i ][ j-1 ]
 */
public class ProyectoProgramacionDinamica {

    public String Justificar(String words[], int width, int b) {

        String Variable1 = "";
        String Variable2 = "";

        /*
            Acontinuación se representan dos bucles que me calcularan el costo 
            de poner palabras de i a j  en una linea Si las palabras  no encajan  en una linea,
            entonces ponemos un entero max_value
         */
        int cost[][] = new int[words.length][words.length];

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
                    //      System.out.print("prueba1 " + cost[i][j] + " |");
                } else {
                    cost[i][j] = (int) Math.pow(cost[i][j], 3);
                    //     System.out.print("prueba2 " + cost[i][j] + " |");
                }
            }
        }
//        //Muestra la matriz  cost
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words.length; j++) {
//                System.out.print(cost[i][j] + "\t");
//            }
//            System.out.println();
//        }

        int minCost[] = new int[words.length];
        int result[] = new int[words.length];
        for (int i = words.length - 1; i >= 0; i--) {
            minCost[i] = cost[i][words.length - 1];
            // System.out.println(cost[i][words.length - 1]);
            result[i] = words.length;
            for (int j = words.length - 1; j > i; j--) {
                if (cost[i][j - 1] == Integer.MAX_VALUE) {
                    continue;
                }
                if (minCost[i] > minCost[j] + cost[i][j - 1]) {
                    minCost[i] = minCost[j] + cost[i][j - 1];
                    //  System.out.println(minCost[j] + cost[i][j - 1]);
                    result[i] = j;
                }
            }
        }

        int n = 0;
        int Auxiliar1;

        /*
          Finalmente pone todas las palabras con una nueva línea 
          agregada en el búfer de cadena y lo impríme.
         */
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
        StringBuilder builder = new StringBuilder();
        do {
            Auxiliar1 = result[n];
            for (int i = n; i < Auxiliar1; i++) {
                builder.append(words[i] + " ");

            }

            builder.append("\n");

            n = Auxiliar1;
        } while (Auxiliar1 < words.length);

        /*
          @CSUR Me guarda el costo minimo  sin la ultima linea resta la ultima 
           posicion de los costo  con el total de los costos, 
           esta posicion puede ser cambiante en la columna de j. 
         */
        String CSUR = "";
        int CostoUltimaLinea = cost[cost.length - 1][cost.length - 1];
        //System.out.println("minCost :"+minCost[0]);

        if (minCost[0] - CostoUltimaLinea < 0) {

            for (int i = 1; minCost[0] - CostoUltimaLinea < 0; i++) {
                CostoUltimaLinea = cost[(cost.length - 1) - i][cost.length - 1];
            }
            if (CostoUltimaLinea == minCost[0]) {
                CSUR = Integer.toString(minCost[0]);
            } else {

                CSUR = Integer.toString(minCost[0] - CostoUltimaLinea);
            }
        } else {

            CSUR = Integer.toString(minCost[0] - CostoUltimaLinea);
        }

        if (b == 1) {
            return Variable1 = builder.toString();
        }
        if (b == 2) {
            return CSUR;
        } else {
            return Variable2 = Integer.toString(minCost[0]);
        }
    }

    /*
        El Metodo  @LongitudMaximaString saca la longitud maxima de un elemento en un arreglo 
        como podria ser una palabra, esto con el fin de hacer una validación 
        para el ancho del texto requerido y no genere conflicto con  el metodo 
        justificar; @LongitudString sacara la palabra mas larga del arreglo y 
        LNumbMaximo sacara  el tamaño en un dato numero  de la palabra mas larga
        en el arreglo.
     */
    public String LongitudMaximaString(String[] array) {

        int LongitudMax = 0;
        String LongitudString = null;
        for (String AuxMax : array) {
            if (AuxMax.length() > LongitudMax) {
                LongitudMax = AuxMax.length();
                LongitudString = AuxMax;
            }
        }
        //  System.out.println("Maximo Es: " + LongitudString);

        return LongitudString;
    }

    public String[] LeerArchivo(File direccion) {

        String Texto = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String Aux = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                // Hace ciclo, mientras bfRead tiene datos
                Aux = Aux + bfRead; // guardada el texto del archivo 
            }
            Texto = Aux;
            // variable donde queda guardado el texto
        } catch (Exception e) {
            System.err.println("No se encontro el archivo");
        }
        /*
            En Java el método split(String regEx) nos permite dividir una cadena en base
            a las ocurrencias de una expresión regular definida dentro. Ya que es una expresión 
            regular puede ser simplemente una letra, coma, signo o una construcción mas elaborada.
         */
        String[] arreglo = Texto.split(" ");

        return arreglo;
    }
}
