package uiMain.menuConsola;

import gestionAplicacion.cuentas.Cheque;
import uiMain.OpcionDeMenu;

public class CobrarCheque extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, numero;
        Cheque chequePorCobrar = null;
        if (filtrarOpcionesCheque("cobrar")) return;

        if (!chequesPorCobrar) {
            System.out.print(margen + "Todos tus cheques ya fueron cobrados.\n\nPresiona Enter para continuar.");
        } else {
            while (true) {
                System.out.print(margen + "COBRAR CHEQUE\n\n" + (textoError != null ? textoError + "\n\n" : ""));
                System.out.format("%-20s: ", "Número del cheque");
                if (!esNumerico(numero = entrada.next(), "int"))
                    textoError = "El numero debe del cheque debe ser un valor numérico, \"" + numero + "\" no lo es.";
                else {
                    for (Cheque cheque : cuentaDebito.getCheques()) {
                        if (cheque.getId() == Integer.parseInt(numero)) {
                            chequePorCobrar = cheque;
                            break;
                        }
                    }
                    if (chequePorCobrar != null) break;
                    else {
                        textoError = "No se encontró ningún cheque con el número \"" + numero + "\".";
                    }
                }
            }
            if (chequePorCobrar.getCobrado())
                System.out.print(margen + "El cheque de número \"" + numero + "\" ya fué cobrado.\n\nPresiona Enter " +
                        "para continuar.");
            else {
                if (cuentaDebito.getSaldo() < chequePorCobrar.getMonto()) {
                    System.out.println("El saldo de tu cuenta débito (" + cuentaDebito.getSaldo() + ") no es suficiente " +
                            "para cobrar monto del cheque (" + chequePorCobrar.getMonto() + ").\n\nPresiona Enter para " +
                            "continuar.");
                } else {
                    cuentaDebito.setSaldo(cuentaDebito.getSaldo() - chequePorCobrar.getMonto());
                    chequePorCobrar.cobrar();
                    setChequesPorCobrar();
                    System.out.print(margen + "Cheque cobrado exitosamente.\n\nPresiona Enter para continuar.");
                }
            }
        }

        esperarEnter();
    }

    public String toString() { return "Cobrar cheque"; }
}
