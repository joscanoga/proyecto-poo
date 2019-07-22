package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;
import uiMain.OpcionDeMenu;

import java.io.Serializable;

public class Cheque implements Serializable {
    private final int id;
    private final float monto;
    private final Usuario librador;
    private final String beneficiario;
    private boolean cobrado;
    private static int contador;

    private static final String[] menuDefectoCheques = new String[]{"VerCheques", "CobrarCheque"};

    public Cheque(float monto, Usuario librador, String beneficiario) {
        id = ++contador;
        this.monto = monto;
        this.librador = librador;
        this.beneficiario = beneficiario;
        if (!OpcionDeMenu.tieneCheque) librador.getMenu().anadirOpciones(menuDefectoCheques);
    }

    public String toString() { return id + "," + monto + "," + beneficiario + "," + (cobrado ? "Sí" : "No"); }

    public void cobrar() { cobrado = true; }

    public int getId() { return id; }

    public float getMonto() { return monto; }

    public boolean getCobrado() { return cobrado; }

    public static int getContador() { return contador; }

    public static void setContador(int contador) { Cheque.contador = contador; }

}
