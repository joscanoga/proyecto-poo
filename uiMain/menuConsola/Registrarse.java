package uiMain.menuConsola;

import gestionAplicacion.usuarios.Usuario;
import uiMain.*;

public class Registrarse implements OpcionDeMenu{
	
	public void ejecutar() {
		String nombreUsuario = null, contrasena = null;

		do {
			System.out.println(margen + "FORMULARIO DE REGISTRO.\n");
			if(nombreUsuario != null)
				System.out.println("El nombre \"" + nombreUsuario + "\" no está disponible.\n");
			System.out.format("%-20s: ", "Nombre de usuario");
		} while(nombreExistente(nombreUsuario = entrada.next()));

		do {
			System.out.format(margen + "FORMULARIO DE REGISTRO.\n");
			if(contrasena != null)
				System.out.println("\nLas contraseñas no coinciden.");
			System.out.format("%n%-20s: " + nombreUsuario + "%n%-20s: ", "Nombre de usuario", "Contraseña");
			contrasena = entrada.next();
			System.out.format("%-20s: ", "Verificar contraseña");
		} while(!contrasena.equals(entrada.next()));

	System.out.format("%-20s: ", "Ingresa tu nombre");

		Main.usuarios.put(nombreUsuario, new Usuario(false, nombreUsuario, contrasena, entrada.next()));

		System.out.println("Usuario creado exitosamente.");
	}

	public String toString () {
		return "Registrarse";
	}
}