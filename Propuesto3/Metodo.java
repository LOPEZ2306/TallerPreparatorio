package Propuesto3;

import java.util.Scanner;

public class Metodo {
    Scanner sc = new Scanner(System.in);

    // Método para llenar la matriz de ventas de una sucursal específica
    public Venta[][] llenarSucursal(int filas, int columnas, int numSucursal) {
        Venta[][] sucursal = new Venta[filas][columnas];
        System.out.println("\n--- Llenado de Ventas para Sucursal " + numSucursal + " ---");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Venta v = new Venta();
                System.out.println("\nDatos para la fila " + i + ", columna " + j + ":");

                System.out.print("Producto: ");
                v.setProducto(sc.next());

                System.out.print("Cantidad Vendida: ");
                v.setCantidadVendida(sc.nextInt());

                sucursal[i][j] = v;
            }
        }
        return sucursal;
    }

    // Método que compara dos matrices de ventas (pueden ser de tamaños distintos)
    // y muestra en qué posiciones la Sucursal 1 vendió más.
    public void compararVentas(Venta[][] sucursal1, Venta[][] sucursal2) {
        System.out.println("\n=== Resultados de la Comparación ===");

        // Si las matrices no son del mismo tamaño, le avisamos al usuario
        if (sucursal1.length != sucursal2.length || sucursal1[0].length != sucursal2[0].length) {
            System.out.println(
                    "Nota: Las matrices tienen tamaños diferentes. Solo se compararán las posiciones (coordenadas) que existan en AMBAS sucursales.\n");
        }

        boolean huboMayor = false;

        // Calculamos el número de filas comunes entre ambas sucursales (intersección)
        int filasComunes = Math.min(sucursal1.length, sucursal2.length);

        // Recorremos solo las filas que existen en las dos matrices
        for (int i = 0; i < filasComunes; i++) {

            // Calculamos el número de columnas comunes en la fila actual
            int colComunes = Math.min(sucursal1[i].length, sucursal2[i].length);

            // Recorremos solo las columnas que existen en las dos matrices
            for (int j = 0; j < colComunes; j++) {
                Venta v1 = sucursal1[i][j];
                Venta v2 = sucursal2[i][j];

                // Verificamos que ambos objetos de venta estén inicializados y no sean nulos
                if (v1 != null && v2 != null) {

                    // Si en esa posición exacta la 1 vendió más productos que la 2
                    if (v1.getCantidadVendida() > v2.getCantidadVendida()) {
                        System.out.println("- Posición [" + i + "][" + j + "]: La Sucursal 1 vendió más ("
                                + v1.getCantidadVendida() + " vs " + v2.getCantidadVendida() + ") del producto '"
                                + v1.getProducto() + "'.");
                        huboMayor = true;
                    }
                }
            }
        }

        // Si después de revisar las posiciones comunes no hubo nada mayor, avisamos
        if (!huboMayor) {
            System.out.println(
                    "La Sucursal 1 no logró vender más que la Sucursal 2 en ninguna de las posiciones comparadas.");
        }
    }
}
