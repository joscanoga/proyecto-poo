package uiMain.menuConsola;

import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CrearCuentaDebito extends OpcionDeMenu {

    public void ejecutar() {
        if (buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas()) == null) {
            Main.usuario.anadirCuenta(new CuentaDebito(Main.usuario));
            System.out.print(margen + "Cuenta débito creada exitosamente.\n\nPresiona Enter para continuar.");
        } else System.out.print(margen + "Ya tienes una cuenta débito, no es posible crear más.\n\nPresiona Enter " +
                "para continuar.");

        esperarEnter();
    }

    public String toString() { return "Crear cuenta dédito"; }
}