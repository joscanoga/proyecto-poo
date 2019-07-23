package uiMain.menuConsola;

import gestionAplicacion.cuentas.CuentaCredito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CrearCuentaCredito extends OpcionDeMenu {

	public void ejecutar() {
        CuentaCredito cuentaNueva;
        if (cuentaCredito != null) {
			System.out.print(margen + "Ya tienes una cuenta crédito, no es posible crear más.\n\nPresiona Enter para" +
                    " continuar.");
        } else if (cuentaDebito == null) {
			System.out.print(margen + "Debes tener una cuenta débito para poder crear una cuenta crédito." +
                    "\n\nPresiona Enter para continuar.");
		} else {
            Main.usuario.anadirCuenta(cuentaNueva = new CuentaCredito(Main.usuario));
            cuentaCredito = cuentaNueva;
			System.out.print(margen + "Cuenta crédito creada exitosamente.\n\nPresiona Enter para " +
					"continuar.");
		}

		esperarEnter();
	}

    public String toString(){ return "Crear cuenta crédito"; }
	
}