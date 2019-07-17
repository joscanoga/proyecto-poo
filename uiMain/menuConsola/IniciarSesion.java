package uiMain.menuConsola;

import uiMain.Main;
import uiMain.OpcionDeMenu;

public class IniciarSesion implements OpcionDeMenu{
	
	public void ejecutar() {
		String nombreUsuario = null, contrasena, contrasenaIntento = null;

		do {
			System.out.println(margen + "FORMULARIO DE INICIO DE SESIÓN.\n");
			if(nombreUsuario != null)
				System.out.println("El nombre \"" + nombreUsuario + "\" no está registrado.\n");
			System.out.format("%-20s: ", "Nombre de usuario");
		} while(!nombreExistente(nombreUsuario = entrada.next()));

		contrasena = Main.usuarios.get(nombreUsuario).getContrasena();

		do {
			System.out.println(margen + "FORMULARIO DE INICIO DE SESIÓN.\n");
			if (contrasenaIntento != null)
				System.out.println("Contraseña incorrecta.\n");
			System.out.format("%-20S: " + nombreUsuario + "%n%-20s: ", "Nombre de usuario", "Contraseña");
		} while(!contrasena.equals(contrasenaIntento = entrada.next()));

		Main.usuario = Main.usuarios.get(nombreUsuario);

	}

	public String toString () {
		return "Iniciar sesión";
	}
}