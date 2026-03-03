import java.util.Scanner;

public class Metodo {
    Scanner sc = new Scanner(System.in);

    // Método para llenar la matriz de empleados
    public Empleado[][] llenarEmpresa(int filas, int columnas) {
        Empleado[][] empresa = new Empleado[filas][columnas];
        System.out.println("\n--- Llenado de Empleados en la Empresa ---");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Empleado emp = new Empleado();
                System.out.println("\nDatos para la fila " + i + ", columna " + j + ":");

                System.out.print("Nombre: ");
                emp.setNombre(sc.next());

                System.out.print("Salario (ej. 3500000 o 3500000,50): ");
                emp.setSalario(sc.nextDouble());

                System.out.print("Departamento: ");
                emp.setDepartamento(sc.next());

                empresa[i][j] = emp;
            }
        }
        return empresa;
    }

    // Método para filtrar y retornar una nueva matriz (vector u arreglo
    // unidimensional)
    public Empleado[] filtrarPorSalario(Empleado[][] empresa) {
        // 1. Primero contamos cuántos cumplen la condición para poder crear
        // la nueva matriz del tamaño exacto y no desperdiciar espacio.
        int contador = 0;
        for (int i = 0; i < empresa.length; i++) {
            for (int j = 0; j < empresa[i].length; j++) {
                if (empresa[i][j] != null && empresa[i][j].getSalario() > 3000000) {
                    contador++;
                }
            }
        }

        // 2. Creamos la nueva matriz (arreglo) con el tamaño justo
        Empleado[] matrizFiltrada = new Empleado[contador];
        int indice = 0;

        // 3. Volvemos a recorrer para meter a los empleados validados en el nuevo
        // arreglo
        for (int i = 0; i < empresa.length; i++) {
            for (int j = 0; j < empresa[i].length; j++) {
                if (empresa[i][j] != null && empresa[i][j].getSalario() > 3000000) {
                    matrizFiltrada[indice] = empresa[i][j];
                    indice++; // avanzamos la posición del nuevo arreglo
                }
            }
        }

        return matrizFiltrada;
    }

    // Método que recibe un arreglo de empleados listos y los imprime en consola
    public void mostrarFiltrados(Empleado[] filtrados) {
        System.out.println("\n--- Empleados con Salario MAYOR a 3.000.000 ---");
        if (filtrados.length == 0) {
            System.out.println("Ningún empleado en la empresa supera este salario.");
        } else {
            for (int i = 0; i < filtrados.length; i++) {
                Empleado emp = filtrados[i];
                System.out.println("- Nombre: " + emp.getNombre() +
                        " | Salario: $" + emp.getSalario() +
                        " | Depto: " + emp.getDepartamento());
            }
        }
    }
}
