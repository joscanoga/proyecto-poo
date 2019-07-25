package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;
import uiMain.OpcionDeMenu;

import java.io.Serializable;

public class Credito implements Serializable {
    private final int id;
    private final CuentaCredito cuenta;
    private final CuentaDebito cuentaDebito;
    private float monto, valorCuota, valorCuotaSinIntereses, montoSinIntereses;
    ;
    private int cuotas;
    private static int contador;
    private static final String[] menuDefectoDebito = new String[]{"PagarCuotaCredito", "PagoParcialCredito",
            "VerCreditos"};

    public Credito(Usuario titular, float monto, int cuotas, CuentaCredito cuentaCredito, CuentaDebito cuentaDebito) {
        id = ++contador;
        cuenta = cuentaCredito;
        this.cuentaDebito = cuentaDebito;
        this.cuotas = cuotas;
        valorCuotaSinIntereses = monto / cuotas;
        montoSinIntereses = monto;

        int intereses = 0;

        for (int i = 0; ++i <= cuotas;)
            intereses += (cuenta.getInteres() / 100) * (monto - (i - 1) * valorCuotaSinIntereses);

        this.monto = monto + intereses;
        this.valorCuota = this.monto / cuotas;

        cuenta.disminuirCupo(monto);
        cuenta.aumentarDeuda(this.monto);

        if(!OpcionDeMenu.tieneCredito) titular.getMenu().anadirOpciones(menuDefectoDebito);

        cuentaDebito.consignar(monto);
    }

    public void pagarCuota() {
        cuentaDebito.retirar(valorCuota);

        monto -= valorCuota;
        cuotas--;

        cuenta.aumentarCupo(valorCuotaSinIntereses);
        cuenta.disminuirDeuda(valorCuota);

        if (cuotas == 0) monto = 0;
    }

    public void pagarParcial(float pago) {
        cuentaDebito.retirar(pago);

        float pagoSinIntereses = pago / valorCuota * valorCuotaSinIntereses;
        montoSinIntereses -= pagoSinIntereses;

        if (monto == pago) cuotas = 0;

        monto -= pago;
        cuenta.aumentarCupo(pagoSinIntereses);
        cuenta.disminuirDeuda(pago);

        valorCuota = monto / cuotas;
        valorCuotaSinIntereses = montoSinIntereses / cuotas;
    }

    public String toString() { return id + "," + monto + "," + cuotas + "," + valorCuota; }

    public int getId() { return id; }

    public float getMonto() { return monto; }

    public int getCuotas() { return cuotas; }

    public float getValorCuota() { return valorCuota; }

    public static int getContador() { return contador; }

    public static String[] getMenuDefectoDebito() { return menuDefectoDebito; }

    public static void setContador(int contador) { Credito.contador = contador; }

}
	
	

