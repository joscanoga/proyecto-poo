package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

import java.util.ArrayList;

public class CuentaDebito extends Cuenta {
    private float saldo;
    private ArrayList<Debito> debitos = new ArrayList<>();
    private ArrayList<Cheque> cheques = new ArrayList<>();

    public CuentaDebito(Usuario titular) { super(titular); }

    public float getSaldo() { return saldo; }

    public ArrayList<Cheque> getCheques() { return cheques; }

    public ArrayList<Debito> getDebitos() { return debitos; }

    public void retirar(float valor) { saldo -= valor; }

}
