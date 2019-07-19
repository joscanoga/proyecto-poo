package gestionAplicacion.cuentas;
import java.util.*;
import gestionAplicacion.usuarios.Usuario;


public class CuentaDebito extends Cuenta {
	private float saldo;
	//private Debito[] Debitos;
	private ArrayList<Debito> Debitos = new ArrayList<Debito>();
	//private Cheque[] Cheques;
	private ArrayList<Cheque> Cheques = new ArrayList<Cheque>();
	protected CuentaDebito(Usuario titu,float saldoInicial) {
		super(titu);
		saldo=saldoInicial;
	}
	protected CuentaDebito(Usuario titu) {
		this(titu,0);
	}
	public float getSaldo() {return saldo;}
	public ArrayList<Cheque> getCheques() {return Cheques;}
	public ArrayList<Debito> getDebitos() {return Debitos;}
	public void retirar(float valor) {
	if(saldo-valor>=0&&valor>=0) {
		saldo-=valor;
		//se podria implementar un array par guardar los retiros o se podria manejar  como un debito?
		}
	else {
		System.out.println("valor incorrecto");
	}
	
	}
	public void consignar (float valor) {
		saldo+=valor;
	}
	public void transferir(CuentaDebito destino,float valor) {
		this.retirar(valor);
		destino.consignar(valor);
	}
	public void añadirCheque(Cheque ch) {Cheques.add(ch);}
	public void removerCheque(int id) {
		
		 Iterator<Cheque> it =Cheques.iterator();
		 while(it.hasNext()) {
			 Cheque e=it.next();
			 if(e.getId()==id) {
				 Cheques.remove(Cheques.indexOf(e));
				 break;
			 }
		 }
	}
	public void añadirDebito(Debito d) {Debitos.add(d);}
	public void removerDebito(int id) {
		 Iterator<Debito> it =Debitos.iterator();
		 while(it.hasNext()) {
			 Debito e=it.next();
			 if(e.getId()==id) {
				 Debitos.remove(Debitos.indexOf(e));
				 break;
			 }
	}

	}
}
