package uiMain.menuConsola;

import gestionAplicacion.cuentas.Debito;
import uiMain.OpcionDeMenu;

public class RemoverDebito extends OpcionDeMenu {

    public void ejecutar() {
        String textoError = null, numero;
        Debito debitoARemover = null;

        if (filtrarOpcionesDebito("remover")) return;

        while (true) {
            System.out.print(margen + "REMOVER CR�DITO\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "N�mero del d�bito");
            if (!esNumerico(numero = entrada.next(), "int"))
                textoError = "El n�mero debe del d�bito debe ser un valor num�rico, \"" + numero + "\" no lo es.";
            else {
                for (Debito debito : cuentaDebito.getDebitos()) {
                    if (debito.getId() == Integer.parseInt(numero)) {
                        debitoARemover = debito;
                        break;
                    }
                }
                if (debitoARemover != null) break;
                else textoError = "No se encontr� ning�n cheque con el n�mero \"" + numero + "\".";
            }
        }

        cuentaDebito.removerDebito(debitoARemover.getId());
        setTieneDebito();
        System.out.print(margen + "D�bito removido exitosamente.\n\nPresiona Enter para continuar.");
        esperarEnter();

    }

    public String toString() { return "Remover d�bito"; }

}