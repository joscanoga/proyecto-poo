package uiMain.menuConsola;

import gestionAplicacion.cuentas.Cuenta;
import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CrearCuentaDebito implements OpcionDeMenu {

    public void ejecutar() {
        boolean tiene = false;
        if (Main.usuario.getCuentas() != null) {
            for (Cuenta cuenta : Main.usuario.getCuentas()) {
                if (cuenta instanceof CuentaDebito) {
                    tiene = true;
                    break;
                }
            }
        }

        if (!tiene) {
            Main.usuario.anadirCuenta(new CuentaDebito(Main.usuario));
            System.out.print(margen + "Cuenta débito creada exitosamente.\n\nPresiona Enter para continuar.");
        } else System.out.print(margen + "Ya tienes una cuenta débito, no es crear más.\n\nPresiona Enter " +
                "para continuar.");

        entrada.nextLine();
    }

    public String toString() { return "Crear cuenta dédito"; }
}