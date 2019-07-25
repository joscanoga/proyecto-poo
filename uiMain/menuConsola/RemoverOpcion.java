package uiMain.menuConsola;

import uiMain.Main;
import uiMain.OpcionDeMenu;

public class RemoverOpcion extends OpcionDeMenu {

	public void ejecutar() {
		String textoError = null, nombre = null, opcion;

		while (true) {
			System.out.print(margen + "REMOVER OPCIÓN\n\n" + (textoError != null ? textoError + "\n\n" : ""));
			System.out.format("%-20s: " + (nombre != null ? nombre + "%n" : ""), "Nombre de usuario: ");
			if (nombre == null && !Main.usuarios.containsKey(nombre = entrada.next())) {
				textoError = "El usuario de nombre \"" + nombre + "\" no se está registrado.";
				nombre = null;
				continue;
			} else if (Main.usuarios.get(nombre).getEsAdmin()) {
				textoError = "Las opciones del usuario administrador no se pueden cambiar.";
				nombre = null;
				continue;
			}

			System.out.format("%-20s: ", "Nombre de la opción");
			if (!Main.listaOpciones.containsKey(opcion = entrada.next()))
				textoError = "La opción \"" + opcion + "\" no está registrada.";
			else if (Main.opcionesAdmin.containsKey(opcion))
				textoError = "La opción \"" + opcion + "\" no es manipulable.";
			else if (Main.usuarios.get(nombre).getMenu().tieneOpcion(Main.listaOpciones.get(opcion)) == -1)
				textoError = "El usuario \"" + nombre + "\" no tiene la opción \"" + opcion + "\".";
			else break;
		}

		Main.usuarios.get(nombre).getMenu().removerOpcion(Main.listaOpciones.get(opcion));

		System.out.print("\nOpción removida exitosamente.\n\nPresiona Enter para continuar.");
		esperarEnter();
	}

	public String toString(){ return "Remover opción"; }
}