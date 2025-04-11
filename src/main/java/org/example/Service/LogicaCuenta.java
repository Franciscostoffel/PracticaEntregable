package org.example.Service;
import java.util.ArrayList;
import java.util.List;
import org.example.Entity.Cuenta;
public class LogicaCuenta {
    private static volatile LogicaCuenta instancia;
    private final List<Cuenta> cuentas;

    private LogicaCuenta() {
        this.cuentas = new ArrayList<>();
    }

    // Singleton con doble chequeo
    public static LogicaCuenta getInstancia() {
        if (instancia == null) {
            synchronized (LogicaCuenta.class) {
                if (instancia == null) {
                    instancia = new LogicaCuenta();
                }
            }
        }
        return instancia;
    }

    public synchronized void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    private Cuenta obtenerCuenta(int cuentaId) {
        return cuentas.stream()
                .filter(c -> c.getId() == cuentaId)
                .findFirst()
                .orElse(null);
    }

    public boolean agregarSaldo(int id, double monto) {
        Cuenta cuenta = obtenerCuenta(id);
        if (cuenta == null) {
            return false;
        }
        return cuenta.agregarSaldo(monto);
    }

    public boolean quitarSaldo(int id, double monto) {
        Cuenta cuenta = obtenerCuenta(id);
        if (cuenta == null) {
            return false;
        }
        return cuenta.quitarSaldo(monto);
    }

    public double consultarSaldo(int id) {
        Cuenta cuenta = obtenerCuenta(id);
        if (cuenta == null) {
            return 0;
        }
        return cuenta.getSaldo();
    }

    public Cuenta getCuenta(int cuentaId) {
        return cuentas.get(cuentaId);
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
}
