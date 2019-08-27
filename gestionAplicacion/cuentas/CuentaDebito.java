package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Cliente;
import gestionAplicacion.usuarios.Usuario;

import java.util.ArrayList;

import excepciones.IdNoValido;
import excepciones.ValorIncorrecto;


public class CuentaDebito extends Cuenta {
    private float saldo=0;
    private ArrayList<Debito> debitos = new ArrayList<>();
    private ArrayList<Cheque> cheques = new ArrayList<>();

    private static final String[] menuDefectoCuentasDebito = new String[]{"Consignar", "Retirar", "Transferir",
            "LibrarCheque", "AnadirDebito"};

    public CuentaDebito(Cliente titular) {
        super(titular);
//        titular.getMenu().anadirOpciones(menuDefectoCuentasDebito);
    }

    public void retirar(float valor) throws ValorIncorrecto { if(saldo>valor) {saldo -= valor;}
    else throw new ValorIncorrecto();}

    public void consignar(float valor) {
        saldo += valor;
    }

    public void transferir(CuentaDebito destino, float valor) throws ValorIncorrecto{
        this.retirar(valor);
        destino.consignar(valor);
    }

    public void anadirCheque(Cheque cheque) { cheques.add(cheque); }

    public void anadirDebito(Debito debito) { debitos.add(debito); }

    public void removerDebito(int id) {
        int contador = 0;
        for (Debito debito : debitos) {
            if (debito.getId() == id) {
//                debito.removerOpciones();
                debitos.remove(contador);
                return;
            }
            contador++;
        }
    }

    public void abonarCredito(Credito credito, Float valor) throws ValorIncorrecto{
        this.retirar(valor);
        credito.pagarParcial(valor);
    }

    public String toString() {
        return id + ",Cuenta débito," + saldo + "," + cheques.size() + "," + debitos.size();
    }

    public float getSaldo() { return saldo; }

    public ArrayList<Cheque> getCheques() { return cheques; }

    public ArrayList<Debito> getDebitos() { return debitos; }

    public void setSaldo(float saldo) { this.saldo = saldo; }
    public void removerCheque(int id)throws IdNoValido {
    	boolean removido=false;
    	for (Cheque cheque : cheques) {
    		if (cheque.getId()==id){cheques.remove(cheque);
    		removido=true;}	}
    	if(!removido) {throw new IdNoValido();}
    }
}
