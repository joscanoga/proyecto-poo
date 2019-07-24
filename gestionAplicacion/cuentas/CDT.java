package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CDT extends Cuenta {
    private int meses;
    private float monto;
    private final float tasa = (float)5;
    private final CuentaDebito cuenta;
    private static final String[] menuDefectoCDT = new String[]{"TranscurrirMesesEnCDT"};

    public CDT(Usuario titular, CuentaDebito cuenta, float monto, int meses) {
        super(titular);
        this.meses = meses;
        this.monto = monto;
        this.cuenta = cuenta;
        if (!OpcionDeMenu.tieneCDT) titular.getMenu().anadirOpciones(menuDefectoCDT);
    }

    public void transcurirMeses(int meses) {
        this.meses -= meses;
        monto *= Math.pow(1 + tasa / 100, meses);

        if (this.meses == 0) {
            cuenta.consignar(monto);
            int contador = 0;
            for (Cuenta cuenta : Main.usuario.getCuentas()) {
                if (cuenta.getId() == id) {
                    Main.usuario.getCuentas().remove(contador);
                    break;
                }
                contador++;
            }
        }
    }

    public int getMeses() { return meses; }

    public float getMonto() { return monto; }

    public static String[] getMenuDefectoCDT() { return menuDefectoCDT; }

    public String toString() {
        return id + ",CDT," + monto + "," + tasa + "%," + meses;
    }

}
