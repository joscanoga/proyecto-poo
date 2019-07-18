package uiMain;

import java.io.BufferedInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuDeConsola implements Serializable {
    ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>() {{
        add(new uiMain.menuConsola.SalirDeLaAplicacion());
    }};

    public MenuDeConsola(String[] menu) {
        for (String opcion : menu)
            anadirOpcion(Main.listaOpciones.get(opcion));
    }

    public void anadirOpcion(OpcionDeMenu opcion) { opciones.add(opcion); }

    /* Se muestra el conjunto de opciones asociadas al correspondiente menu de
     * consola y se recibe entrada por parte del usuario (I/O) */
    void lanzarMenu() {
        String margen = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
        Scanner entrada = new Scanner(new BufferedInputStream(System.in));
        OpcionDeMenu[] arregloOpciones = opciones.toArray(new OpcionDeMenu[opciones.size()]);
        int numero = 0;

        do {
            System.out.format(margen + "%-25s: " + Main.usuario.getNombre() + "%n%n%-25s%s%n", "Usuario", "OPCIÓN",
                    "NÚMERO");

            // Temporal
            Main.mostrarUsuarios();

            for (byte i = -1; ++i < arregloOpciones.length; )
                System.out.format("%-25s%d%n", arregloOpciones[i], i + 1);

            if (numero != 0)
                System.out.print("\n\"" + numero + "\" no corresponde a ningún número de opción válido.");

            System.out.print("\nIngrese el número de la opción a ejecutar: ");
        } while (!entrada.hasNextInt() || (numero = entrada.nextInt()) < 1 || numero > arregloOpciones.length);

        arregloOpciones[numero - 1].ejecutar();

    }

    // Temporal
    @Override
    public String toString() {
        String text = "";
        for (OpcionDeMenu opcion : opciones)
            text += opcion.getClass().getSimpleName() + ", ";
        text = text.substring(0, text.length() - 2);
        return text;
    }

}
