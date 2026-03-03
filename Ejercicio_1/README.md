# Guía de Estudio: Ejercicio 1 - Buscar en un Almacén

¡Hola! Este documento está diseñado para ayudarte a estudiar y entender paso a paso cómo funciona el código del Ejercicio 1, sin usar palabras raras ni complicadas. Ideal para repasar antes de tu parcial.

---

## 🏗️ ¿Cómo está organizado el código?

Tenemos 3 archivos, como si fueran 3 piezas de un rompecabezas:

1. **`Producto.java`**: Es nuestro *molde*. Aquí le decimos a Java cómo es un producto (qué características tiene: nombre, precio y cantidad).
2. **`Metodos.java`**: Aquí está *"el cerebro"* de la operación. Tiene las instrucciones de cómo llenar el almacén y cómo buscar un producto.
3. **`Principal.java`**: Es el *jefe* que da las órdenes. Le pregunta al usuario cuántas filas y columnas quiere, y luego manda a llamar a los métodos de la clase `Metodos` para hacer el trabajo.

---

## 🧠 Explicación de los Conceptos Clave

Aquí te explico despacio qué significa cada línea importante y cuándo debes usarlas en tus exámenes:

### 1. Las Matrices (El "Almacén")
`Producto[][] almacen = new Producto[filas][columnas];`
- **¿Qué es?** Imagina una cubeta de hielos o una hoja de Excel, que tiene **filas** (hacia abajo) y **columnas** (hacia los lados). 
- **¿Cuándo usarlo?** Cuando en el ejercicio te pidan guardar cosas en forma de tabla o cuadrícula (como los asientos de un cine, o en este caso, espacios de un almacén). 

### 2. Los bucles anidados (`for` dentro de otro `for`)
```java
for (int i = 0; i < filas; i++) {
    for (int j = 0; j < columnas; j++) {
        // ...
    }
}
```
- **¿Cómo funciona?** El primer `for` (la `i`) es para las filas. El segundo `for` (la `j`) es para las columnas. 
- Piensa en esto como una barredora: la barredora empieza en la primera fila (`i=0`) y limpia cada asiento de esa fila, columna por columna (`j=0`, `j=1`...). Cuando termina la fila, baja a la siguiente (`i=1`) y repite el proceso.
- **¿Cuándo usarlo?** **Siempre** que necesites llenar, mostrar o buscar algo adentro de una matriz.

### 3. La propiedad `.length`
```java
for (int i = 0; i < almacen.length; i++) {
    for (int j = 0; j < almacen[i].length; j++) {
```
- **¿Qué es?** `.length` (longitud en inglés) es una forma rápida de preguntarle a la matriz "¿De qué tamaño eres?".
- `almacen.length` -> Te dice **cuántas filas** tiene la matriz (hacia abajo).
- `almacen[i].length` -> Te dice **cuántas columnas** tiene una fila específica (hacia un lado).
- **¿Cuándo usarlo?** Cuando no sepas de memoria el tamaño de tu matriz, o la estés recibiendo como un parámetro a otra función y no tengas las variables `filas` y `columnas` a la mano.

### 4. La magia de `.equalsIgnoreCase()` (¡Súper importante!)
```java
if (almacen[i][j].getNombre().equalsIgnoreCase(nombreBuscado))
```
- **¿Qué hace?** Compara dos textos (Strings) para ver si son exactamente iguales, **PERO no le importa si están en MAYÚSCULAS o minúsculas**.
- *Ejemplo:* Si el usuario guardó un producto que se llama `"ARROZ"`, y luego intenta buscar `"arroz"`, el método dirá: *"¡Son iguales!"*. Si usáramos solo `equals()`, diría que son diferentes y no lo encontraría.
- **¿Cuándo usarlo?** Cada vez que tengas que comparar texto ingresado por el teclado. El usuario final (o el profesor calificando) suele mezclar mayúsculas y minúsculas por error. Con esto, aseguras que tu búsqueda no falle por una simple letra mayúscula.

### 5. Retornar los resultados rápidos (`return`)
En la función de búsqueda:
```java
return "El producto se encuentra en la posición: Fila " + i + ", Columna " + j;
```
- **¿Qué hace?** ¡Es como levantar la mano en clase cuando tienes la respuesta! Al momento exacto en el que encuentra el producto, devuelve la ubicación y el método termina por completo ahí mismo. No sigue buscando inútilmente por los demás estantes del almacén.

---

