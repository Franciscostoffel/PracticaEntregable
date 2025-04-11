package org.example.Entity;

public abstract class Cuenta implements IGestionSaldo{
    public int Id;
    protected double saldo;
    protected int operaciones;
    public Cuenta() {
        this.saldo = 0;
        this.operaciones = 0;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
    @Override
    public synchronized double getSaldo() {
        return saldo;
    }
    @Override
    public synchronized double getOperaciones() {
        return operaciones;
    }
}

