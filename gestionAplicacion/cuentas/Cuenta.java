
package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

public abstract class Cuenta {
	private int id;
	private Usuario titular;
	static int numeroCuentas;
	
	protected Usuario getTitular() {
		return(titular);
	}
	
	
	protected Cuenta(Usuario titu) {
		numeroCuentas++;
		id=numeroCuentas;
		titular=titu;
	}
	public int getNumeroCuentas() {return numeroCuentas;}
	public int getId() {return(id);}
	
	
	
}