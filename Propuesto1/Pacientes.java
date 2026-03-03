package Propuesto1;

public class Pacientes {
    private String nombre;
    private int edad;
    private String estado;


    public Pacientes() {
    }

    public Pacientes(String nombre, int edad, String estado) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
}