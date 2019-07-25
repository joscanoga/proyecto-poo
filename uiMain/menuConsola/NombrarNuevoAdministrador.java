package uiMain.menuConsola;

import gestionAplicacion.usuarios.Usuario;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class NombrarNuevoAdministrador extends OpcionDeMenu {

    public void ejecutar() {
        String textoError = null, nombre;
        Usuario usuario;
        while (true) {
            System.out.print(margen + "NOMBRAR NUEVO ADMINISTRADOR\n\n" + (textoError != null ? textoError + "\n\n" :
                    ""));
            System.out.format("%-20s: ", "Nombre de usuario");
            if (!Main.usuarios.containsKey(nombre = entrada.next()))
                textoError = "El usuario de nombre \"" + nombre + "\" no se está registrado.";
            else if (Main.usuarios.get(nombre).getEsAdmin())
                textoError = "El usuario \"" + nombre + "\" ya es administrador.";
            else break;
        }

        usuario = Main.usuarios.get(nombre);

        Main.usuarios.put(nombre, new Usuario(true, usuario.getNombreUsuario(), usuario.getContrasena(),
                usuario.getNombre()));

        System.out.print("\nEl usuario \"" + nombre + "\" fue promovido a administrador. Su opciones " +
                "fueron actualizadas y toda su información comercial descartada.\n\nPresiona Enter para continuar.");
        esperarEnter();
    }

    public String toString() {
        System.out.println("Nombrar un nuevo");
        return "administrador";
    }

}