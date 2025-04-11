package org.example.DTO;

public class CuentaCorrienteDTO {
    private double saldo;
    private int operaciones;
    private double giroDescubierto;

    private CuentaCorrienteDTO(Builder builder) {
        this.saldo = builder.saldo;
        this.operaciones = builder.operaciones;
        this.giroDescubierto = builder.giroDescubierto;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getOperaciones() {
        return operaciones;
    }

    public double getGiroDescubierto() {
        return giroDescubierto;
    }

    public static class Builder {
        private double saldo;
        private int operaciones;
        private double giroDescubierto;

        public Builder setSaldo(double saldo) {
            this.saldo = saldo;
            return this;
        }

        public Builder setOperaciones(int operaciones) {
            this.operaciones = operaciones;
            return this;
        }

        public Builder setGiroDescubierto(double giroDescubierto) {
            this.giroDescubierto = giroDescubierto;
            return this;
        }
        public CuentaCorrienteDTO build () {
                return new CuentaCorrienteDTO(this);
        }
    }
}

