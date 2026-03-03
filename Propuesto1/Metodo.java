package Propuesto1;

import java.util.Scanner;

public class Metodo {

    Scanner sc = new Scanner(System.in);

    // Llenado de pacientes
    public Pacientes[][] crearHospital(int filas, int columnas) {
        Pacientes[][] hospital = new Pacientes[filas][columnas];
        System.out.println("--- Llenado del Hospital ---");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Pacientes p = new Pacientes();
                System.out.println("Paciente para fila " + i + ", columna " + j + ":");
                System.out.print("Nombre: ");
                p.setNombre(sc.next());
                System.out.print("Edad: ");
                p.setEdad(sc.nextInt());
                String estado;
                boolean estadoValido;
                do {
                    System.out.print("Estado (CRITICO, ESTABLE, ALTA): ");
                    estado = sc.next(); // Leemos el estado como lo ingrese el usuario

                    // Validamos si es una de las 3 opciones permitidas ignorando
                    // mayúsculas/minúsculas
                    if (estado.equalsIgnoreCase("CRITICO") || estado.equalsIgnoreCase("ESTABLE")
                            || estado.equalsIgnoreCase("ALTA")) {
                        estadoValido = true;
                    } else {
                        System.out.println("Error: Solo se permite CRITICO, ESTABLE o ALTA. Intente de nuevo.");
                        estadoValido = false;
                    }
                } while (!estadoValido);

                p.setEstado(estado);
                hospital[i][j] = p;
            }
        }
        return hospital;
    }

    // Método para contar cuántos pacientes están en estado CRITICO
    public int contarCriticos(Pacientes[][] hospital) {
        int contador = 0;

        for (int i = 0; i < hospital.length; i++) {
            for (int j = 0; j < hospital[i].length; j++) {
                // Obtenemos el paciente de la celda actual
                Pacientes p = hospital[i][j];

                // Si el paciente no es nulo y su estado es "CRITICO"
                if (p != null && p.getEstado().equalsIgnoreCase("CRITICO")) {
                    contador++;
                }
            }
        }

        return contador;
    }
}
