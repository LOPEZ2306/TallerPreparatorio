# Ejercicio Propuesto 1: Hospital (Pacientes Críticos)

## Problema
En un hospital, los pacientes están organizados en una matriz. Cada celda contiene un objeto `Paciente` con atributos: `nombre`, `edad`, y `estado` (CRITICO, ESTABLE, ALTA). Escribe un algoritmo que cuente cuántos pacientes están en estado CRITICO y devuelva el total.

## Solución Implementada

Se implementó el ejercicio dividiéndolo en tres partes fundamentales: `Pacientes` (el objeto), `Metodo` (la lógica del hospital), y `Main` (la ejecución).

### 1. Llenado y Validación (Método `crearHospital`)
Se crea una matriz bidimensional (arreglo de arreglos) del objeto `Pacientes` basado en un número de filas y columnas. 
Para asegurar que los datos ingresados sean correctos, se utilizó un ciclo `do-while` para la validación del **Estado**. Solo se aceptan los valores: **CRITICO, ESTABLE y ALTA**.
```java
// Se usa equalsIgnoreCase para evitar errores por mayúsculas/minúsculas sin importar cómo el usuario lo escriba
if (estado.equalsIgnoreCase("CRITICO") || estado.equalsIgnoreCase("ESTABLE") || estado.equalsIgnoreCase("ALTA")) {
    estadoValido = true;
}
```

### 2. Algoritmo de Conteo (Método `contarCriticos`)
Se desarrolló un método que recibe por parámetro la matriz de pacientes ya llenada. 
Este método recorre cada celda de la matriz utilizando dos ciclos `for` anidados. En cada paso:
1. Extrae el paciente de la celda actual: `Pacientes p = hospital[i][j];`
2. Verifica que esa cama no esté vacía (`p != null`).
3. Compara el estado del paciente actual para ver si es igual a "CRITICO". Para ello, utilizamos `equalsIgnoreCase("CRITICO")`.
4. Si la condición se cumple, suma `1` a una variable contador.
Al terminar de procesar todas las posiciones de la matriz, el método retorna el total acumulado de pacientes críticos.