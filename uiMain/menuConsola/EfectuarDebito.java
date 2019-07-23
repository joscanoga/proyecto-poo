package uiMain.menuConsola;

import gestionAplicacion.cuentas.Debito;
import uiMain.OpcionDeMenu;

public class EfectuarDebito extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, numero;
        Debito debitoAEfectuar = null;

        if (filtrarOpcionesDebito("cobrar")) return;

        while (true) {
            System.out.print(margen + "EFECTUAR D�BITO\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "N�mero del d�bito");
            if (!esNumerico(numero = entrada.next(), "int"))
                textoError = "El numero del d�bito debe ser un valor num�rico, \"" + numero + "\" no lo es.";
            else {
                for (Debito debito : cuentaDebito.getDebitos()) {
                    if (debito.getId() == Integer.parseInt(numero)) {
                        debitoAEfectuar = debito;
                        break;
                    }
                }
                if (debitoAEfectuar != null) break;
                else textoError = "No se encontr� ning�n d�bito con el n�mero \"" + numero + "\".";
            }
        }
        if (cuentaDebito.getSaldo() < debitoAEfectuar.getMonto()) {
            System.out.print("El saldo de tu cuenta d�bito (" + cuentaDebito.getSaldo() + ") no es suficiente " +
                    "para efectuar el d�bito (" + debitoAEfectuar.getMonto() + ").\n\nPresiona Enter para continuar.");
        } else {
            cuentaDebito.setSaldo(cuentaDebito.getSaldo() - debitoAEfectuar.getMonto());
            debitoAEfectuar.debitar();
            System.out.print(margen + "D�bito efectuado exitosamente.\n\nPresiona Enter para continuar.");
        }

        esperarEnter();
    }

    public String toString() { return "Efectuar d�bito"; }
}
