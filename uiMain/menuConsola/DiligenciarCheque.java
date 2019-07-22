package uiMain.menuConsola;

import gestionAplicacion.cuentas.Cheque;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class DiligenciarCheque extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, monto = null;

        if (filtrarOpcionesCuentaDebito("crear un cheque") || filtrarSaldoNulo("crear un cheque")) return;

        while (true) {
            System.out.print(margen + "DILIGENCIAR CHEQUE\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (monto != null ? monto + "\n" : ""), "Monto del cheque");
            if (monto == null && !esNumerico(monto = entrada.next(), "float")) {
                textoError = "El monto del cheque debe ser un valor numérico, \"" + monto + "\" no lo es.";
                monto = null;
            } else if (Float.parseFloat(monto) <= 0 || Float.parseFloat(monto) > cuentaDebito.getSaldo()) {
                textoError = "El monto del cheque debe ser mayor a 0 y máximo " +
                        quitarZeroDecimal(cuentaDebito.getSaldo()) + " (el saldo de la cuenta débito de " +
                        "origen), \"" + monto + "\" no lo cumple.";
                monto = null;
            } else break;
        }

        System.out.format("Nombre del%n%-20s : ", "beneficiario");
        cuentaDebito.anadirCheque(new Cheque(Float.parseFloat(monto), Main.usuario, entrada.next()));

        chequesPorCobrar = tieneCheque = true;

        System.out.print(margen + "Cheque creado exitosamente.\n\nPresiona Enter para continuar.");
        esperarEnter();
    }

    public String toString() { return "Diligenciar cheque"; }
}
