package gestionAplicacion.cuentas;
import gestionAplicacion.usuarios.*;


public class cuentaCredito extends cuenta {
	private float deuda;
	private float cupo;
	private static float interes=(float) 2.5;
	private Credito[] creditos;
	
	public float getCupo() {return cupo;}
	public float getdeuda() {return deuda;}
	public float getIntereses() {return interes;}
	public Credito[] getCreditos(){return creditos;}
	
	public  String toString() {return("esto es una cuenta credito ");}
	public cuentaCredito(usuario u) {
		super(u);
		deuda=0;
		cupo=1000000;
	}
	
}