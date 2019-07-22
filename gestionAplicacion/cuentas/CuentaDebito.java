package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

import java.util.ArrayList;


public class CuentaDebito extends Cuenta {
    private float saldo;
    private ArrayList<Debito> debitos = new ArrayList<>();
    private ArrayList<Cheque> cheques = new ArrayList<>();

    private static final String[] menuDefectoCuentasDebito = new String[]{"Consignar", "Retirar", "Transferir",
            "LibrarCheque", "AnadirDebito"};

    public CuentaDebito(Usuario titular) {
        super(titular);
        titular.getMenu().anadirOpciones(menuDefectoCuentasDebito);
    }

    public void retirar(float valor) { saldo -= valor; }

    public void consignar(float valor) {
        saldo += valor;
    }

    public void transferir(CuentaDebito destino, float valor) {
        this.retirar(valor);
        destino.consignar(valor);
    }

    public void anadirCheque(Cheque cheque) { cheques.add(cheque); }

    public void anadirDebito(Debito debito) { debitos.add(debito); }

    public void removerDebito(int id) {
        int contador = 0;
        for (Debito debito : debitos) {
            if (debito.getId() == id) {
                debito.removerOpciones();
                debitos.remove(contador);
                return;
            }
            contador++;
        }

    }

    public void abonarCredito(Credito c, Float valor) {
        this.retirar(valor);
        c.pagarParcial(valor);
    }

    public String toString() {
        return id + ",Cuenta débito," + saldo + "," + cheques.size() + "," + debitos.size();
    }

    public float getSaldo() { return saldo; }

    public ArrayList<Cheque> getCheques() { return cheques; }

    public ArrayList<Debito> getDebitos() { return debitos; }

    public void setSaldo(float saldo) { this.saldo = saldo; }
}
