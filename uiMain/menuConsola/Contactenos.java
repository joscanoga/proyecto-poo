package uiMain.menuConsola;

import uiMain.OpcionDeMenu;

public class Contactenos extends OpcionDeMenu {


    public void ejecutar() {
        System.out.print(margen + "Puedes ponerte en contacto con nosotros a través de:\n\n- Nuestro correo " +
                "electrónico contacto@greenbank.com\n- Ó en los teléfonos: 4442155 ext 1000 - 1001\n\nPresiona Enter " +
                "para continuar.");
        esperarEnter();
    }

    public String toString() { return "Contáctenos"; }
}
