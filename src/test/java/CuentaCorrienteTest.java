import org.EjercicioEntregable.Entity.CajaDeAhorro;
import org.EjercicioEntregable.Entity.CuentaCorriente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaCorrienteTest {
    private CuentaCorriente cuenta;
    @BeforeEach
    public void setup() {
        cuenta = new CuentaCorriente(1000);
        cuenta.setId(1);
    }
    @Test
    public void testAgregarSaldoCorrecto() {
        boolean resultado = cuenta.agregarSaldo(100);
        assertTrue(resultado);
        assertEquals(100, cuenta.getSaldo());
        assertEquals(1, cuenta.getOperaciones());
    }
    @Test
    public void testAgregarSaldoIncorrecto() {
        boolean resultado = cuenta.agregarSaldo(0);
        assertFalse(resultado);
        assertEquals(0, cuenta.getSaldo());
        assertEquals(0, cuenta.getOperaciones());
    }
    @Test
    public void testQuitarSaldoCorrecto() {
        cuenta.agregarSaldo(1000);
        boolean resultado = cuenta.quitarSaldo(500);
        assertTrue(resultado);
        assertEquals(500, cuenta.getSaldo());
        assertEquals(2, cuenta.getOperaciones());
    }
    @Test
    public void testQuitarSaldoCeroIncorrecto() {
        cuenta.agregarSaldo(1000);
        boolean resultado = cuenta.quitarSaldo(0);
        assertFalse(resultado);
        assertEquals(1000, cuenta.getSaldo());
        assertEquals(1, cuenta.getOperaciones());
    }
    @Test
    public void testQuitarSaldoGiroDescubiertoCorrecto() {
        cuenta.agregarSaldo(1000);
        boolean resultado = cuenta.quitarSaldo(1500);
        assertTrue(resultado);
        assertEquals(-500, cuenta.getSaldo());
        assertEquals(2, cuenta.getOperaciones());
    }
    @Test
    public void testQuitarSaldoGiroDescubiertoIncorrecto() {
        cuenta.agregarSaldo(1000);
        boolean resultado = cuenta.quitarSaldo(2500);
        assertFalse(resultado);
        assertEquals(1000, cuenta.getSaldo());
        assertEquals(1, cuenta.getOperaciones());
    }
}
