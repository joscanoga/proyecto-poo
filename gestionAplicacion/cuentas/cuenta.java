
package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.usuario;

public abstract class cuenta {
	private int id;
	private usuario titular;
	static int numeroCuentas;
	protected  int getid() {
		return(id);
	}
	protected usuario getTitular() {
		return(titular);
	}
	
	public abstract String toString();
	protected cuenta(usuario titu) {
		numeroCuentas++;
		id=numeroCuentas;
		titular=titu;
	}
	
}