package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

public class Cdt extends Cuenta{
	private int meses;
	private float monto;
	final private float tasa;
	private boolean activo;

	protected Cdt(Usuario titu,float mon,int  mes,float tas) {
		super(titu);
		meses=mes;
		monto=mon;
		tasa=tas;
		activo=true;	
	}
	public int getPlazoMeses() {return meses;}
	public float getMonto() {return monto;}
	public float getTasa() {return tasa;}
	public boolean getActivo() {return activo;}
	public void renovar(int mes) {meses+=mes;}
	public void transcurirMeses(int mes) {
		for (int i=0;i<mes;i++) {
			if (meses>0) {
				monto*=(1+tasa);
				meses--;
			}else {System.out.println("los meses se han transcurido,requiere renovar");break;}
		}
	}

}
