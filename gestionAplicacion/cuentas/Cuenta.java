package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

import java.io.Serializable;

public abstract class Cuenta implements Serializable {
    protected final int id;
    protected Usuario titular;
    protected static int contador;

    public Cuenta(Usuario titular) {
        id = ++contador;
        this.titular = titular;
    }

    // Temporal
    public String toString() {
        String tipo = this instanceof CuentaDebito ? "CDe" : (this instanceof CDT ? "CDT" : "CCre");
        return id + "," + tipo;
    }

    public int getId() { return id; }

    public static int getCantCuentas() { return contador; }

    public Usuario getTitular() { return titular; }

    public static void setCantCuentas(int cantCuentas) { Cuenta.contador = cantCuentas; }
}