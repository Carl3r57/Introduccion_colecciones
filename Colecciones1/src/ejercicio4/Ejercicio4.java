package ejercicio4;

import ejercicio3.ColeccionOrdenada;  // Asegúrate de que esta importación sea correcta

public class Ejercicio4 {
    public static void main(String[] args) {
        // Lista de números
        ColeccionOrdenada<Integer> numeros = new ColeccionOrdenada<>();
        numeros.agregarElemento(10);
        numeros.agregarElemento(5);
        numeros.agregarElemento(20);
        numeros.agregarElemento(15);
        System.out.println("Números ordenados: " + numeros.obtenerElementos());

        // Lista de Strings
        ColeccionOrdenada<String> palabras = new ColeccionOrdenada<>();
        palabras.agregarElemento("Perro");
        palabras.agregarElemento("Gato");
        palabras.agregarElemento("Elefante");
        System.out.println("Palabras ordenadas: " + palabras.obtenerElementos());
    }
}