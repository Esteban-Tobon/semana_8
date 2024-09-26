package com.example;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese los números separados por comas: ");
        String entrada = scanner.nextLine();
        String[] elementos = entrada.split(",");
        double[] datos = new double[elementos.length];

        for (int i = 0; i < elementos.length; i++) {
            try {
                datos[i] = Double.parseDouble(elementos[i]);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número.");
                // Podríamos terminar la ejecución o intentar leer nuevamente
                // Aquí manejamos el error si el usuario ingresó algo que no es un número
            }
        }

        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Calcular la media");
            System.out.println("2. Calcular la mediana");
            System.out.println("3. Calcular la moda");
            System.out.println("4. Calcular la varianza");
            System.out.println("5. Calcular la desviación estándar");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Calcular la media
                    double suma = 0;
                    for (double dato : datos) {
                        suma += dato;
                    }
                    double media = suma / datos.length;
                    System.out.println("La media es: " + media);
                    break;
                case 2:
                    // Calcular la mediana
                    Arrays.sort(datos); // Ordenamos el array
                    int n = datos.length; // Cantidad de datos
                    double mediana;
                    if (n % 2 == 0) {
                        mediana = (datos[n / 2 - 1] + datos[n / 2]) / 2;
                    } else {
                        mediana = datos[n / 2];
                    }
                    System.out.println("La mediana es: " + mediana);
                    break;
                case 3:
                    // Calcular la moda
                    Map<Double, Integer> frecuencias = new HashMap<>();
                    for (double dato : datos) {
                        if (frecuencias.containsKey(dato)) {
                            frecuencias.put(dato, frecuencias.get(dato) + 1);
                        } else {
                            frecuencias.put(dato, 1);
                        }
                    }

                    double moda = datos[0]; // Inicializar con el primer elemento
                    int maxFrecuencia = 0;
                    for (Map.Entry<Double, Integer> entry : frecuencias.entrySet()) {
                        if (entry.getValue() > maxFrecuencia) {
                            moda = entry.getKey();
                            maxFrecuencia = entry.getValue();
                        }
                    }

                    System.out.println("La moda es: " + moda);
                    break;
                case 4:
                    // Calcular la varianza
                    suma = 0;
                    for (double dato : datos) {
                        suma += dato;
                    }
                    media = suma / datos.length;

                    double sumaCuadrados = 0;
                    for (double dato : datos) {
                        sumaCuadrados += Math.pow(dato - media, 2);
                    }

                    double varianza = sumaCuadrados / datos.length;
                    System.out.println("La varianza es: " + varianza);
                    break;
                case 5:
                    // Calcular la desviación estándar
                    suma = 0;
                    for (double dato : datos) {
                        suma += dato;
                    }
                    media = suma / datos.length;

                    sumaCuadrados = 0;
                    for (double dato : datos) {
                        sumaCuadrados += Math.pow(dato - media, 2);
                    }

                    varianza = sumaCuadrados / datos.length;
                    double desviacionEstandar = Math.sqrt(varianza);
                    System.out.println("La desviación estándar es: " + desviacionEstandar);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0); // Salir del programa
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

    }
}