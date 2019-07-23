package uiMain.menuConsola;

import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CambiarContrasena extends OpcionDeMenu {
	
	public void ejecutar() {
        String contraVieja = null, contrasena, textoError = null;

        while (true) {
            System.out.print(margen + "CAMBIAR CONTRASEŅA\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (contraVieja != null ? contraVieja + "\n" : ""), "Contraseņa actual");
            if (contraVieja == null && !(contraVieja = entrada.next()).equals(Main.usuario.getContrasena())) {
                textoError = "Contraseņa incorrecta.";
                contraVieja = null;
                continue;
			}

			System.out.format("%-20s: ", "Nueva contraseņa");
			contrasena = entrada.next();
			System.out.format("%-20s: ", "Verificar contraseņa");
            if (!contrasena.equals(entrada.next())) textoError = "Las contraseņas no coinciden.";
            else break;
        }
		Main.usuario.setContrasena(contrasena);

		System.out.print(margen + "La contraseņa ha sido cambiada.\n\nPresiona Enter para continuar.");
		esperarEnter();
	}

	public String toString(){ return "Cambiar contraseņa"; }
}