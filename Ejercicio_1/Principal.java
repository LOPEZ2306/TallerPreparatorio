package Ejercicio_1;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();

        System.out.println("--- Ejercicio Almacén de Productos ---");

        // El ejercicio menciona 30 productos en total.
        // Podemos pedir las filas y columnas al usuario.
        System.out.print("Ingrese el número de filas del almacén: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese el número de columnas del almacén: ");
        int columnas = sc.nextInt();

        // Inicializar y llenar la matriz
        Producto[][] almacen = m.LlenarMatriz(filas, columnas);

        // Mostrar el inventario
        m.MostrarAlmacen(almacen);

        // Búsqueda de producto por nombre
        System.out.print("\nIngrese el nombre del producto que desea buscar: ");
        String nombreABuscar = sc.next();

        String resultadoBusqueda = m.BuscarProducto(almacen, nombreABuscar);
        System.out.println(resultadoBusqueda);
    }
}
