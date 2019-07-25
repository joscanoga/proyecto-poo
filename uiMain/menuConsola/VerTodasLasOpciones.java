package uiMain.menuConsola;

import uiMain.Main;
import uiMain.OpcionDeMenu;

import java.util.Map;

public class VerTodasLasOpciones extends OpcionDeMenu {
	
	public void ejecutar() {
        System.out.println(margen + "NOMBRE DE LA OPCIÓN\n");
        for (Map.Entry<String, OpcionDeMenu> opcion : Main.listaOpciones.entrySet()) {
            if (!Main.opcionesAdmin.containsKey(opcion.getKey())) {
                System.out.println(opcion.getValue().getClass().getSimpleName());
            }
        }

        System.out.print("\nPresiona Enter para continuar.");

        esperarEnter();
	}

	public String toString(){ return "Ver todas las opciones"; }
}