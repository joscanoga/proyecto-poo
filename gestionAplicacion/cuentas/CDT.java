package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

public class CDT extends Cuenta {
    private int meses, mesesInicial;
    private float monto, montoInicial;
    private final float tasa = (float)0.5;
    private boolean activo;

    public CDT(Usuario titular, float monto, int meses) {
        super(titular);
        mesesInicial = this.meses = meses;
        montoInicial = this.monto = monto;
    }

    public int getPlazoMeses() { return meses; }

    public float getMonto() { return monto; }

    public float getTasa() { return tasa; }

    public boolean getActivo() { return activo; }

    public void renovar(int meses) { this.meses += meses; }

    public void transcurirMeses(int meses) {
        for (int i = 0; i < meses; i++) {
            if (this.meses > 0) {
                monto *= (1 + tasa);
                this.meses--;
            } else {
                System.out.println("los meses se han transcurido,requiere renovar");
                break;
            }
        }
    }

    public String toString() {
        return id + ",CDT," + montoInicial + "," + monto + "," + tasa + "," + mesesInicial + "," + meses;
    }

}
