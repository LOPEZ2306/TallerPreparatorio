package Propuesto3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodo m = new Metodo();

        System.out.println("=== SISTEMA DE COMPARACIÓN DE SUCURSALES ===");

        // 1. Pedir al usuario el tamaño de la matriz para la Sucursal 1
        System.out.println("--- Dimensiones Sucursal 1 ---");
        System.out.print("Ingrese el número de filas: ");
        int filas1 = sc.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas1 = sc.nextInt();

        // 2. Llenar la matriz para la Sucursal 1
        Venta[][] sucursal1 = m.llenarSucursal(filas1, columnas1, 1);

        // 3. Pedir al usuario el tamaño de la matriz para la Sucursal 2
        System.out.println("\n--- Dimensiones Sucursal 2 ---");
        System.out.print("Ingrese el número de filas: ");
        int filas2 = sc.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas2 = sc.nextInt();

        // 4. Llenar la matriz para la Sucursal 2
        Venta[][] sucursal2 = m.llenarSucursal(filas2, columnas2, 2);

        // 5. Comparar ambas sucursales indicando dónde vendió más la #1
        // Se compararán solo las posiciones que existan en ambas matrices
        // (intersección)
        m.compararVentas(sucursal1, sucursal2);

        sc.close();
    }
}
