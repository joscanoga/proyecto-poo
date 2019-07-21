package uiMain.menuConsola;

import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class Consignar extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, monto;

        while (true) {
            System.out.println(margen + "FORMULARIO DE CONSIGNACIÓN\n");
            if (textoError != null) System.out.println(textoError + "\n");
            System.out.format("%-20s: ", "Monto");
            if (!esNumerico(monto = entrada.next(), "float")) {
                textoError = "El valor del monto debe ser un valor numérico, " + "\"" + monto + "\" no lo es.";
                continue;
            }

            if (Float.parseFloat(monto) == 0) {
                textoError = "El monto debe ser mayor a 0.";
                continue;
            }
            break;
        }

        ((CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas())).consignar(Float.parseFloat(monto));

        System.out.print(margen + "Consignación realizada exitosamente.\n\nPresiona Enter para continuar");
        esperarEnter();
    }

    public String toString() { return "Consignar"; }
}
