package uiMain;

import java.io.Serializable;
import java.util.ArrayList;
import uiMain.menuConsola.SalirDeLaAplicacion;

public class MenuDeConsola implements Serializable {
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

	// Temporal
	@Override
	public String toString() {
		String text = "\"";
		for (OpcionDeMenu opcion : opciones) {
			text += opcion.getClass().getSimpleName() + " ";
		}
		text += "\"";
		return text;
	}

}
