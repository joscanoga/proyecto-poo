package uiMain.menuConsola;

import uiMain.OpcionDeMenu;

public class Contactenos extends OpcionDeMenu {


    public void ejecutar() {
        System.out.print(margen + "Puedes ponerte en contacto con nosotros a trav�s de:\n\n- Nuestro correo " +
                "electr�nico contacto@greenbank.com\n- � en los tel�fonos: 4442155 ext 1000 - 1001\n\nPresiona Enter " +
                "para continuar.");
        esperarEnter();
    }

    public String toString() { return "Cont�ctenos"; }
}
