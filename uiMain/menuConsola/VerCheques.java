package uiMain.menuConsola;

import gestionAplicacion.cuentas.Cheque;
import uiMain.OpcionDeMenu;

public class VerCheques extends OpcionDeMenu {
    public void ejecutar() {
        if (filtrarOpcionesCheque("ver")) return;

        System.out.format(margen + "%-20s%-20s%-20s%-20s%n", "NÚMERO DEL CHEQUE", "MONTO", "BENEFICIARIO", "COBRADO");

        for(Cheque cheque : cuentaDebito.getCheques()) {
            for (String campo : ("" + cheque).split(",")) System.out.format("%-20s", campo);
            System.out.println();
        }

        System.out.print("\nPresiona Enter para continuar.");
        esperarEnter();
    }

    public String toString() { return "Ver cheques"; }
}
