package testing;

import com.model.Usuario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestingUsuario {

    private Usuario usuario;

    @BeforeEach
    void setUp() throws Exception {
        usuario = new Usuario("Juan", "Pérez", "juan.perez@email.com", "Password123");
    }

    @Test
    void testEsCuentaBloqueada() {
        assertFalse(usuario.esCuentaBloqueada(), "La cuenta debería empezar desbloqueada");
    }


    @Test
    void testHacerLoginIncorrecto() {
        usuario.hacerLogin("Juan Pérez", "WrongPass");
        usuario.hacerLogin("Juan Pérez", "WrongPass");
        usuario.hacerLogin("Juan Pérez", "WrongPass");
        assertTrue(usuario.esCuentaBloqueada(), "Después de 3 intentos fallidos, la cuenta debería estar bloqueada");
    }


}
