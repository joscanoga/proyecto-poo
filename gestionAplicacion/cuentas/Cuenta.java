
package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

public abstract class Cuenta {
	private int id;
	private Usuario titular;
	static int numeroCuentas;
	protected  int getid() {
		return(id);
	}
	protected Usuario getTitular() {
		return(titular);
	}
	
	protected Cuenta(Usuario titu) {
		numeroCuentas++;
		id=numeroCuentas;
		titular=titu;
	}
	
}