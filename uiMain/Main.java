package uiMain;

import gestionAplicacion.usuarios.Usuario;
import uiMain.menuConsola.*;
import BaseDatos.Serializador;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static final HashMap<String, OpcionDeMenu> listaOpciones = new HashMap<String, OpcionDeMenu>() {{
        put("AnadirOpcion", new AnadirOpcion());
        put("CambiarContrasena", new CambiarContrasena());
        put("CerrarSesion", new CerrarSesion());
        put("Contactenos", new Contactenos());
        put("CrearCDT", new CrearCDT());
        put("CrearCuentaCredito", new CrearCuentaCredito());
        put("CrearCuentaDebito", new CrearCuentaDebito());
        put("IniciarSesion", new IniciarSesion());
        put("ManejarCuenta", new ManejarCuenta());
        put("Registrarse", new Registrarse());
        put("RemoverOpcion", new RemoverOpcion());
        put("SalirDeLaAplicacion", new SalirDeLaAplicacion());
        put("VerCuentas", new VerCuentas());
        put("VerOpcionesDeUnUsuario", new VerOpcionesDeUnUsuario());
        put("VerTodasLasOpciones", new VerTodasLasOpciones());
        put("Consignar", new Consignar());
        put("Retirar", new Retirar());
        put("Transferir", new Transferir());
        put("DiligenciarCheque", new DiligenciarCheque());
        put("CrearDebito", new CrearDebito());
        put("DescartarDebito", new DescartarDebito());
    }};
    public static Usuario usuario;
    public static HashMap<String, Usuario> usuarios;

    public static void main(String[] args) throws IOException {
        // Todos los usuarios y administradores registrados en la base de datos
        usuarios = Serializador.cargar();
        definirInvitado();
        
            usuario.getMenu().encabezado();

        for (;;)
            usuario.getMenu().lanzarMenu();
    }

    public static final void definirInvitado() { usuario = new Usuario(); }

    // Temporal
    public static final void mostrarUsuarios() {
        for (Usuario user : usuarios.values()) System.out.println(user);
        System.out.println();
    }
}