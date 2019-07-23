package uiMain.menuConsola;

import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CambiarContrasena extends OpcionDeMenu {
	
	public void ejecutar() {
        String contraVieja = null, contrasena, textoError = null;

        while (true) {
            System.out.print(margen + "CAMBIAR CONTRASE�A\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (contraVieja != null ? contraVieja + "\n" : ""), "Contrase�a actual");
            if (contraVieja == null && !(contraVieja = entrada.next()).equals(Main.usuario.getContrasena())) {
                textoError = "Contrase�a incorrecta.";
                contraVieja = null;
                continue;
			}

			System.out.format("%-20s: ", "Nueva contrase�a");
			contrasena = entrada.next();
			System.out.format("%-20s: ", "Verificar contrase�a");
            if (!contrasena.equals(entrada.next())) textoError = "Las contrase�as no coinciden.";
            else break;
        }
		Main.usuario.setContrasena(contrasena);

		System.out.print(margen + "La contrase�a ha sido cambiada.\n\nPresiona Enter para continuar.");
		esperarEnter();
	}

	public String toString(){ return "Cambiar contrase�a"; }
}