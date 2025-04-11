package org.EjercicioEntregable;
import org.EjercicioEntregable.Entity.CajaDeAhorro;
import org.EjercicioEntregable.Entity.Cuenta;
import org.EjercicioEntregable.Entity.CuentaCorriente;
import org.EjercicioEntregable.Service.LogicaCuenta;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        LogicaCuenta logica = LogicaCuenta.getInstancia();
        Random random = new Random();

        for (int i = 1; i < 10; i++) {
            Cuenta cuenta;
            if (i % 2 == 0) {
                CajaDeAhorro ahorro = new CajaDeAhorro();
                ahorro.setId(i);
                cuenta = ahorro;
            } else {
                CuentaCorriente corriente = new CuentaCorriente(1000); // giro permitido
                corriente.setId(i);
                cuenta = corriente;
            }
            logica.agregarCuenta(cuenta);
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> {
                int id = random.nextInt(10); // cuenta aleatoria
                double monto = 50 + random.nextDouble() * 200; // entre 50 y 250
                boolean operacion = random.nextBoolean(); // true = agregar, false = quitar

                if (operacion) {
                    logica.agregarSaldo(id, monto);
                } else {
                    logica.quitarSaldo(id, monto);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("==== ESTADO FINAL DE CUENTAS ====");
        for (Cuenta cuenta : logica.getCuentas()) {
            System.out.printf("Cuenta ID: %d | Tipo: %s | Saldo: $%.2f | Operaciones: %d%n",
                    cuenta.getId(),
                    cuenta instanceof CajaDeAhorro ? "CajaDeAhorro" : "CuentaCorriente",
                    cuenta.getSaldo(),
                    (int) cuenta.getOperaciones());
        }
    }
}
