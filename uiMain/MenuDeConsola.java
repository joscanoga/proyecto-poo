package uiMain;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuDeConsola implements Serializable {
	ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>() {{
		add(new uiMain.menuConsola.SalirDeLaAplicacion());
	}};

	public MenuDeConsola(String[] menu) {
		for (String opcion : menu)
			anadirOpcion(Main.listaOpciones.get(opcion));
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
