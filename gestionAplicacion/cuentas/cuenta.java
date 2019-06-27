
package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.usuarioRegistrado;

public abstract class cuenta {
	private String id;
	private usuarioRegistrado titular;
	protected  String getid() {
		return(id);
	}
	protected usuarioRegistrado getTitular() {
		return(titular);
	}
	
	public abstract String toString();

}
public class cuentaCredito extends cuenta {
	protected usuarioRegistrado getTitular() {};
	public  String toString() {return(" ");}
}
