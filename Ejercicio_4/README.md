# Guía de Estudio: Ejercicio 4 - Ordenar Filas de Objetos

En este ejercicio aprendemos algo súper poderoso: cómo ordenar un arreglo completo de objetos sin tener que escribir el pesado y lento algoritmo "Burbuja" usando los métodos que Java ya nos regala.

---

## 🏗️ La Lógica Central (¿Cómo funciona Arrays.sort con Objetos?)

Si tuviéramos un arreglo normal de números (`int[] numeros = {5, 2, 8}`), ordenar sería tan fácil como escribir `Arrays.sort(numeros)`. 

Sin embargo, aquí no tenemos números sueltos. Tenemos un arreglo bidimensional (nuestro Teatro) lleno de **Objetos** `Asiento`. Cada `Asiento` tiene varios atributos adentro (número, fila, precio). 

**El problema:** Si le decimos a Java `Arrays.sort(filaDelTeatro)`, Java va a entrar en pánico y dirá: *"¡Oye! Esto es un objeto completo. ¿Por cuál de sus atributos quieres que lo ordene? ¿Por el número de asiento? ¿Por el precio?"*

**La solución:** Usar un `Comparator`.

---

## 🧠 Explicación Técnica y Práctica

### 1. Descomponer la matriz
Primero, sabemos que una matriz `teatro[][]` está compuesta por arreglos unidimensionales que representan cada fila.
```java
// Recorremos el teatro completo, fila por fila
for (int i = 0; i < teatro.length; i++) {
```

### 2. Invocar `Arrays.sort()` sobre una fila específica
En lugar de pasar la matriz entera, le pasamos solo la fila actual (`teatro[i]`) al método sort.
```java
Arrays.sort(teatro[i], new Comparator<Asiento>() { ... });
```
Esto equivale a decirle: *"Oye Java, ordéname todos los elementos de ESTA fila en específico"*.

### 3. El `Comparator` (Las reglas de comparación)
El bloque de código que dice `new Comparator<Asiento>() { ... }` es donde le damos las instrucciones a Java. Aquí es donde respondemos a su pregunta de *"¿Por qué atributo los ordeno?"*.

Adentro, se debe sobreescribir `@Override` un método llamado `compare`. Este método siempre recibe dos objetos a la vez (por ejemplo, el Asiento de la izquierda y el Asiento de la derecha) para enfrentarlos:
```java
public int compare(Asiento a1, Asiento a2) {
    return Double.compare(a1.getPrecio(), a2.getPrecio());
}
```

**¿Cómo funciona `Double.compare()`?**
Este es el "juez" que decide quién gana. Compara el `precio` del Asiento 1 contra el `precio` del Asiento 2 y siempre devuelve uno de tres números:
- Devuelve **-1** si el primer precio es *menor* que el segundo.
- Devuelve **0** si los precios son *iguales*.
- Devuelve **1** si el primer precio es *mayor* que el segundo.

Gracias a esos números (1, 0 o -1), ¡el método interno de Java ya sabe por detrás a quién poner primero en la fila! Y como estamos usando `Asiento a1` y `Asiento a2`, **el objeto completo se mueve**, llevándose consigo su número y su fila correspondiente, no solo el precio.

---

### Resumen para el parcial:
Si un profesor pregunta: *"¿Por qué tuviste que usar un Comparator para ordenar esta matriz de Asientos?"*

**Respuesta ideal:** *"Porque `Arrays.sort` no sabe ordenar objetos personalizados por defecto. Necesita un `Comparator` que le indique explícitamente qué campo específico del objeto (en este caso el `precio`) debe utilizar como criterio para decidir si un elemento es mayor o menor que otro."*

---

## 📝 Bonus: Operaciones Principales con Listas (ArrayList)

Es muy probable que en tu parcial también te pregunten por el manejo de colecciones dinámicas como los `ArrayList`. Aquí tienes una tabla resumen rápida:

| Acción | Método | Ejemplo de Uso |
| :--- | :--- | :--- |
| **Agregar** | `.add(elemento)` | `lista.add("Hola");` |
| **Acceder** | `.get(índice)` | `String texto = lista.get(0);` |
| **Modificar** | `.set(índice, nuevo)` | `lista.set(0, "Mundo");` |
| **Eliminar** | `.remove(índice)` | `lista.remove(0);` |
| **Tamaño** | `.size()` | `int total = lista.size();` |

> 💡 **Tip para el examen:** Recuerda que para pedir el tamaño de un Arreglo normal (`[][]`) se usa `.length` (sin paréntesis), pero para una Lista se usa el método `.size()` (con paréntesis).
