package uiMain;

import java.io.Serializable;
import java.util.Scanner;
import java.io.BufferedInputStream;

public interface OpcionDeMenu extends Serializable {
	Scanner entrada = new Scanner(new BufferedInputStream(System.in));
	String margen = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

	void ejecutar();

	default boolean nombreExistente(String nombre) {
		System.out.println(Main.usuarios.containsKey(nombre));return Main.usuarios.containsKey(nombre);
	}
}
