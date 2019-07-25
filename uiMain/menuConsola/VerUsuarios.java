package uiMain.menuConsola;

import gestionAplicacion.usuarios.Usuario;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class VerUsuarios extends OpcionDeMenu {

    public void ejecutar() {
        System.out.format(margen + "USUARIOS%n%n" + "%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n%n", "ID", "NOMBRE",
                "NOMBRE DE USUARIO", "CONTRASEÑA", "ES ADMINISTRADOR", "NÚMERO DE OPCIONES", "NÚMERO DE CUENTAS");
        for (Usuario usuario : Main.usuarios.values()) {
            for (String campo : ("" + usuario).split(","))
                System.out.format("%-20s", campo);
            System.out.println();
        }

        System.out.print("\nPresiona Enter para continuar.");

        esperarEnter();
    }

    public String toString() { return "Ver usuarios"; }
}