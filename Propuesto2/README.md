# Ejercicio Propuesto 2: Empresa (Filtro por Salario)

## Problema
Dada una matriz que representa una empresa, donde cada celda contiene un objeto `Empleado` con atributos `nombre`, `salario`, `departamento`, escribe un algoritmo que genere una nueva matriz que contenga únicamente los empleados cuyo salario sea mayor a 3.000.000.

## Solución Implementada

Se implementó el ejercicio organizándolo de la siguiente forma:

### 1. Tamaño dinámico (Solicitado al Usuario)
En la clase `Main.java`, en lugar de pasarle por código un número fijo (como 3x3), el algoritmo empieza pidiéndole al usuario mediante variables que escriba el número total de filas y columnas. Esas variables luego se pasan al método encargado de crearla:
```java
// El usuario pone las dimensiones
int filas = sc.nextInt();
int columnas = sc.nextInt();

Empleado[][] empresa = m.llenarEmpresa(filas, columnas);
```

### 2. Clase `Empleado`
Se creó la clase sencilla con sus atributos, un constructor vacío, y sus respectivos `getters` y `setters` para poder acceder al nombre, departamento y, sobre todo, evaluar matemáticamente el *salario*.

### 3. Generar la "Nueva Matriz" Filtrada
En Java, cuando se habla de crear "una nueva matriz con los resultados", es mucho más eficiente devolver un arreglo unidimensional (un vector) en vez de una matriz 2D llena de campos vacíos. 
Para hacerlo sin desperdiciar memoria, el algoritmo internamente hace dos cosas:
1. **Primer Recorrido:** Recorre la matriz completa de la empresa y cuenta a través de la variable condicional `(salario > 3000000)` cuántos empleados cumplen el requisito.
2. **Segundo Recorrido:** Se crea el nuevo arreglo unidimensional (`Empleado[]`) asignándole el tamaño recién contado. Finalmente, cada vez que en la matriz pilla a un empleado con `salario > 3000000`, ese único empleado se guarda ordenadamente en este nuevo arreglo, omitiendo a los que ganan menos.

*(Nota: Como la carpeta donde alojas este archivo se llamó `Propuesto 2` con un espacio en medio, se omitieron las etiquetas "package" al comienzo de los archivos para que Java no tuviera problemas al compilar).*