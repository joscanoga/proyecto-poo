package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

public class CuentaCredito extends Cuenta {
	private float deuda;
	private float cupo;
	private static float interes=(float) 2.5;
	private Credito[] creditos;
	
	public float getCupo() {return cupo;}
	public float getdeuda() {return deuda;}
	public float getIntereses() {return interes;}
	public Credito[] getCreditos(){return creditos;}
	
	public CuentaCredito(Usuario u) {
		super(u);
		deuda=0;
		cupo=1000000;
	}
	
}