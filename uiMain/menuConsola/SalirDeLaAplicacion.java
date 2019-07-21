package uiMain.menuConsola;

import uiMain.*;
import BaseDatos.Serializador;

public class SalirDeLaAplicacion extends OpcionDeMenu {

	public void ejecutar() {
		try {
			Serializador.guardar(Main.usuarios);
		} catch (Exception e) {
			System.out.println("Los datos no fueron guardaron correctamente.");
		} finally {
			System.out.print("La ejecución de la aplicación ha sido terminada.");
			System.exit(0);
		}
	}

	public String toString(){ return "Salir de la aplicación"; }

}