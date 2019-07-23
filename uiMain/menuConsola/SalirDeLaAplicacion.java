package uiMain.menuConsola;

import BaseDatos.Serializador;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class SalirDeLaAplicacion extends OpcionDeMenu {

	public void ejecutar() {
		try {
			Serializador.guardar(Main.usuarios);
		} catch (Exception e) {
			System.out.println("Los datos no fueron guardaron correctamente.");
		}

		System.out.print("\nLa ejecuci�n de la aplicaci�n ha sido terminada.");
		System.exit(0);
	}

	public String toString(){ return "Salir de la aplicaci�n"; }

}