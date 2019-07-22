package uiMain.menuConsola;

import uiMain.Main;
import uiMain.OpcionDeMenu;

public class IniciarSesion extends OpcionDeMenu {

    public void ejecutar() {
        String nombreUsuario = null, textoError = null;

        while (true) {
            System.out.print(margen + "INICIAR SESIÓN\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (nombreUsuario != null ? nombreUsuario + "\n" : ""), "Nombre de usuario");
            if (nombreUsuario == null && !nombreExistente(nombreUsuario = entrada.next())) {
                textoError = "El nombre \"" + nombreUsuario + "\" no está registrado.";
                nombreUsuario = null;
                continue;
            }

            System.out.format("%-20s: ", "Contraseña");
            if (!Main.usuarios.get(nombreUsuario).getContrasena().equals(entrada.next()))
                textoError = "Contraseña incorrecta.";
            else break;
        }
        Main.usuario = Main.usuarios.get(nombreUsuario);
        cargarInfoUsuario();

        System.out.print(margen + "Sesión iniciada.\n\nPresiona enter para continuar.");
        esperarEnter();
    }

    public String toString(){ return "Iniciar sesión"; }
}