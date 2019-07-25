package uiMain;

import BaseDatos.Serializador;
import gestionAplicacion.usuarios.Usuario;
import uiMain.menuConsola.*;

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static final HashMap<String, OpcionDeMenu> listaOpciones = new HashMap<>() {{
        put("AnadirOpcion", new AnadirOpcion());
        put("CambiarContrasena", new CambiarContrasena());
        put("CerrarSesion", new CerrarSesion());
        put("Contactenos", new Contactenos());
        put("CrearCDT", new CrearCDT());
        put("CrearCuentaCredito", new CrearCuentaCredito());
        put("CrearCuentaDebito", new CrearCuentaDebito());
        put("IniciarSesion", new IniciarSesion());
        put("Registrarse", new Registrarse());
        put("RemoverOpcion", new RemoverOpcion());
        put("SalirDeLaAplicacion", new SalirDeLaAplicacion());
        put("VerCuentas", new VerCuentas());
        put("VerOpcionesDeUnUsuario", new VerOpcionesDeUnUsuario());
        put("VerTodasLasOpciones", new VerTodasLasOpciones());
        put("Consignar", new Consignar());
        put("Retirar", new Retirar());
        put("Transferir", new Transferir());
        put("LibrarCheque", new LibrarCheque());
        put("AnadirDebito", new AnadirDebito());
        put("VerCheques", new VerCheques());
        put("CobrarCheque", new CobrarCheque());
        put("RemoverDebito", new RemoverDebito());
        put("VerDebitos", new VerDebitos());
        put("EfectuarDebito", new EfectuarDebito());
        put("AnadirCredito", new AnadirCredito());
        put("VerCreditos", new VerCreditos());
        put("PagarCuotaCredito", new PagarCuotaCredito());
        put("PagoParcialCredito", new PagoParcialCredito());
        put("TranscurrirMesesEnCDT", new TranscurrirMesesEnCDT());
        put("VerUsuarios", new VerUsuarios());
        put("NombrarNuevoAdministrador", new NombrarNuevoAdministrador());

    }},
            opcionesAdmin = new HashMap<>() {{
                put("AnadirOpcion", new AnadirOpcion());
                put("CambiarContrasena", new CambiarContrasena());
                put("CerrarSesion", new CerrarSesion());
                put("Contactenos", new Contactenos());
                put("IniciarSesion", new IniciarSesion());
                put("Registrarse", new Registrarse());
                put("RemoverOpcion", new RemoverOpcion());
                put("SalirDeLaAplicacion", new SalirDeLaAplicacion());
                put("VerOpcionesDeUnUsuario", new VerOpcionesDeUnUsuario());
                put("VerTodasLasOpciones", new VerTodasLasOpciones());
                put("VerUsuarios", new VerUsuarios());
            }};
    ;
    public static HashMap<String, Usuario> usuarios;
    public static Usuario usuario = new Usuario();

    public static void main(String[] args) throws IOException {
        // Todos los usuarios y administradores registrados en la base de datos
        usuarios = Serializador.cargar();

        // Crear administrador
        // usuarios.put("a", new Usuario(true, "a", "a", "Administrador"));

        while (true) usuario.getMenu().lanzarMenu();
    }

}