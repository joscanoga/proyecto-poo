package gestionAplicacion.cuentas;

import gestionAplicacion.usuarios.Cliente;
import gestionAplicacion.usuarios.Usuario;

import java.util.ArrayList;

import excepciones.IdNoValido;
import excepciones.ValorIncorrecto;

public class CuentaCredito extends Cuenta {
    private float deuda;
    private float cupo = 1000000;
    private static float interes = (float)2.5;
    private ArrayList<Credito> creditos = new ArrayList<>();
    private  CuentaDebito cuentaDebito;

//    private static final String[] menuDefectoCuentasCredito = new String[]{"AnadirCredito"};

    public CuentaCredito(Cliente titular,CuentaDebito cuentaDebito) {
        super(titular);
        this.cuentaDebito=cuentaDebito;
//        titular.getMenu().anadirOpciones(menuDefectoCuentasCredito);
    }

    public String toString() {
        return id + ",Cuenta crédito," + deuda + "," + cupo + "," + interes + "%," + creditos.size();
    }

    public void anadirCredito(Credito credito) { creditos.add(credito); }

    public void removerCredito(int id) throws IdNoValido{
        int contador = 0;
        boolean removido=false;
        for (Credito credito : creditos) {
            if (credito.getId() == id) {
                creditos.remove(contador);
                break;
            }
            contador++;
        }
        if(!removido) {throw new IdNoValido();}
    }

    public float getDeuda() { return deuda; }

    public float getCupo() { return cupo; }
    public void setCupo(int cupo) {this.cupo=cupo;}

    public float getInteres() { return interes; }
    public void setInteres(int interes) {this.interes=interes;}

    public ArrayList<Credito> getCreditos() { return creditos; }

    public void aumentarCupo(float valor) { cupo += valor; }

    public void disminuirCupo(float valor) { cupo -= valor; }

    public void aumentarDeuda(float valor) { deuda += valor; }

    public void disminuirDeuda(float valor) { deuda -= valor; }
    public void avanceCuentaDebito(float valor)throws ValorIncorrecto {
    	if(cupo>=valor) {
    		anadirCredito(new Credito(this.titular,valor,18,this,this.cuentaDebito));
    	}else{throw new ValorIncorrecto();}//setrata en otra parte
    }


}