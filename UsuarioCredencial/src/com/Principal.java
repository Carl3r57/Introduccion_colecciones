package com;

import com.model.Usuario;

public class Principal {
    public static void main(String[] args) throws Exception {
        Usuario carlos = new Usuario("Carlos", "Pizzino", "carlos@email.com", "123456Pk!");
        System.out.println(carlos);
    }
}
