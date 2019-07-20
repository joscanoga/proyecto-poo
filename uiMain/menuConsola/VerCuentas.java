package uiMain.menuConsola;

import gestionAplicacion.cuentas.Cuenta;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class VerCuentas implements OpcionDeMenu{
	
	public void ejecutar() {
		System.out.format(margen + "%-20s%-20s%n", "NÚMERO DE CUENTA", "TIPO DE CUENTA");
		for (Cuenta cuenta : Main.usuario.getCuentas()) cuenta.imprimir();

		System.out.print("\nPresiona Enter para continuar.");
		entrada.nextLine();
	}

	public String toString(){ return "Ver cuentas"; }
}