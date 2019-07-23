package uiMain.menuConsola;

import gestionAplicacion.cuentas.Debito;
import uiMain.OpcionDeMenu;

public class RemoverDebito extends OpcionDeMenu {

    public void ejecutar() {
        String textoError = null, numero;
        Debito debitoARemover = null;

        if (filtrarOpcionesDebito("remover")) return;

        while (true) {
            System.out.print(margen + "REMOVER CRÉDITO\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "Número del débito");
            if (!esNumerico(numero = entrada.next(), "int"))
                textoError = "El número debe del débito debe ser un valor numérico, \"" + numero + "\" no lo es.";
            else {
                for (Debito debito : cuentaDebito.getDebitos()) {
                    if (debito.getId() == Integer.parseInt(numero)) {
                        debitoARemover = debito;
                        break;
                    }
                }
                if (debitoARemover != null) break;
                else textoError = "No se encontró ningún cheque con el número \"" + numero + "\".";
            }
        }

        cuentaDebito.removerDebito(debitoARemover.getId());
        setTieneDebito();
        System.out.print(margen + "Débito removido exitosamente.\n\nPresiona Enter para continuar.");
        esperarEnter();

    }

    public String toString() { return "Remover débito"; }

}