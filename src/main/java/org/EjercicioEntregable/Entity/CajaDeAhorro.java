package org.EjercicioEntregable.Entity;

public class CajaDeAhorro extends  Cuenta{
        @Override
        public synchronized boolean agregarSaldo(double monto) {
            if (monto > 0) {
                saldo += monto;
                operaciones++;
                return true;
            }
            return false;
        }
        @Override
        public synchronized boolean quitarSaldo(double monto) {
            if (monto > 0 && monto <= saldo) {
                saldo -= monto;
                operaciones++;
                return true;
            }
            return false;
        }
    }

