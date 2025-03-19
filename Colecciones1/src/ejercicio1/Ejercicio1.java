package ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ejercicio1 {

		public static void main(String[] args) {
			List<Integer> numeros = generarNumerosAleatorios();
			System.out.println(numeros);
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
}


