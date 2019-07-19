package gestionAplicacion.cuentas;

import java.io.Serializable;

public class Cheque implements Serializable {
    final private int id;
    final private CuentaDebito librador;
    final private float monto;
    final private String beneficiario;
    private static int numeroCheques;
    private boolean cobrado;

    Cheque(CuentaDebito ca, float m, String ben) {
        monto = m;
        librador = ca;
        numeroCheques++;
        id = numeroCheques;
        cobrado = false;
        beneficiario = ben;
    }

    public int getId() {return id;}

    public float getMonto() {return monto;}

    public CuentaDebito getLibrador() {return librador;}

    public String getBeneficiario() {return beneficiario;}

    public int getNumeroCheques() {return numeroCheques;}

    public void librar() {
        if (!cobrado) {
            librador.retirar(monto);
            cobrado = true;
        } else {
            System.out.println("ya fue cobrado");
        }
    }

    public boolean getCobrado() {return cobrado;}
}
