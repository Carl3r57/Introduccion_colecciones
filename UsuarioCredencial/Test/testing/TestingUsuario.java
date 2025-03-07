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
    void testHacerLoginCorrecto() {
        assertTrue(usuario.hacerLogin("Juan Pérez", "Password123"), "El login debería ser exitoso");
    }

    @Test
    void testHacerLoginIncorrecto() {
        usuario.hacerLogin("Juan Pérez", "WrongPass");
        usuario.hacerLogin("Juan Pérez", "WrongPass");
        usuario.hacerLogin("Juan Pérez", "WrongPass");
        assertTrue(usuario.esCuentaBloqueada(), "Después de 3 intentos fallidos, la cuenta debería estar bloqueada");
    }

    @Test
    void testModificarPasswd() {
        assertTrue(usuario.modificarPasswd("Password123", "NuevaClave123", "NuevaClave123"),
                "El cambio de contraseña debería ser exitoso");
        assertFalse(usuario.modificarPasswd("WrongOldPass", "NuevaClave123", "NuevaClave123"),
                "No debería permitir cambiar la contraseña con una incorrecta");
    }
}
