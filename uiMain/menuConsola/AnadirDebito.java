package uiMain.menuConsola;

import gestionAplicacion.cuentas.Debito;
import uiMain.OpcionDeMenu;

public class AnadirDebito extends OpcionDeMenu {

    public void ejecutar() {
        String textoError = null, monto;

        if (filtrarOpcionesCuentaDebito("crear un débito")) return;

        while (true) {
            System.out.print(margen + "A�adir d�bito\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "Monto del d�bito");
            if (!esNumerico(monto = entrada.next(), "float"))
                textoError = "El monto del débito debe ser un valor num�rico, \"" + monto + "\" no lo es.";
            else if (Float.parseFloat(monto) <= 0)
                textoError = "El monto del d�bito debe ser mayor a 0, \"" + monto + "\" no lo cumple.";
            else break;
        }

        cuentaDebito.anadirDebito(new Debito(Float.parseFloat(monto)));

        tieneDebito = true;

        System.out.print(margen + "D�bito a�adido exitosamente.\n\nPresiona Enter para continuar.");
        esperarEnter();

    }

    public String toString() { return "A�adir d�bito"; }

}