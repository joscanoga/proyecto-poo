package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;
import uiMain.OpcionDeMenu;

public class Credito {
    private final int id, cuotasIniciales;
    private final CuentaCredito cuenta;
    private final float montoConIntereses, montoInicial;
    private float montoPendiente, valorCuota;
    private int cuotas;
    private static int contador;
    private static final String[] menuDefectoDebito = new String[]{"PagarCuotaCredito", "PagoParcialCredito",
            "VerCreditos"};

    public Credito(Usuario titular, float montoInicial, int cuotas, CuentaCredito cuentaCredito) {
        id = contador++;
        cuenta = cuentaCredito;
        this.montoInicial = montoInicial;
        cuotasIniciales = this.cuotas = cuotas;

        int intereses = 0;
        float valorCuota = montoInicial / cuotas;

        for (int i = 0; ++i <= cuotas;)
            intereses += (cuenta.getInteres() / 100) * (montoInicial - (i - 1) * valorCuota);

        montoConIntereses = montoPendiente = montoInicial + intereses;
        this.valorCuota = montoPendiente / cuotas;
        cuenta.disminuirCupo(montoInicial);

        if(!OpcionDeMenu.tieneCredito) titular.getMenu().anadirOpciones(menuDefectoDebito);
    }

    void pagarParcial(float pago) {
        montoPendiente -= pago;
        cuenta.aumentarCupo(pago);
        cuenta.disminuirDeuda(pago);
        if (montoPendiente <= 0) cuenta.removerCredito(id);
    }

    public String toString() {
        return id + "," + montoInicial + "," + cuotasIniciales + "," + valorCuota + "," + montoPendiente + "," + cuotas;
    }

    public int getId() { return id; }

    public int getCuotasIniciales() { return cuotasIniciales; }

    public float getMontoInicial() { return montoInicial; }

    public float getMontoPendiente() { return montoPendiente; }

    public void setMontoPendiente(float montoPendiente) { this.montoPendiente = montoPendiente; }

    public float getValorCuota() { return valorCuota; }

    public void setValorCuota(float valorCuota) { this.valorCuota = valorCuota; }

    public int getCuotas() { return cuotas; }

    public void setCuotas(int cuotas) { this.cuotas = cuotas; }

    public static int getContador() { return contador; }

    public static void setContador(int contador) { Credito.contador = contador; }

}
	
	

