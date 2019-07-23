package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Iterator;

public class CuentaCredito extends Cuenta {
    private float deuda;
    private float cupo = 1000000;
    private static float interes = (float)2.5;
    private ArrayList<Credito> creditos = new ArrayList<>();

    private static final String[] menuDefectoCuentasCredito = new String[]{"AnadirCredito"};

    public CuentaCredito(Usuario titular) {
        super(titular);
        titular.getMenu().anadirOpciones(menuDefectoCuentasCredito);
    }

    public String toString() {
        return id + ",Cuenta crédito," + deuda + "," + cupo + "," + interes + "," + creditos.size();
    }

    public void anadirCredito(Credito credito) { creditos.add(credito); }

    public void removerCredito(int id) {
        int contador = 0;
        for (Credito credito : creditos) {
            if (credito.getId() == id) {
                creditos.remove(contador);
                return;
            }
            contador++;
        }
    }

    public float getDeuda() { return deuda; }

    public float getCupo() { return cupo; }

    public float getInteres() { return interes; }

    public ArrayList<Credito> getCreditos() { return creditos; }

    public void aumentarCupo(float valor) { cupo += valor; }

    public void disminuirCupo(float valor) { cupo -= valor; }

    public void aumentarDeuda(float valor) { deuda += valor; }

    public void disminuirDeuda(float valor) { deuda -= valor; }


}