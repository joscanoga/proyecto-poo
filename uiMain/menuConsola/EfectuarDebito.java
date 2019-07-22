package uiMain.menuConsola;

import gestionAplicacion.cuentas.Debito;
import uiMain.OpcionDeMenu;

public class EfectuarDebito extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, numero;
        Debito debitoAEfectuar = null;

        if (filtrarOpcionesDebito("cobrar")) return;

        while (true) {
            System.out.print(margen + "EFECTUAR DÉBITO\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "Número del débito");
            if (!esNumerico(numero = entrada.next(), "int"))
                textoError = "El numero del débito debe ser un valor numérico, \"" + numero + "\" no lo es.";
            else {
                for (Debito debito : cuentaDebito.getDebitos()) {
                    if (debito.getId() == Integer.parseInt(numero)) {
                        debitoAEfectuar = debito;
                        break;
                    }
                }
                if (debitoAEfectuar != null) break;
                else textoError = "No se encontró ningún débito con el número \"" + numero + "\".";
            }
        }
        if (cuentaDebito.getSaldo() < debitoAEfectuar.getMonto()) {
            System.out.print("El saldo de tu cuenta débito (" + cuentaDebito.getSaldo() + ") no es suficiente " +
                    "para efectuar el débito (" + debitoAEfectuar.getMonto() + ").\n\nPresiona Enter para continuar.");
        } else {
            cuentaDebito.setSaldo(cuentaDebito.getSaldo() - debitoAEfectuar.getMonto());
            debitoAEfectuar.debitar();
            System.out.print(margen + "Débito efectuado exitosamente.\n\nPresiona Enter para continuar.");
        }

        esperarEnter();
    }

    public String toString() { return "Efectuar débito"; }
}
