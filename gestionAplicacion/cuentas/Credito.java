package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;
import uiMain.OpcionDeMenu;

import java.io.Serializable;

public class Credito implements Serializable {
    private final int id;
    private final CuentaCredito cuenta;
    private final CuentaDebito cuentaDebito;
    private float monto, valorCuota;
    private int cuotas;
    private static int contador;
    private static final String[] menuDefectoDebito = new String[]{"PagarCuotaCredito", "PagoParcialCredito",
            "VerCreditos"};

    public Credito(Usuario titular, float monto, int cuotas, CuentaCredito cuentaCredito, CuentaDebito cuentaDebito) {
        id = contador++;
        cuenta = cuentaCredito;
        this.cuentaDebito = cuentaDebito;

        int intereses = 0;
        float valorCuota = monto / cuotas;

        for (int i = 0; ++i <= cuotas;)
            intereses += (cuenta.getInteres() / 100) * (monto - (i - 1) * valorCuota);

        this.monto = monto + intereses;
        this.valorCuota = this.monto / cuotas;

        cuenta.disminuirCupo(monto);
        cuenta.aumentarDeuda(monto);

        if(!OpcionDeMenu.tieneCredito) titular.getMenu().anadirOpciones(menuDefectoDebito);
    }

    void pagarParcial(float pago) {
        monto -= pago;
        cuenta.aumentarCupo(pago);
        cuenta.disminuirDeuda(pago);
        if (monto <= 0) cuenta.removerCredito(id);
    }

    public String toString() { return id + "," + monto + "," + cuotas + "," + valorCuota; }

    public int getId() { return id; }

    public static int getContador() { return contador; }

    public static void setContador(int contador) { Credito.contador = contador; }

}
	
	

