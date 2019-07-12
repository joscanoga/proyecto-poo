package gestionAplicacion.usuarios;

import gestionAplicacion.cuentas.Cuenta;
import uiMain.*;
import uiMain.menuConsola.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
	final private int id;
	private MenuDeConsola menu;
	private boolean esAdmin;
	private String nombreUsuario, contrasena, nombre;
	static private int contador;
	private ArrayList<Cuenta> cuentas;

	final MenuDeConsola menuDefectoInvitado = new MenuDeConsola(
			new OpcionDeMenu[] { new Registrarse(), new IniciarSesion() }),
			menuDefectoAdmin = new MenuDeConsola(new OpcionDeMenu[] { new CambiarContrasena(), new CerrarSesion(),
					new AnadirOpcion(), new RemoverOpcion(), new VerTodasLasOpciones(), new VerOpcionesDeUnUsuario() }),
			menuDefectoRegistrado = new MenuDeConsola(
					new OpcionDeMenu[] { new CambiarContrasena(), new CerrarSesion(), new CrearCDT(),
							new CrearCuentaCredito(), new CrearCuentaDebito(), new ManejarCuenta(), new VerCuentas() });

	// Los invitados serán los usuarios que se crean con el constructor por defecto
	public Usuario() {
		id = contador++;
		menu = menuDefectoInvitado;
		nombre = "Invitado" + id;
	}

	// Constructor para usuarios de tipo administrador y registrado
	public Usuario(boolean esAdmin, String nombreUsuario, String contrasena, String nombre) {
		id = contador++;
		this.esAdmin = esAdmin;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.nombre = nombre;

		if (esAdmin)
			menu = menuDefectoAdmin;
		else
			menu = menuDefectoRegistrado;
	}

	public int getId() {
		return id;
	}

	public MenuDeConsola getMenu() {
		return menu;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public static int getContador() {
		return contador;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	// Temporal
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", esAdmin=" + esAdmin + ", nombreUsuario=" + nombreUsuario + ", contrasena="
				+ contrasena + ", nombre=" + nombre + "]";
	}

}
