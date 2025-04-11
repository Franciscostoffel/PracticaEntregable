package org.example.Entity;

public class CuentaCorriente extends Cuenta{
    double giroDescubierto;
    public CuentaCorriente(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
    }
    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (monto > 0 && monto <= saldo ){
            saldo+=monto;
            operaciones++;
            return true;
        }
        return false;
    }
    @Override
    public boolean agregarSaldo(double monto) {
        if (monto > 0 && (saldo - monto) >= -giroDescubierto) {
            saldo -= monto;
            operaciones++;
            return true;
        }
        return false;
    }
}
