package uiMain.menuConsola;

import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CerrarSesion extends OpcionDeMenu {

    public void ejecutar() {
        System.out.print(margen + "La sesión ha sido cerrada.\n\nPresiona Enter para continuar.");
        esperarEnter();

        Main.definirInvitado();
    }

    public String toString(){ return "Cerrar sesión"; }
}