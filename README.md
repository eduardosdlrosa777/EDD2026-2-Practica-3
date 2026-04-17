Eduardo Sanchez de la Rosa 426008938 eduardosdlrosa@ciencias.unam.mx

# Proyecto: Implementación y Aplicación de Pilas (TDA Stack)

Este proyecto contiene una implementación completa del Tipo de Dato Abstracto **Pila** (Stack) y diversas aplicaciones prácticas que demuestran su utilidad en la resolución de problemas algorítmicos.

## Estructura del Proyecto

### 1. Núcleo (Estructura de Datos)
* **`TDAStack.java`**: Interfaz genérica que define las operaciones fundamentales de una pila: `push`, `pop`, `top`, `isEmpty`, `clear` y `show`.
* **`ListStack.java`**: Implementación de la interfaz `TDAStack` utilizando una **Lista Enlazada Simple**. Esta implementación permite que la pila crezca de forma dinámica.

### 2. Aplicaciones y Pruebas
* **`Validador.java`**: Utiliza una pila para verificar si un documento HTML tiene sus etiquetas correctamente balanceadas. Es un ejemplo clásico de cómo las pilas gestionan estructuras anidadas.
* **`Asteroides.java`**: Un programa que simula la colisión de asteroides representados por enteros (el signo indica la dirección). Utiliza la pila para determinar qué asteroides sobreviven tras los impactos.
* **`Test.java`**: Clase de prueba básica para verificar el correcto funcionamiento de los métodos `push`, `pop` y `show` en la clase `ListStack`.