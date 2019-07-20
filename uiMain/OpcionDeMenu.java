package uiMain;

import java.io.BufferedInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public interface OpcionDeMenu extends Serializable {
    Scanner entrada = new Scanner(new BufferedInputStream(System.in));
    String margen = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

    void ejecutar();

    default boolean nombreExistente(String nombre) {
        return Main.usuarios.containsKey(nombre);
    }

    default void esperarEnter() {
        entrada.nextLine();
        entrada.nextLine();
    }

    default String quitarZeroDecimal(float numero) {
        return (float)(int)numero == numero ? String.valueOf((int)numero) : "" + numero;
    }

    default Object buscarObjetoEn(Class clase, ArrayList objetos) {
        for (Object objeto : objetos)
            if (clase.isInstance(objeto)) return objeto;
        return null;
    }
}
