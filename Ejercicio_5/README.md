# Guía de Estudio: Ejercicio 5 - Fusión de Tiendas

¡Hola de nuevo! En este ejercicio subimos un poco el nivel: ahora no solo buscamos, sino que tenemos **dos** almacenes (matrices) y queremos juntarlos en un solo inventario gigante.

---

## 🏗️ La Lógica Central (¿Cómo lo resolvimos?)

Imagínate que tú eres el gerente de dos tiendas y decides unirlas. Necesitas empacar todos los productos en una sola bodega gigante. 

1. **La Bodega Gigante (El Arreglo Unidimensional):** 
   En lugar de crear una matriz enorme de la cual no sabemos las dimensiones exactas, es más inteligente crear un arreglo normal de una sola fila (`Producto[] resultado`). Empacar todo en fila india es mucho más fácil.
   - *¿De qué tamaño hacemos la bodega?* Sumando el total de productos de ambas tiendas juntas (el peor de los casos, donde todos los productos son de diferente marca).

2. **Empacar la Tienda 1:**
   Recorremos toda la Tienda 1 y metemos los productos, uno detrás de otro, en nuestra bodega gigante (`resultado`).

3. **Revisar la Tienda 2 (Aquí está el truco):**
   Tomamos cada producto de la Tienda 2 en nuestras manos. Antes de meterlo a la bodega, **buscamos si ya existe alguien con el mismo nombre**.
   - **Si ya existe:** Simplemente sumamos el stock (`stock + stock`).
   - **Si no existe:** Lo metemos a la bodega en el siguiente espacio vacío.

---

## 🧠 Explicación de Conceptos Clave para el Parcial

### 1. Variables Contador (La variable `k`)
En `Metodos.java` verás una variable llamada `int k = 0`.
- **¿Para qué sirve?** El nombre que le pongas no importa (`k`, `contador`, `indice`), su función es llevar la cuenta de cuántos productos **únicos** hemos guardado en nuestra bodega gigante.
- Cada vez que guardamos un producto nuevo, hacemos `k++` (para avanzar al siguiente espacio vacío).

### 2. Romper un ciclo con `break;`
```java
if (resultado[m].getNombre().equalsIgnoreCase(pActualT2.getNombre())) {
    // sumar stock...
    encontrado = true;
    break; // <--- ¡AQUÍ!
}
```
- **¿Qué es?** El `break;` funciona como un freno de emergencia para el ciclo `for`. 
- **¿Por qué se usa?** Si estoy recorriendo mi bodega y en la posición 3 ya encontré que el *"Arroz"* existe, y ya le sumé la cantidad, **no tiene sentido seguir buscando en las posiciones 4, 5, 6...**. Uso `break;` para salirme inmediatamente de ese ciclo y ahorrar tiempo. Esto demuestra a tu profesor que piensas en el rendimiento del código.

### 3. Las banderas booleanas (La variable `encontrado`)
- Declaramos un `boolean encontrado = false;` antes de empezar a buscar.
- Si hallamos el producto y sumamos los valores, cambiamos la bandera a `true`.
- Al finalizar la búsqueda, revisamos la bandera: `if (!encontrado)` (esto es igual a decir "Si 'encontrado' sigue siendo falso"). 
- Si sigue falso, significa que recorrimos toooooda la bodega y el producto no estaba ahí. En ese caso, lo agregamos como nuevo.

### 4. Compactar la bodega al final (Ajustar el tamaño)
Nuestra "bodega gigante" se creó pensando en el peor de los casos (por ejemplo, tamaño 20). Pero tal vez solo guardamos 10 productos únicos y sobraron 10 espacios vacíos (valores `null`). 
Para arreglar esto, creamos un nuevo arreglo final, chiquito y perfecto, copiando únicamente desde la posición 0 hasta donde llegó nuestro contador `k`.

¡Repasa esta lógica de "buscar antes de meter", porque sirve para solucionar cientos de ejercicios diferentes en Java!
