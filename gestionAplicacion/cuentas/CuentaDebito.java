package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;
import gestionAplicacion.cuentas.*;

public class CuentaDebito extends Cuenta {
	private float saldo;
	private Debito[] Debitos;
	private Cheque[] Cheques;
	protected CuentaDebito(Usuario titu,float saldoInicial) {
		super(titu);
		saldo=saldoInicial;
	}
	protected CuentaDebito(Usuario titu) {
		this(titu,0);
	}
	public float getSaldo() {return saldo;}
	public Cheque[] getCheques() {return Cheques;}
	public Debito[] getDebitos() {return Debitos;}
	public void retirar(float valor) {
	if(saldo-valor>=0&&valor>=0) {
		saldo-=valor;
		//se podria implementar un array par guardar los retiros o se podria manejar  como un debito?
		}
	else {
		System.out.println("valor incorrecto");
	}
	}
	

}
