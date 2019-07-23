package uiMain.menuConsola;

import uiMain.OpcionDeMenu;

public class Consignar extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, monto;

        if (filtrarOpcionesCuentaDebito("consignar")) return;

        while (true) {
            System.out.print(margen + "CONSIGNAR\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "Monto");
            if (!esNumerico(monto = entrada.next(), "float"))
                textoError = "El valor del monto debe ser un valor numérico, " + "\"" + monto + "\" no lo es.";
            else if (Float.parseFloat(monto) <= 0) textoError = "El monto debe ser mayor a 0.";
            else break;
        }

        cuentaDebito.consignar(Float.parseFloat(monto));

        System.out.print(margen + "Consignación realizada exitosamente.\n\nPresiona Enter para continuar");
        esperarEnter();
    }

    public String toString() { return "Consignar"; }
}

