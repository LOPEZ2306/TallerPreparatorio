package Ejercicio_4;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();

        System.out.println("--- ORDENAMIENTO DE ASIENTOS POR PRECIO ---");

        // 1. Configurar las dimensiones del teatro
        System.out.print("\nIngrese el número de filas del teatro: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese el número de asientos por fila (columnas): ");
        int columnas = sc.nextInt();

        // 2. Inicializar y llenar la matriz
        Asiento[][] teatro = m.LlenarTeatro(filas, columnas);

        // 3. Imprimir el teatro en su estado inicial (Desordenado)
        System.out.println("\n--- TEATRO ORIGINAL ---");
        m.MostrarTeatro(teatro);

        // 4. Invocar el método de ordenamiento utilizando Arrays.sort
        m.OrdenarAsientosPorFila(teatro);

        // 5. Imprimir el teatro en su estado final (Ordenado por precio ascendente)
        System.out.println("\n--- TEATRO ORDENADO POR PRECIO ---");
        m.MostrarTeatro(teatro);

        sc.close();
    }
}
