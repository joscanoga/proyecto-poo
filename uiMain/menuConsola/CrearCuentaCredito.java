package uiMain.menuConsola;

import gestionAplicacion.cuentas.Cuenta;
import gestionAplicacion.cuentas.CuentaCredito;
import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CrearCuentaCredito implements OpcionDeMenu{

	public void ejecutar() {
		boolean tieneCuentaDebito = false, tieneCuentaCredito = false;
		if (Main.usuario.getCuentas() != null) {
			for (Cuenta cuenta : Main.usuario.getCuentas()) {
				if (cuenta instanceof CuentaCredito) {
					tieneCuentaCredito = true;
					break;
				} else if (cuenta instanceof CuentaDebito) tieneCuentaDebito = true;
			}
		}

		if (tieneCuentaCredito) {
			System.out.print(margen + "Ya tienes una cuenta crédito, no es posible crear más.\n\nPresiona Enter para" +
                    " continuar.");
		} else if (!tieneCuentaDebito) {
			System.out.print(margen + "Debes tener una cuenta débito para poder crear una cuenta crédito." +
                    "\n\nPresiona Enter para continuar.");
		} else {
			Main.usuario.anadirCuenta(new CuentaCredito(Main.usuario));
			System.out.print(margen + "Cuenta crédito creada exitosamente.\n\nPresiona Enter para " +
					"continuar.");
		}

		entrada.nextLine();
	}
	
	public String toString(){ return "Crear cuenta crédito"; }
	
}