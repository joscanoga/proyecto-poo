package gestionAplicacion.cuentas;

import java.io.Serializable;

public class Debito implements Serializable {
    private final int id;
    private final CuentaDebito cuentaAsociada;
    private final float monto;
    private static int contador;

    Debito(CuentaDebito cuenta, float monto) {
        id = ++contador;
        cuentaAsociada = cuenta;
        this.monto = monto;
    }

    public int getId() { return id; }

    public CuentaDebito getCuentaAsociada() { return cuentaAsociada; }

    public float getMonto() { return monto; }

    public static int getNumeroDebitos() { return contador; }

    public void debitar() { cuentaAsociada.retirar(monto); }

}
