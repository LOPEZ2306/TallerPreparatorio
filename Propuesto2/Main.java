import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodo m = new Metodo();

        // 1. Aquí le pedimos al usuario que él mismo ponga el tamaño de la matriz
        System.out.print("Ingrese el número de filas de su matriz: ");
        int filas = sc.nextInt();

        System.out.print("Ingrese el número de columnas de su matriz: ");
        int columnas = sc.nextInt();

        // 2. Llenamos la empresa pasándole los datos que el usuario escogió
        Empleado[][] empresa = m.llenarEmpresa(filas, columnas);

        // 3. Filtramos los empleados y guardamos la respuesta en la nueva matriz
        // (arreglo)
        Empleado[] filtrados = m.filtrarPorSalario(empresa);

        // 4. Imprimimos por consola los resultados llamando al método encargado
        m.mostrarFiltrados(filtrados);

        sc.close();

    }

}
