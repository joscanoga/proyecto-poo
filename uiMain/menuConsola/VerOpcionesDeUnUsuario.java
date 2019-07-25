package uiMain.menuConsola;

import uiMain.Main;
import uiMain.OpcionDeMenu;

public class VerOpcionesDeUnUsuario extends OpcionDeMenu {
	
	public void ejecutar() {
		String textoError = null, nombre;

		System.out.println(margen + "VER OPCIONES DE UN USUARIO\n");
		while (true) {
			System.out.println(margen + (textoError != null ? textoError + "\n" : ""));
			System.out.format("%-20s: ", "Nombre de usuario");
			if (!Main.usuarios.containsKey(nombre = entrada.next()))
				textoError = "El usuario de nombre \"" + nombre + "\" no se está registrado.";
			else break;
		}

		System.out.println(margen + "OPCIONES DE \"" + nombre + "\"\n");

		for (OpcionDeMenu opcion : Main.usuarios.get(nombre).getMenu().getOpciones())
			System.out.println(opcion.getClass().getSimpleName());

		System.out.print("\nPresiona Enter para continuar.");
		esperarEnter();
	}

	public String toString() {
		System.out.println("Ver las opciones de un");
		return " usuario en particular";
	}
}