
package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.UsuarioRegistrado;

public abstract class Cuenta {
	private String id;
	private UsuarioRegistrado titular;
	protected  String getid() {
		return(id);
	}
	protected UsuarioRegistrado getTitular() {
		return titular;
	}
	
	public abstract String toString();

}