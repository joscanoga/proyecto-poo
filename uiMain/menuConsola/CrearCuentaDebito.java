package uiMain.menuConsola;

import gestionAplicacion.cuentas.Cuenta;
import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.*;

public class CrearCuentaDebito implements OpcionDeMenu{
	
	public void ejecutar() {
		boolean noTiene = true;
		if (Main.usuario.getCuentas() != null) {
			for (Cuenta cuenta : Main.usuario.getCuentas()) {
				if (cuenta instanceof CuentaDebito) {
					noTiene = false;
					break;
				}
			}
		}

		if (noTiene) {
			Main.usuario.anadirCuenta(new CuentaDebito(Main.usuario));
			System.out.print(margen + "Cuenta débito creada exitosamente.\n\nPresiona Enter para continuar.");
		} else System.out.print(margen + "Ya tienes una cuenta débito, no es crear más.\n\nPresiona Enter " +
				"para continuar.");

		entrada.nextLine();

	}

	public String toString(){ return "Crear cuenta dédito"; }
}