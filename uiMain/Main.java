package uiMain;

import gestionAplicacion.usuarios.Usuario;
import BaseDatos.Serializador;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

class Main {
	private static Usuario usuario;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		definirUsuarioComoInvitado();
		Object[] opciones = usuario.getMenu().opciones.toArray();
		String opcion;
		for (;;) {
			opcion = null;
			do {
				if(opcion != null) 
					System.out.println("La entrada no corresponde a ningún número de opción válido, inténtalo de nuevo");
				System.out.format("%-30s%s%n", "OPCIÓN", "NÚMERO");
				for (byte i = -1; ++i < opciones.length;)
					System.out.format("%-30s%d%n", opciones[i], i + 1);
				System.out.print("\nNúmero de la opción a ejectuar: ");
			} while (!Pattern.compile("\\d+").matcher(opcion = input.next()).matches()
					|| Integer.parseInt(opcion) < 1 || Integer.parseInt(opcion) > opciones.length);
			System.out.println("Se llamará el método ejecutar de la opción: " + opciones[Integer.parseInt(opcion) - 1]);
			System.exit(0);
		}
	}

	public static void definirUsuarioComoInvitado() {
		usuario = new Usuario();
	}

}
