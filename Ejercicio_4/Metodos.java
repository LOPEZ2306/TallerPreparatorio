package Ejercicio_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Metodos {

    Scanner sc = new Scanner(System.in);

    // Método para inicializar y llenar el teatro con objetos Asiento
    public Asiento[][] LlenarTeatro(int filas, int columnas) {
        Asiento[][] teatro = new Asiento[filas][columnas];
        System.out.println("--- Llenado de Asientos del Teatro ---");

        int numAsiento = 1; // Contador automático para el número de asiento

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Asiento a = new Asiento();
                System.out.println("Configurando Asiento en Fila " + i + ", Columna " + j + ":");

                a.setNumero(numAsiento++);
                a.setFila(i); // La 'fila' real que corresponde a la matriz

                System.out.print("Precio: ");
                a.setPrecio(sc.nextDouble());

                teatro[i][j] = a;
            }
        }
        return teatro;
    }

    // Método que utiliza Arrays.sort y un Comparator para ordenar cada fila por
    // precio ascendente
    public void OrdenarAsientosPorFila(Asiento[][] teatro) {
        for (int i = 0; i < teatro.length; i++) {
            // Arrays.sort recibe la fila completa (un arreglo unidimensional) y una regla
            // de comparación
            Arrays.sort(teatro[i], new Comparator<Asiento>() {
                @Override
                public int compare(Asiento a1, Asiento a2) {
                    // Double.compare devuelve:
                    // -1 si a1 < a2
                    // 0 si a1 == a2
                    // 1 si a1 > a2
                    // Esto indica al método sort cómo debe ordenar los objetos
                    return Double.compare(a1.getPrecio(), a2.getPrecio());
                }
            });
        }
    }

    // Método para imprimir el estado actual del teatro
    public void MostrarTeatro(Asiento[][] teatro) {
        System.out.println("\n--- MAPA DEL TEATRO ---");
        for (int i = 0; i < teatro.length; i++) {
            System.out.print("Fila " + i + ": ");
            for (int j = 0; j < teatro[i].length; j++) {
                System.out.printf("[#%02d | $%.2f] ", teatro[i][j].getNumero(), teatro[i][j].getPrecio());
            }
            System.out.println(); // Salto de línea al terminar la fila
        }
    }
}
