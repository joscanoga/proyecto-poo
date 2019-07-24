package uiMain.menuConsola;

import gestionAplicacion.cuentas.Credito;
import uiMain.OpcionDeMenu;

import static uiMain.Main.usuario;

public class PagarCuotaCredito extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, numero;
        Credito creditoAPagar = null;

        if (filtrarOpcionesCredito("pagar cuotas")) return;

        while (true) {
            System.out.print(margen + "PAGAR CUOTA DE CRÉDITO\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "Número del crédito");
            if (!esNumerico(numero = entrada.next(), "int"))
                textoError = "El numero del crédito debe ser un valor numérico, \"" + numero + "\" no lo es.";
            else {
                for (Credito credito : cuentaCredito.getCreditos()) {
                    if (credito.getId() == Integer.parseInt(numero)) {
                        creditoAPagar = credito;
                        break;
                    }
                }
                if (creditoAPagar != null) break;
                else textoError = "No se encontró ningún crédito con el número \"" + numero + "\".";
            }
        }
        if (cuentaDebito.getSaldo() < creditoAPagar.getMonto()) {
            System.out.print("El saldo de tu cuenta débito (" + cuentaDebito.getSaldo() + ") no es suficiente " +
                    "para pagar el volor de la cuota (" + creditoAPagar.getValorCuota() + ").\n\nPresiona Enter para " +
                    "continuar.");
        } else {
            creditoAPagar.pagarCuota();

            System.out.print(margen + "Cuota pagada exitosamente.");

            if (creditoAPagar.getCuotas() == 0) {
                cuentaCredito.removerCredito(creditoAPagar.getId());
                setTieneCredito();
                if (!tieneCredito) usuario.getMenu().removerOpciones(Credito.getMenuDefectoDebito());
                System.out.print("\n\nEl crédito fue pagado totalmente.");
            }

            System.out.print("\n\nPresiona Enter para continuar.");

        }

        esperarEnter();
    }

    public String toString() {
        System.out.println("Pagar cuota");
        return " de un crédito";
    }
}
