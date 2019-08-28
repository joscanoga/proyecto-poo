package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Cliente;
import gestionAplicacion.usuarios.Usuario;
//import uiMain.Main;
//import uiMain.OpcionDeMenu;

public class CDT extends Cuenta {
    private int meses;
    private float monto;
    private final float tasa = (float)5;
    private final CuentaDebito cuenta;
    private boolean activo;
//    private static final String[] menuDefectoCDT = new String[]{"TranscurrirMesesEnCDT"};

    public CDT(Cliente titular, CuentaDebito cuenta, float monto, int meses) {
        super(titular);
        this.meses = meses;
        this.monto = monto;
        this.cuenta = cuenta;
        this.activo=true;
//        if (!OpcionDeMenu.tieneCDT) titular.getMenu().anadirOpciones(menuDefectoCDT);
    }

    public void transcurirMeses(int meses) {
        this.meses -= meses;
        monto *= Math.pow(1 + tasa / 100, meses);

        if (this.meses == 0) {
            cuenta.consignar(monto);
            this.titular.removerCuenta(id);
            }
        
    }
    public void renovar(int meses) {this.meses+=meses;}
    public int getMeses() { return meses; }
    public Float getTasa() {return tasa;}
    public float getMonto() { return monto; }
    public boolean getActivo() {return activo;}
//    public static String[] getMenuDefectoCDT() { return menuDefectoCDT; }

    public String toString() {
        return id + ",CDT," + monto + "," + tasa + "%," + meses;
    }

}
