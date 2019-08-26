package uiMain.menuConsola;

import gestionAplicacion.usuarios.*;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CerrarSesion extends OpcionDeMenu {

    public void ejecutar() {
        System.out.print(margen + "La sesión ha sido cerrada.\n\nPresiona Enter para continuar.");
        esperarEnter();

        Main.usuario = new UsuarioInvitado();
    }

    public String toString(){ return "Cerrar sesión"; }
}