package uiMain.menuConsola;

import gestionAplicacion.usuarios.Usuario;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class Registrarse extends OpcionDeMenu {
	
	public void ejecutar() {
        String nombreUsuario = null, contrasena, textoError = null;

        while (true) {
            System.out.print(margen + "REGISTRARSE\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (nombreUsuario != null ? nombreUsuario + "\n" : ""), "Nombre de usuario");
            if (nombreUsuario == null && nombreExistente(nombreUsuario = entrada.next())) {
                textoError = "El nombre \"" + nombreUsuario + "\" no está disponible.";
                nombreUsuario = null;
                continue;
            }

            System.out.format("%-20s: ", "Contraseña");
			contrasena = entrada.next();
			System.out.format("%-20s: ", "Verificar contraseña");
            if (!contrasena.equals(entrada.next())) textoError = "Las contraseñas no coinciden.";
            else break;
        }
		System.out.format("%-20s: ", "Ingresa tu nombre");
		entrada.nextLine();

		Main.usuarios.put(nombreUsuario, new Usuario(false, nombreUsuario, contrasena, entrada.nextLine()));

		System.out.print(margen + "Usuario creado exitosamente.\n\nPresiona enter para continuar.");
		entrada.nextLine();
	}

	public String toString(){ return "Registrarse"; }
}