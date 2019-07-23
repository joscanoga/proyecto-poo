package uiMain.menuConsola;

import gestionAplicacion.cuentas.Debito;
import uiMain.OpcionDeMenu;

public class AnadirDebito extends OpcionDeMenu {

    public void ejecutar() {
        String textoError = null, monto;

        if (filtrarOpcionesCuentaDebito("crear un débito")) return;

        while (true) {
            System.out.print(margen + "Añadir débito\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "Monto del débito");
            if (!esNumerico(monto = entrada.next(), "float"))
<<<<<<< HEAD
                textoError = "El monto del débito debe ser un valor numérico, \"" + monto + "\" no lo es.";
=======
                textoError = "El monto del débito debe ser un valor num�rico, \"" + monto + "\" no lo es.";
>>>>>>> parent of 7302490... Add files via upload
            else if (Float.parseFloat(monto) <= 0)
                textoError = "El monto del débito debe ser mayor a 0, \"" + monto + "\" no lo cumple.";
            else break;
        }

        cuentaDebito.anadirDebito(new Debito(Float.parseFloat(monto)));

        tieneDebito = true;

        System.out.print(margen + "Débito añadido exitosamente.\n\nPresiona Enter para continuar.");
        esperarEnter();

    }

    public String toString() { return "Añadir débito"; }

}