package ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ejercicio2 {
	public static void main(String[] args) {
        List<Integer> numeros = generarNumerosAleatorios();
        System.out.println("Números generados: " + numeros);
        System.out.println("Orden ascendente: " + ordenarAscendente(numeros));
        System.out.println("Orden descendente: " + ordenarDescendente(numeros));
    }

    public static List<Integer> generarNumerosAleatorios() {
        Set<Integer> numerosSet = new HashSet<>();
        Random random = new Random();
        
        while (numerosSet.size() < 30) {
            numerosSet.add(random.nextInt(100) + 1);
        }
        
        List<Integer> numerosList = new ArrayList<>(numerosSet);
        Collections.sort(numerosList);
        return numerosList;
    }

    public static List<Integer> ordenarAscendente(List<Integer> numeros) {
        List<Integer> ordenados = new ArrayList<>(numeros);
        Collections.sort(ordenados);
        return ordenados;
    }

    public static List<Integer> ordenarDescendente(List<Integer> numeros) {
        List<Integer> ordenados = new ArrayList<>(numeros);
        ordenados.sort(Collections.reverseOrder());
        return ordenados;
    }
}

