package Ejercicio_5;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();

        System.out.println("--- FUSIÓN DE INVENTARIOS DE DOS TIENDAS ---");

        // 1. Pedir dimensiones de la Tienda 1
        System.out.println("\nConfiguración de la Tienda 1");
        System.out.print("Ingrese número de filas: ");
        int filas1 = sc.nextInt();
        System.out.print("Ingrese número de columnas: ");
        int col1 = sc.nextInt();

        // 2. Pedir dimensiones de la Tienda 2
        System.out.println("\nConfiguración de la Tienda 2");
        System.out.print("Ingrese número de filas: ");
        int filas2 = sc.nextInt();
        System.out.print("Ingrese número de columnas: ");
        int col2 = sc.nextInt();

        // 3. Llenar matrices
        Producto[][] tienda1 = m.LlenarTienda(filas1, col1, "Tienda 1");
        Producto[][] tienda2 = m.LlenarTienda(filas2, col2, "Tienda 2");

        // 4. Fusionar tiendas
        // Usar el método que fusiona ambas matrices en un solo arreglo unidimensional
        Producto[] inventarioFusionado = m.FusionarTiendas(tienda1, tienda2);

        // 5. Imprimir resultado final
        m.MostrarInventario(inventarioFusionado);

        sc.close();
    }
}
