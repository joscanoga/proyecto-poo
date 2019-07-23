package uiMain.menuConsola;

import uiMain.OpcionDeMenu;

public class Contactenos extends OpcionDeMenu {


    public void ejecutar() {
        System.out.print(margen + "Puedes ponerte en contacto con nosotros a travès de:\n\n- Nuestro correo " +
                "electrònico contacto@greenbank.com\n- ò“ en los telèfonos: 4442155 ext 1000 - 1001\n\nPresiona Enter " +
                "para continuar.");
        esperarEnter();
    }

    public String toString() { return "Contàctenos"; }
}
