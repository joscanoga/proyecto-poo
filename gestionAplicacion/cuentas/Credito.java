package gestionAplicacion.cuentas;

public class Credito {
	private int id;
private CuentaCredito cuentaAsociada;
	private float monto;
	private float montoPendiente;//ver si se puede agregar al uml
	private float  valorCuota;//agregar uml
	int cuotas;
	private static int numeroCreditos;
	public float getId() {return id;}
	public CuentaCredito getCuentaAsociada() {return cuentaAsociada;}
	public int getCuotas() {return cuotas;}
	public int getnumerocreditos() {return numeroCreditos;}
	public float getMonto() {return monto;}
	Credito (CuentaCredito c,float m,int cu){
		//implementar try 2 trabajo
		cuentaAsociada=c;
		numeroCreditos++;
		id=numeroCreditos;
		int intereses=0;
		cuotas=cu;
		float cuo=monto/cuotas;
		if (c.getCupo()>=monto&&monto>0) {
			monto=m;
			for (int i=1;i<= cu;i++) {intereses+=cuentaAsociada.getIntereses()*(monto-(i-1)*cuo);}
			montoPendiente=monto+intereses;
		 valorCuota=montoPendiente/cuotas;
			
		}
	}
	
	
}
