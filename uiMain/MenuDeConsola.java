package uiMain;

import java.util.ArrayList;
import uiMain.menuConsola.SalirDeLaAplicacion;

public class MenuDeConsola {
	ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>() {
		{
			add(new SalirDeLaAplicacion());
		}
	};

	public MenuDeConsola(OpcionDeMenu[] menu) {
		for (OpcionDeMenu opcion : menu)
			anadirOpcion(opcion);
	}

	void anadirOpcion(OpcionDeMenu opcion) {
		opciones.add(opcion);
	}

	// Se muestra el conjunto de opciones asociadas al correspondiente menu de
	// consola y se recibe entrada por parte del usuario (I/O)
	void lanzarMenu() {

	}
}
