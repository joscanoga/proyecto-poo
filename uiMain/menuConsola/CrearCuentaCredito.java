package uiMain.menuConsola;

import gestionAplicacion.cuentas.CuentaCredito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CrearCuentaCredito extends OpcionDeMenu {

	public void ejecutar() {
        CuentaCredito cuentaNueva;
        if (cuentaCredito != null) {
			System.out.print(margen + "Ya tienes una cuenta cr�dito, no es posible crear m�s.\n\nPresiona Enter para" +
                    " continuar.");
        } else if (cuentaDebito == null) {
			System.out.print(margen + "Debes tener una cuenta d�bito para poder crear una cuenta cr�dito." +
                    "\n\nPresiona Enter para continuar.");
		} else {
            Main.usuario.anadirCuenta(cuentaNueva = new CuentaCredito(Main.usuario));
            cuentaCredito = cuentaNueva;
			System.out.print(margen + "Cuenta cr�dito creada exitosamente.\n\nPresiona Enter para " +
					"continuar.");
		}

		esperarEnter();
	}

    public String toString(){ return "Crear cuenta cr�dito"; }
	
}