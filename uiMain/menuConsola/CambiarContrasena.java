package uiMain.menuConsola;

import uiMain.*;

public class CambiarContrasena implements OpcionDeMenu{
	
	public void ejecutar() {
		String contrasenaActual = null, contrasena = null, mensajeError = null;

		do {
			System.out.println(margen + "CAMBIO DE CONTRASEÑA.");

			if(mensajeError != null) System.out.println(mensajeError);

			System.out.format("%n%-20s: ", "Contraseña actual");
			if (contrasenaActual != null) System.out.println(contrasenaActual);
			else {
				if (!(contrasenaActual = entrada.next()).equals(Main.usuario.getContrasena())) {
					mensajeError = "\nContraseña incorrecta.";
					contrasenaActual = null;
					continue;
				}
			}

			System.out.format("%-20s: ", "Nueva contraseña");
			contrasena = entrada.next();
			System.out.format("%-20s: ", "Verificar contraseña");
			if (!contrasena.equals(entrada.next())) mensajeError = "\nLas contraseñas no coinciden.";
			else mensajeError = null;

		} while(mensajeError != null);

		Main.usuario.setContrasena(contrasena);

		System.out.print(margen + "La contraseña ha sido cambiada.\n\nPresiona Enter para continuar.");
		esperarEnter();

	}

	public String toString(){ return "Cambiar contraseña"; }
}