package Ejercicio_5;

import java.util.Scanner;

public class Metodos {

    Scanner sc = new Scanner(System.in);

    // Método para llenar una matriz de productos (Tienda)
    public Producto[][] LlenarTienda(int filas, int columnas, String nombreTienda) {
        Producto[][] tienda = new Producto[filas][columnas];
        System.out.println("\n--- Llenando " + nombreTienda + " ---");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Producto p = new Producto();
                System.out.println("Producto [" + i + "][" + j + "]:");
                System.out.print("Nombre: ");
                p.setNombre(sc.next());
                System.out.print("Precio: ");
                p.setPrecio(sc.nextDouble());
                System.out.print("Stock: ");
                p.setStock(sc.nextInt());
                tienda[i][j] = p;
            }
        }
        return tienda;
    }

    // Método principal del ejercicio: Fusionar las dos tiendas
    public Producto[] FusionarTiendas(Producto[][] tienda1, Producto[][] tienda2) {

        // 1. Calcular el tamaño máximo posible para el arreglo resultante
        // El peor caso es que TODOS los productos sean diferentes.
        int totalProductosT1 = tienda1.length * tienda1[0].length;
        int totalProductosT2 = tienda2.length * tienda2[0].length;
        int tamanoMaximo = totalProductosT1 + totalProductosT2;

        // 2. Crear el arreglo unidimensional resultante
        Producto[] resultado = new Producto[tamanoMaximo];
        int k = 0; // 'k' es el índice para el arreglo resultante, representando el número de
                   // productos únicos registrados

        // 3. Trasladar los objetos Producto de la Tienda 1 al nuevo arreglo
        for (int i = 0; i < tienda1.length; i++) {
            for (int j = 0; j < tienda1[i].length; j++) {
                // Se crea una copia del producto para no afectar el original
                Producto pVendido = tienda1[i][j];
                Producto pCopia = new Producto(pVendido.getNombre(), pVendido.getPrecio(), pVendido.getStock());
                resultado[k] = pCopia;
                k++;
            }
        }

        // 4. Comparar el contenido de la Tienda 2 con el arreglo resultante
        for (int i = 0; i < tienda2.length; i++) {
            for (int j = 0; j < tienda2[i].length; j++) {

                Producto pActualT2 = tienda2[i][j];
                boolean encontrado = false;

                // Buscar si el producto de la Tienda 2 ya existe en el arreglo consolidado
                for (int m = 0; m < k; m++) {
                    if (resultado[m].getNombre().equalsIgnoreCase(pActualT2.getNombre())) {
                        // Si existe, sumar su stock al acumulado
                        int stockSumado = resultado[m].getStock() + pActualT2.getStock();
                        resultado[m].setStock(stockSumado);
                        encontrado = true;
                        break; // Terminar la búsqueda para este producto
                    }
                }

                // Si no existe, el producto es nuevo y se agrega al final del arreglo
                if (!encontrado) {
                    Producto pCopia = new Producto(pActualT2.getNombre(), pActualT2.getPrecio(), pActualT2.getStock());
                    resultado[k] = pCopia;
                    k++; // Se incrementa el contador de productos únicos registrados
                }
            }
        }

        // 5. Retornar un nuevo arreglo con el tamaño exacto de productos consolidados
        Producto[] inventarioFinal = new Producto[k];
        for (int i = 0; i < k; i++) {
            inventarioFinal[i] = resultado[i];
        }

        return inventarioFinal;
    }

    // Método para imprimir el arreglo final
    public void MostrarInventario(Producto[] inventario) {
        System.out.println("\n--- INVENTARIO FUSIONADO FINAL ---");
        System.out.printf("%-15s %-10s %-10s\n", "NOMBRE", "PRECIO", "STOCK TOTAL");
        System.out.println("----------------------------------------");
        for (int i = 0; i < inventario.length; i++) {
            System.out.printf("%-15s $%-9.2f %-10d\n",
                    inventario[i].getNombre(),
                    inventario[i].getPrecio(),
                    inventario[i].getStock());
        }
        System.out.println("----------------------------------------");
    }
}
