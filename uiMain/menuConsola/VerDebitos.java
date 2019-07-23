package uiMain.menuConsola;

import gestionAplicacion.cuentas.Debito;
import uiMain.OpcionDeMenu;

public class VerDebitos extends OpcionDeMenu {

    public void ejecutar() {
        if (filtrarOpcionesDebito("ver")) return;

        System.out.format(margen + "%-20s%-20s%-20s%n%48s%n", "N�MERO DEL D�BITO", "MONTO", "N�MERO DE VECES",
                "DEBITADO");

        for (Debito debito : cuentaDebito.getDebitos()) {
            for (String campo : ("" + debito).split(",")) System.out.format("%-20s", campo);
            System.out.println();
        }

        System.out.print("\nPresiona Enter para continuar.");
        esperarEnter();
    }

    public String toString() { return "Ver d�bitos"; }

}