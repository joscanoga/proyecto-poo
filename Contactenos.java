package uiMain.menuConsola;
import gestionAplicacion.usuarios.Usuario;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class Contactenos implements OpcionDeMenu {


	public void ejecutar() {

		System.out.println("\n\nPuedes ponerte en contacto con nosotros a travez de nuestro correo electronico contacto@greenbank.com\n"
				+ "o en los telefonos: 4442155 ext 1000 - 1001");

	}

public String toString(){ return "Contactenos"; }
}
