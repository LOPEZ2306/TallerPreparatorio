# Ejercicio Propuesto 3: Comparación de Sucursales

## Problema
Se tienen dos matrices que representan las ventas mensuales de dos sucursales. Cada celda contiene un objeto `Venta` con atributos `producto` y `cantidadVendida`.
El usuario debe ingresar:
- Número de filas
- Número de columnas 
Luego se deben llenar ambas matrices con datos. 

Escribe un algoritmo que compare ambas matrices, determine en qué posiciones la sucursal 1 vendió más que la sucursal 2, y muestre la posición (fila, columna) y el nombre del producto donde ocurrió esto.

## Solución Implementada

Para resolver este ejercicio se implementó lo siguiente:

### 1. Dimensiones Independientes por Sucursal
Para evitar que el programa se rompa o que haya errores si el usuario decide que la Sucursal 1 tiene distinto tamaño que la Sucursal 2 (por ejemplo, una matriz de `2x2` vs otra de `3x3`), en `Main.java` se pide a los usuarios las filas y columnas de cada sucursal de manera obligatoria y separada.

### 2. Comparación Lógica de Matrices Desiguales
La lógica principal del algoritmo radica en el método `compararVentas(Venta[][] sucursal1, Venta[][] sucursal2)`. Este funciona de la siguiente manera:
- Primero se evalúa si alguna de las dos matrices tiene dimensiones diferentes. De ser así, se informa que **solo se comparará la parte en la que se cruzan o intersectan las dos matrices**.
- Utilizando `Math.min(longitud1, longitud2)` logramos averiguar cuántas filas y cuántas columnas en común tienen las dos sucursales. Esto sirve para ponerles tope a los ciclos `for` (que lo recorren) de forma que jamás intente "buscar" datos en una posición que no existe y evitar que salte un error de Java de tipo _IndexOutOfBoundsException_.
- Al estar en una celda en común (intersección), extrae el objeto `Venta` simultáneamente de ambas matrices.
- Solo si en la misma celda de ambas sucursales se tiene información cargada (`!= null`), valida si la venta de la sucursal 1 supera a la sucursal 2 `(v1.getCantidadVendida() > v2.getCantidadVendida())`. Si esto es cierto, imprime por consola los detalles.
