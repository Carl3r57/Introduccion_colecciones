package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class ColeccionOrdenada<T extends Comparable<T>> { // <-- Asegúrate de que sea PUBLIC
    public List<T> elementos;

    public ColeccionOrdenada() {
        this.elementos = new ArrayList<>();
    }

    public void agregarElemento(T elemento) {
        int posicion = 0;
        while (posicion < elementos.size() && elementos.get(posicion).compareTo(elemento) < 0) {
            posicion++;
        }
        elementos.add(posicion, elemento);
    }

    public List<T> obtenerElementos() {
        return new ArrayList<>(elementos);
    }
}
