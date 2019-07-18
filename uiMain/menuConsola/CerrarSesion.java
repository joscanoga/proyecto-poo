package uiMain.menuConsola;

import uiMain.*;

public class CerrarSesion implements OpcionDeMenu {

    public void ejecutar() {
        System.out.print(margen + "La sesión ha sido cerrada.\n\nPresiona Enter para continuar.");
        entrada.nextLine();
        Main.definirInvitado();
    }

    public String toString(){ return "Cerrar sesión"; }
}