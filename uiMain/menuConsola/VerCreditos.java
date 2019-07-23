package uiMain.menuConsola;

import gestionAplicacion.cuentas.Credito;
import uiMain.OpcionDeMenu;

public class VerCreditos extends OpcionDeMenu {

    public void ejecutar() {

        if (filtrarOpcionesCredito("ver")) return;

        System.out.format(margen + "%-20s%-20s%-20s%-20s%n", "NÚMERO DEL CRÉDITO", "MONTO", "CUOTAS PENDIENTES",
                "VALOR " +
                        "POR CUOTA");

        for (Credito credito : cuentaCredito.getCreditos()) {
            for (String campo : ("" + credito).split(",")) System.out.format("%-20s", campo);
            System.out.println();
        }

        System.out.print("\nPresiona Enter para continuar.");
        esperarEnter();
    }

    public String toString() { return "Ver Créditos"; }

}