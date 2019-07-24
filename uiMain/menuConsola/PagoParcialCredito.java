package uiMain.menuConsola;

import gestionAplicacion.cuentas.Credito;
import uiMain.OpcionDeMenu;

import static uiMain.Main.usuario;

public class PagoParcialCredito extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, numero = null, monto;
        Credito creditoAPagar = null;

        if (filtrarOpcionesCredito("pagar cuotas")) return;

        while (true) {
            System.out.print(margen + "ABONAR MONTO A CRÉDITO\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (creditoAPagar != null ? creditoAPagar.getId() + "\n" : ""), "Número del " +
                    "crédito");
            if (creditoAPagar == null && !esNumerico(numero = entrada.next(), "int")) {
                textoError = "El numero del crédito debe ser un valor numérico, \"" + numero + "\" no lo es.";
                continue;
            } else {
                for (Credito credito : cuentaCredito.getCreditos()) {
                    if (credito.getId() == Integer.parseInt(numero)) {
                        creditoAPagar = credito;
                        break;
                    }
                }
                if (creditoAPagar == null) {
                    textoError = "No se encontró ningún crédito con el número \"" + numero + "\".";
                    continue;
                }
            }
            System.out.format("%-20s: ", "Monto");
            if (!esNumerico(monto = entrada.next(), "float"))
                textoError = "El valor del monto debe ser un valor numérico, " + "\"" + monto + "\" no lo es.";
            else if (Float.parseFloat(monto) <= 0) textoError = "El monto debe ser mayor a 0.";
            else if (Float.parseFloat(monto) > creditoAPagar.getMonto()) {
                textoError = "El monto no puede ser mayor al monto total del crédito (" + creditoAPagar.getMonto() +
                        ").";
            } else if (Float.parseFloat(monto) > cuentaDebito.getSaldo()) {
                textoError = "El monto debe ser mayor a 0 y máximo " + quitarZeroDecimal(cuentaDebito.getSaldo()) +
                        " (el saldo de la cuenta débito), el valor \"" + monto + "\" no lo cumple.";
            } else break;

        }

        creditoAPagar.pagarParcial(Float.parseFloat(monto));
        System.out.print(margen + "Cuota pagada exitosamente.");

        if (creditoAPagar.getCuotas() == 0) {
            cuentaCredito.removerCredito(creditoAPagar.getId());
            setTieneCredito();
            if (!tieneCredito) usuario.getMenu().removerOpciones(Credito.getMenuDefectoDebito());
            System.out.print("\n\nEl crédito fue pagado totalmente.");
        }

        System.out.print("\n\nPresiona Enter para continuar.");

        esperarEnter();
    }

    public String toString() {
        System.out.println("Abonar monto");
        return " específico a un crédito";
    }
}
