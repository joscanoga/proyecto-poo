package uiMain.menuConsola;

import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CrearCuentaDebito extends OpcionDeMenu {

    public void ejecutar() {
        CuentaDebito cuentaNueva;
        if (cuentaDebito == null) {
            Main.usuario.anadirCuenta(cuentaNueva = new CuentaDebito(Main.usuario));
            cuentaDebito = cuentaNueva;
            System.out.print(margen + "Cuenta d�bito creada exitosamente.\n\nPresiona Enter para continuar.");
        } else System.out.print(margen + "Ya tienes una cuenta d�bito, no es posible crear m�s.\n\nPresiona Enter " +
                "para continuar.");

        esperarEnter();
    }

    public String toString() { return "Crear cuenta d�dito"; }
}