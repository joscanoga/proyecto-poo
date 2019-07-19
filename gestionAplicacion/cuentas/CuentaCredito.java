package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

import java.util.ArrayList;

public class CuentaCredito extends Cuenta {
    private float deuda;
    private float cupo = 1000000;
    private static float interes = (float)2.5;

    public CuentaCredito(Usuario titular) {
        super(titular);
    }

    private ArrayList<Credito> creditos;

    public float getCupo() { return cupo; }

    public float getdeuda() { return deuda; }

    public float getIntereses() { return interes; }

    public ArrayList<Credito> getCreditos() { return creditos; }

}