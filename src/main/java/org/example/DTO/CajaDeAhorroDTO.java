package org.example.DTO;

public class CajaDeAhorroDTO  {
    private double saldo;
    private int operaciones;

    private CajaDeAhorroDTO(Builder builder) {
        this.saldo = builder.saldo;
        this.operaciones = builder.operaciones;
    }
    public double getSaldo() {
        return saldo;
    }
    public int getOperaciones() {
        return operaciones;
    }
    public static class Builder {
        private double saldo;
        private int operaciones;

        public Builder setSaldo(double saldo) {
            this.saldo = saldo;
            return this;
        }
        public Builder setOperaciones(int operaciones) {
            this.operaciones = operaciones;
            return this;
        }
        public CajaDeAhorroDTO build() {
            return new CajaDeAhorroDTO(this);
        }
    }

}
