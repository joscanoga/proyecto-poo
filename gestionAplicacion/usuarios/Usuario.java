package gestionAplicacion.usuarios;

import gestionAplicacion.cuentas.Cuenta;
import uiMain.MenuDeConsola;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private final int id;
    private MenuDeConsola menu;
    private boolean esAdmin;
    private String nombreUsuario, contrasena, nombre;
    private static int contador;
    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    public final static MenuDeConsola menuDefectoInvitado = new MenuDeConsola(new String[]{"Registrarse",
            "IniciarSesion"}),
            menuDefectoAdmin = new MenuDeConsola(new String[]{"CerrarSesion", "CambiarContrasena", "AnadirOpcion",
                    "RemoverOpcion", "VerTodasLasOpciones", "VerOpcionesDeUnUsuario"}),
            menuDefectoRegistrado = new MenuDeConsola(new String[]{"CerrarSesion", "CambiarContrasena", "CrearCDT",
                    "CrearCuentaCredito", "CrearCuentaDebito", "ManejarCuenta", "VerCuentas"});

    // Los invitados serán los usuarios que se crean con el constructor por defecto
    public Usuario() {
        id = 0;
        menu = menuDefectoInvitado;
        nombre = "Invitado";
    }

    // Constructor para usuarios de tipo administrador y registrado
    public Usuario(boolean esAdmin, String nombreUsuario, String contrasena, String nombre) {
        id = ++contador;
        this.esAdmin = esAdmin;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;

        if (esAdmin) menu = menuDefectoAdmin;
        else menu = menuDefectoRegistrado;
    }

    public int getId() { return id; }

    public MenuDeConsola getMenu() { return menu; }

    public boolean isEsAdmin() { return esAdmin; }

    public String getNombreUsuario() { return nombreUsuario; }

    public String getContrasena() { return contrasena; }

    public String getNombre() { return nombre; }

    public static int getContador() { return contador; }

    public ArrayList<Cuenta> getCuentas() { return cuentas; }

    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public static void setContador(int cont) { contador = cont; }

    // Temporal
    @Override
    public String toString() {
        return "\nid=" + id + ", esAdmin=" + esAdmin + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena +
                ", nombre=" + nombre + ", contador=" + contador + ", cuentas " +
                "=" + cuentas;
    }

    public void anadirCuenta(Cuenta cuenta) {
        System.out.println(cuentas);
        cuentas.add(cuenta);
    }
}
