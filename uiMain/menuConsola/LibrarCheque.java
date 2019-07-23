package uiMain.menuConsola;

import gestionAplicacion.cuentas.Cheque;
import uiMain.OpcionDeMenu;

public class LibrarCheque extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, monto;

        if (filtrarOpcionesCuentaDebito("librar un cheque")) return;

        while (true) {
            System.out.print(margen + "LIBRAR CHEQUE\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "Monto del cheque");
            if (!esNumerico(monto = entrada.next(), "float"))
                textoError = "El monto del cheque debe ser un valor numérico, \"" + monto + "\" no lo es.";
            else if (Float.parseFloat(monto) <= 0)
                textoError = "El monto del cheque debe ser mayor a 0, \"" + monto + "\" no lo cumple.";
            else break;
        }

        System.out.format("Nombre del%n%-20s : ", "beneficiario");
        cuentaDebito.anadirCheque(new Cheque(Float.parseFloat(monto), entrada.next()));

        chequesPorCobrar = tieneCheque = true;

        System.out.print(margen + "Cheque creado exitosamente.\n\nPresiona Enter para continuar.");
        esperarEnter();
    }

    public String toString() { return "Librar cheque"; }
}
