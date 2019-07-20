package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Iterator;


public class CuentaDebito extends Cuenta {
    private float saldo = 20;
    private ArrayList<Debito> debitos = new ArrayList<>();
    private ArrayList<Cheque> cheques = new ArrayList<>();

    public CuentaDebito(Usuario titular) { super(titular); }

    public float getSaldo() { return saldo; }

    public ArrayList<Cheque> getCheques() { return cheques; }

    public ArrayList<Debito> getDebitos() { return debitos; }

    public void retirar(float valor) { saldo -= valor; }

    public void consignar(float valor) {
        saldo += valor;
    }

    public void transferir(CuentaDebito destino, float valor) {
        this.retirar(valor);
        destino.consignar(valor);
    }

    public void anadirCheque(Cheque cheque) { cheques.add(cheque); }

    public void removerCheque(int id) {
        Iterator<Cheque> it = cheques.iterator();
        while (it.hasNext()) {
            Cheque e = it.next();
            if (e.getId() == id) {
                cheques.remove(cheques.indexOf(e));
                break;
            }
        }
    }

    public void anadirDebito(Debito debito) { debitos.add(debito); }

    public void removerDebito(int id) {
        Iterator<Debito> it = debitos.iterator();
        while (it.hasNext()) {
            Debito e = it.next();
            if (e.getId() == id) {
                debitos.remove(debitos.indexOf(e));
                break;
            }
        }

    }
    public void abonarCredito(Credito c,Float valor) {
    	this.retirar(valor);
    	c.pagarParcial(valor);}
    

}
