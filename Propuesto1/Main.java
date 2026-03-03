package Propuesto1;

public class Main {
    public static void main(String[] args) {
        Metodo m = new Metodo();

        // 1. Llenamos el hospital usando el método de llenar (tamaño 2x2 para prueba)
        Pacientes[][] hospital = m.crearHospital(2, 2);

        // 2. Ejecutamos el método para contar críticos y le pasamos la matriz
        int totalCriticos = m.contarCriticos(hospital);

        // 3. Imprimimos el resultado devuelto
        System.out.println("Total de pacientes en estado CRITICO: " + totalCriticos);
    }
}
