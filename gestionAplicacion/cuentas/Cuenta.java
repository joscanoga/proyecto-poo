package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Cliente;
import gestionAplicacion.usuarios.Usuario;


import java.io.Serializable;

public abstract class Cuenta implements Serializable {
    protected final int id;
    protected Cliente titular;
    protected static int contador;

    public Cuenta(Cliente titular) {
        id = ++contador;
        this.titular = titular;
    }

    // Temporal
    public String toString() {
        String tipo = this instanceof CuentaDebito ? "CDe" : (this instanceof CDT ? "CDT" : "CCre");
        return id + "," + tipo;
    }

    public int getId() { return id; }

    public static int getContador() { return contador; }

    public Usuario getTitular() { return titular; }

    public static void setContador(int cantCuentas) { Cuenta.contador = cantCuentas; }
}