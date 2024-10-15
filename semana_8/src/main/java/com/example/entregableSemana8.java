package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class entregableSemana8{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los números separados por comas (,) ");
        String entrada = scanner.nextLine();

        String[] elementos = entrada.split(",");

        double[] datos = new double[elementos.length];
        int indice = 0;
        for (String elemento : elementos) {
            try {
                datos[indice] = Double.parseDouble(elemento.trim());
                indice++;
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números");
            }
        }

        // Eliminar elementos vacíos del arreglo
        double[] datosFiltrados = new double[indice];
        System.arraycopy(datos, 0, datosFiltrados, 0, indice);

        Map<Double, Integer> frecuencias = new HashMap<>();
        for (double dato : datosFiltrados) {
            if (frecuencias.containsKey(dato)) {
                frecuencias.put(dato, frecuencias.get(dato) + 1);
            } else {
                frecuencias.put(dato, 1);
            }
        }

        double moda = 0;
        int max = 0;
        for (Map.Entry<Double, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > max) {
                moda = entry.getKey();
                max = entry.getValue();
            }
        }

        System.out.println("La moda es: " + moda);

        scanner.close();
    }
}