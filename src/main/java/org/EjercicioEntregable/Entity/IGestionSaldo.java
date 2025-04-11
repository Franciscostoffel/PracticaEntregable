package org.EjercicioEntregable.Entity;

public interface IGestionSaldo {
    boolean agregarSaldo(double monto);
    boolean quitarSaldo(double monto);
    double getSaldo();
    double getOperaciones();
}
