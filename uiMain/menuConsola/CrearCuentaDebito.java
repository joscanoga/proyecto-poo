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
            System.out.print(margen + "Cuenta débito creada exitosamente.\n\nPresiona Enter para continuar.");
        } else System.out.print(margen + "Ya tienes una cuenta débito, no es posible crear más.\n\nPresiona Enter " +
                "para continuar.");

        esperarEnter();
    }

    public String toString() { return "Crear cuenta dédito"; }
}