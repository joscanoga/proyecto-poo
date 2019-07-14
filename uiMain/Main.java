package uiMain;

import gestionAplicacion.usuarios.Usuario;
import uiMain.OpcionDeMenu;
import BaseDatos.Serializador;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.util.HashMap;

public class Main {

	public static Usuario usuario = new Usuario();
	public static HashMap<String, Usuario> usuarios;

	public static void main(String[] args) throws IOException {
		String opcion,
				margen = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
		Scanner input = new Scanner(new BufferedInputStream(System.in));

		// Todos los usuarios y administradores registrados en la base de datos
		usuarios = Serializador.cargar();

		OpcionDeMenu[] opciones = usuario.getMenu().opciones
				.toArray(new OpcionDeMenu[usuario.getMenu().opciones.size()]);

		for (;;) {
			opcion = null;

			do {
				System.out.format(margen + "%-30s%s%n", "OPCIÓN", "NÚMERO");
				for (byte i = -1; ++i < opciones.length;)
					System.out.format("%-30s%d%n", opciones[i], i + 1);
				if (opcion != null)
					System.out
							.print("\nLa entrada \"" + opcion + "\" no corresponde a ningún número de opción válido.");

				System.out.print("\nIngrese el número de la opción a ejectuar: ");
			} while (!Pattern.compile("\\d+").matcher(opcion = input.next()).matches() || Integer.parseInt(opcion) < 1
					|| Integer.parseInt(opcion) > opciones.length);

			opciones[Integer.parseInt(opcion) - 1].ejecutar();
		}

	}

}
