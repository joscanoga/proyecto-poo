package gestionAplicacion.cuentas;

import java.io.Serializable;

public class Debito implements Serializable {
    final private int id;
    final private CuentaDebito cuentaAsociada;
    final private float monto;
    private static int numeroDebitos;


    public int getId() {return id;}

    public CuentaDebito getCuentaAsociada() {return cuentaAsociada;}

    public float getMonto() {return monto;}

    public int getNumeroDebitos() {return numeroDebitos;}

    public void debitar() {cuentaAsociada.retirar(monto);}

    Debito(CuentaDebito ca, float m) {
        numeroDebitos++;
        id = numeroDebitos;
        cuentaAsociada = ca;
        monto = m;
    }

}
