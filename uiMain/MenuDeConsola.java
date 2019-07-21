package uiMain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MenuDeConsola implements Serializable, RecursosVarios {
    private ArrayList<OpcionDeMenu> opciones = new ArrayList<>() {{
        add(new uiMain.menuConsola.SalirDeLaAplicacion());
    }};

    public MenuDeConsola(String[] menu) { anadirOpciones(menu); }

    public final void anadirOpciones(String[] menu) {
        for (String opcion : menu)
            anadirOpcion(Main.listaOpciones.get(opcion));
    }

    public void anadirOpcion(OpcionDeMenu opcion) { opciones.add(opcion); }

    /* Se muestra el conjunto de opciones asociadas al correspondiente menu de
     * consola y se recibe entrada por parte del usuario (I/O) */
    void lanzarMenu() {
        String opcion = null;
        OpcionDeMenu[] arregloOpciones = opciones.toArray(new OpcionDeMenu[opciones.size()]);

        do {
            System.out.format(margen + "%-25s: " + Main.usuario.getNombre() + "%n%n%-25s%s%n", "Usuario",
                    "OPCIÓN",
                    "NÚMERO");

            // Temporal
            Main.mostrarUsuarios();

            for (byte i = -1; ++i < arregloOpciones.length; )
                System.out.format("%-25s%d%n", arregloOpciones[i], i + 1);

            if (opcion != null)
                System.out.println("\n\"" + opcion + "\" no corresponde a ningún número de opción válido.");

            System.out.print("\nIngrese el número de la opción a ejecutar: ");
        } while (!Pattern.compile("\\d+").matcher(opcion = entrada.next()).matches() || Integer.parseInt(opcion) < 1
                || Integer.parseInt(opcion) > arregloOpciones.length);

        arregloOpciones[Integer.parseInt(opcion) - 1].ejecutar();
    }

}
