package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Usuario;

import java.util.ArrayList;

public class CuentaDebito extends Cuenta {
    private float saldo;
    private ArrayList<Debito> debitos;
    private ArrayList<Cheque> cheques;

    public CuentaDebito(Usuario titular) { super(titular); }

    public float getSaldo() { return saldo; }

    public ArrayList<Cheque> getCheques() { return cheques; }

    public ArrayList<Debito> getDebitos() { return debitos; }

    public void retirar(float valor) {
        if (saldo - valor >= 0 && valor >= 0) {
            saldo -= valor;
            //se podria implementar un array par guardar los retiros o se podria manejar  como un debito?
        } else {
            System.out.println("valor incorrecto");
        }
    }

}
