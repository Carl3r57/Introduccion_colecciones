package ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        ColeccionOrdenada coleccion = new ColeccionOrdenada();
        coleccion.agregarNumero(10);
        coleccion.agregarNumero(5);
        coleccion.agregarNumero(19);
        coleccion.agregarNumero(15);
        coleccion.agregarNumero(19);

        System.out.println(coleccion.obtenerNumeros());
    }


}


