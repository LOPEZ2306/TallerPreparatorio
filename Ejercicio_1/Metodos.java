package Ejercicio_1;

import java.util.Scanner;

public class Metodos {

    Scanner sc = new Scanner(System.in);

    // Método para llenar la matriz de productos
    public Producto[][] LlenarMatriz(int filas, int columnas) {
        Producto[][] almacen = new Producto[filas][columnas];
        System.out.println("--- Llenado del Almacén ---");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Producto p = new Producto();
                System.out.println("Producto para fila " + i + ", columna " + j + ":");
                System.out.print("Nombre: ");
                p.setNombre(sc.next());
                System.out.print("Precio: ");
                p.setPrecio(sc.nextDouble());
                System.out.print("Cantidad: ");
                p.setCantidad(sc.nextInt());
                almacen[i][j] = p;
            }
        }
        return almacen;
    }

    // Método para buscar un producto por su nombre
    public String BuscarProducto(Producto[][] almacen, String nombreBuscado) {
        for (int i = 0; i < almacen.length; i++) {
            for (int j = 0; j < almacen[i].length; j++) {
                if (almacen[i][j].getNombre().equalsIgnoreCase(nombreBuscado)) {
                    return "El producto '" + nombreBuscado + "' se encuentra en la posición: Fila " + i + ", Columna "
                            + j;
                }
            }
        }
        return "Producto '" + nombreBuscado + "' no encontrado en el almacén.";
    }

    // Método para mostrar los productos de la matriz
    public void MostrarAlmacen(Producto[][] almacen) {
        System.out.println("\n--- Inventario del Almacén ---");
        for (int i = 0; i < almacen.length; i++) {
            for (int j = 0; j < almacen[i].length; j++) {
                Producto p = almacen[i][j];
                System.out.println("[" + i + "][" + j + "] - Nombre: " + p.getNombre() + ", Precio: " + p.getPrecio()
                        + ", Cantidad: " + p.getCantidad());
            }
        }
    }
}
