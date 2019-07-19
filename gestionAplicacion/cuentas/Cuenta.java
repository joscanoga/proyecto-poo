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
    public String toString() {
        if (this instanceof CuentaDebito) return "CuentaDebito";
        else if (this instanceof CDT) return "CDT";
        else return "CuentaCreadito";
    }

    public int getId() { return id; }

    public int getNumeroCuentas() { return numeroCuentas; }

    public Usuario getTitular() { return titular; }
}