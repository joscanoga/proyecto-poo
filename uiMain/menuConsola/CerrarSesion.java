package uiMain.menuConsola;

import gestionAplicacion.usuarios.Usuario;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CerrarSesion extends OpcionDeMenu {

    public void ejecutar() {
        System.out.print(margen + "La sesi�n ha sido cerrada.\n\nPresiona Enter para continuar.");
        esperarEnter();

        Main.usuario = new Usuario();
    }

    public String toString(){ return "Cerrar sesi�n"; }
}