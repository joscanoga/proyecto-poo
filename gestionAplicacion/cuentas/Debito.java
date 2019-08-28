package gestionAplicacion.cuentas;

//import uiMain.Main;
//import uiMain.OpcionDeMenu;

import java.io.Serializable;

import excepciones.ValorIncorrecto;

public class Debito implements Serializable {
    private final int id;
    private final float monto;
    private int vecesDebitado;
    private static int contador;
    private CuentaDebito cuenta;
//    private static final String[] menuDefectoDebito = new String[]{"RemoverDebito", "EfectuarDebito", "VerDebitos"};

    public Debito(float monto,CuentaDebito cuenta) {
        id = ++contador;
        this.cuenta=cuenta;
        this.monto = monto;
//        if (!OpcionDeMenu.tieneDebito) Main.usuario.getMenu().anadirOpciones(menuDefectoDebito);
    }

//    public void removerOpciones() {
//        if (OpcionDeMenu.tieneDebito) Main.usuario.getMenu().removerOpciones(menuDefectoDebito);
//    }

    public String toString() { return id + "," + monto + "," + vecesDebitado; }

    public void debitar() throws ValorIncorrecto { 
    	cuenta.retirar(monto);
    	vecesDebitado++; 
    }

    public int getId() { return id; }

    public float getMonto() { return monto; }

    public static int getContador() { return contador; }

    public static void setContador(int contador) { Debito.contador = contador; }

}
