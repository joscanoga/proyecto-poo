package uiMain.menuConsola;

import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CambiarContrasena extends OpcionDeMenu {
	
	public void ejecutar() {
        String contraVieja = null, contrasena, textoError = null;

        while (true) {
            System.out.print(margen + "CAMBIAR CONTRASEÑA\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (contraVieja != null ? contraVieja + "\n" : ""), "Contraseña actual");
            if (contraVieja == null && !(contraVieja = entrada.next()).equals(Main.usuario.getContrasena())) {
                textoError = "Contraseña incorrecta.";
                contraVieja = null;
                continue;
			}

			System.out.format("%-20s: ", "Nueva contraseña");
			contrasena = entrada.next();
			System.out.format("%-20s: ", "Verificar contraseña");
            if (!contrasena.equals(entrada.next())) textoError = "Las contraseñas no coinciden.";
            else break;
        }
		Main.usuario.setContrasena(contrasena);

		System.out.print(margen + "La contraseña ha sido cambiada.\n\nPresiona Enter para continuar.");
		esperarEnter();
	}

	public String toString(){ return "Cambiar contraseña"; }
}