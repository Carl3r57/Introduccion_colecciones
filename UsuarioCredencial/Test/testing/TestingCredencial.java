package testing;

import com.model.Credencial;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Exceptions.SamePassException;
import Exceptions.WrongPasswordFormat;

public class TestingCredencial {
	private Credencial credencial;

    @BeforeEach
    void setUp() throws Exception {
        credencial = new Credencial("Clave123!", "Carlos", "Gomez");
    }

    @Test
    void testGeneracionUsername() {
        assertNotNull(credencial.getUsername(), "El nombre de usuario no debería ser nulo");
        assertTrue(credencial.getUsername().matches("[a-zA-Z0-9]+"), "El nombre de usuario debe ser alfanumérico");
    }

    @Test
    void testEsPassSegura() {
        assertTrue(credencial.esPassSegura("Segura123!"), "La contraseña debe cumplir los requisitos de seguridad");
        assertFalse(credencial.esPassSegura("1234567"), "Una contraseña sin letras ni caracteres especiales no es segura");
        assertFalse(credencial.esPassSegura("abcdefg!"), "Una contraseña sin números no es segura");
    }

    @Test
    void testComprobarPasswd() {
        assertTrue(credencial.comprobarPasswd("Clave123!"), "La verificación de contraseña debe ser correcta");
        assertFalse(credencial.comprobarPasswd("Incorrecta123"), "Una contraseña incorrecta no debe coincidir");
    }

    @Test
    void testModificarPasswd() {
        assertDoesNotThrow(() -> credencial.setPasswd("NuevaClave123!"), "Debe permitir cambiar a una contraseña válida");
        assertThrows(SamePassException.class, () -> credencial.setPasswd("NuevaClave123!"), "No debe permitir reutilizar la misma contraseña");
        assertThrows(WrongPasswordFormat.class, () -> credencial.setPasswd("123"), "No debe permitir una contraseña insegura");
    }
	
}
