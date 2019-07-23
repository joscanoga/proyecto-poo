package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Iterator;

public class CuentaCredito extends Cuenta {
    private float deuda;
    private float cupo = 1000000;
    private static float interes = (float)2.5;
    private ArrayList<Credito> creditos = new ArrayList<>();

    public CuentaCredito(Usuario titular) {
        super(titular);
    }

    public float getCupo() { return cupo; }

    public float getdeuda() { return deuda; }

    public float getIntereses() { return interes; }

    public ArrayList<Credito> getCreditos() { return creditos; }

    public void avanceCuentaDebito(Float valor, CuentaDebito ca) {
        creditos.add(new Credito(this, valor, 18));
        ca.consignar(valor);

    }

    public void anadirCredito(Credito cr) {
        creditos.add(cr);
    }

    public void removerCredito(Credito cr) {
        Iterator<Credito> it = creditos.iterator();
        while (it.hasNext()) {
            Credito e = it.next();
            if (e.getId() == id) {
                creditos.remove(creditos.indexOf(e));
                break;
            }
        }

    }

    public void aumentarCupo(float valor) {cupo += valor;}

    public void aumentarDeuda(float valor) {deuda += valor;}

    public void mermarCupo(float valor) {cupo -= valor;}

    public void mermarDeuda(float valor) {deuda -= valor;}

    public String toString() {
        return id + ",Cuenta crédito," + deuda + "," + cupo + "," + interes + "," + creditos.size();
    }

    public String mostrarInfo() {
        String screditos = "";
        Iterator<Credito> it = creditos.iterator();
        while (it.hasNext()) {
            screditos += it.toString() + "\n";
        }
        String x = "id cuenta credito" + id + "\n cupo:" + cupo + "\n deuda:" + deuda + "\n tasa de interes" + interes + "\n creditos \n" + screditos;
        return (x);
    }


}