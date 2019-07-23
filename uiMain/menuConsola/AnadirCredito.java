package uiMain.menuConsola;

import gestionAplicacion.cuentas.Credito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class AnadirCredito extends OpcionDeMenu {

    public void ejecutar() {
        String cuotas, textoError = null, monto = null;

        if (filtrarOpcionesCuentaCredito("crear un crédito") || filtrarCupoNulo("crear un crédito")) return;

        while (true) {
            System.out.print(margen + "CREAR CRÉDITO.\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (monto != null ? monto + "\n" : ""), "Monto");
            if (monto == null && !esNumerico(monto = entrada.next(), "float")) {
                textoError = "El monto debe ser un valor numérico, \"" + monto + "\" no lo es.";
                monto = null;
                continue;
            } else if (Float.parseFloat(monto) <= 0 || Float.parseFloat(monto) > cuentaCredito.getCupo()) {
                textoError = "El monto debe ser mayor a 0 y máximo " + cuentaCredito.getCupo() + " (cupo" +
                        " de la cuenta crédito), \"" + monto + "\" no lo cumple.";
                monto = null;
                continue;
            }

            System.out.format("%-20s: ", "Número de cuotas");
            if (!esNumerico(cuotas = entrada.next(), "int"))
                textoError = "El número de cuotas debe ser un entero \"" + cuotas + "\" no lo es.";
            else if (Integer.parseInt(cuotas) <= 0)
                textoError = "El número de cuotas no debe ser mayor a 0.";
            else break;
        }

        cuentaCredito.anadirCredito(new Credito(Main.usuario, Float.parseFloat(monto), Integer.parseInt(cuotas),
                cuentaCredito, cuentaDebito));

        tieneCredito = true;

        System.out.print(margen + "Crédito añadido exitosamente.\n\nPresiona Enter para continuar.");

        esperarEnter();
    }

    public String toString(){ return "Añadir crédito"; }
}