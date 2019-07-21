package uiMain;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public interface RecursosVarios {
    Scanner entrada = new Scanner(new BufferedInputStream(System.in));
    String margen = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
            "<<<<<<<<<<<<<<<<<<<<<<<<<<<< Bienvenido a Green Bank >>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n" +
            "     $                                                                    $" + "\n"
            + "  $  $  $                                                              $  $  $" + "\n"
            + "   $ $ $            Un banco al alcance de sus posibilidades            $ $ $" + "\n"
            + "     $                                                                    $" + "\n"
            + "     $____________________________________________________________________$" + "\n\n\n";

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

    default boolean esNumerico(String valor, String tipo) {
        try {
            if (tipo.equals("float")) Float.parseFloat(valor);
            else if (tipo.equals("int")) Integer.parseInt(valor);
        } catch(Exception e) { return false; }

        return true;
    }
}
