package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

import java.io.Serializable;

public abstract class Cuenta implements Serializable {
    protected final int id;
    protected Usuario titular;
    protected static int numeroCuentas;

    public Cuenta(Usuario titular) {
        id = numeroCuentas++;
        this.titular = titular;
    }

    // Temporal
    public String toString() { return this instanceof CuentaDebito ? "CDe" : (this instanceof CDT ? "CDT" : "CCre"); }

    public void imprimir() {
        String tipo = this instanceof CuentaDebito ? "CDe" : (this instanceof CDT ? "CDT" : "CCre");
        System.out.format("%-20s%-20s%n", id, tipo);
    }

    public int getId() { return id; }

    public int getNumeroCuentas() { return numeroCuentas; }

    public Usuario getTitular() { return titular; }
}