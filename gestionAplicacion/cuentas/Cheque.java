package gestionAplicacion.cuentas;

//import uiMain.Main;
//import uiMain.OpcionDeMenu;

import java.io.Serializable;

import excepciones.ValorIncorrecto;

public class Cheque implements Serializable {
    private final int id;
    private final float monto;
    private final String beneficiario;
    private boolean cobrado;
    private static int contador;
    private CuentaDebito cuenta;

    private static final String[] menuDefectoCheque = new String[]{"VerCheques", "CobrarCheque"};

    public Cheque(float monto, String beneficiario,CuentaDebito cuenta) {
        id = ++contador;
        this.cuenta=cuenta;
        this.monto = monto;
        this.beneficiario = beneficiario;
       // if (!OpcionDeMenu.tieneCheque) Main.usuario.getMenu().anadirOpciones(menuDefectoCheque);
    }

    public String toString() { return id + "," + monto + "," + beneficiario + "," + (cobrado ? "Sí" : "No"); }

    public void cobrar() throws ValorIncorrecto { 
    	cuenta.retirar(monto);
    	cobrado = true; }

    public int getId() { return id; }

    public float getMonto() { return monto; }

    public boolean getCobrado() { return cobrado; }

    public static int getContador() { return contador; }

    public static void setContador(int contador) { Cheque.contador = contador; }
    public String getBeneficiario() {return beneficiario;}
    public CuentaDebito getCuenta() {return cuenta;}

}
