import org.EjercicioEntregable.Entity.CajaDeAhorro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CajaDeAhorroTest {
    private CajaDeAhorro caja;
    @BeforeEach
    public void setup() {
        caja = new CajaDeAhorro();
        caja.setId(1);
    }
    @Test
    public void testAgregarSaldoCorrecto() {
        boolean resultado = caja.agregarSaldo(100);
        assertTrue(resultado);
        assertEquals(100, caja.getSaldo());
        assertEquals(1, caja.getOperaciones());
    }
    @Test
    public void testAgregarSaldoIncorrecto() {
        boolean resultado = caja.agregarSaldo(-1);
        assertFalse(resultado);
        assertEquals(0, caja.getSaldo());
        assertEquals(0, caja.getOperaciones());
    }
    @Test
    public void testQuitarSaldoCorrecto() {
        caja.agregarSaldo(100);
        boolean resultado = caja.quitarSaldo(50);
        assertTrue(resultado);
        assertEquals(50, caja.getSaldo());
        assertEquals(2, caja.getOperaciones());
    }
    @Test
    public void testQuitarSaldoIncoorrecto() {
        caja.agregarSaldo(100);
        boolean resultado = caja.quitarSaldo(-1);
        assertFalse(resultado);
        assertEquals(100, caja.getSaldo());
        assertEquals(1, caja.getOperaciones());
    }
    @Test
    public void testQuitarSaldoIncorrecto2() {
        caja.agregarSaldo(100);
        boolean resultado = caja.quitarSaldo(101);
        assertFalse(resultado);
        assertEquals(100, caja.getSaldo());
        assertEquals(1, caja.getOperaciones());
    }
}
