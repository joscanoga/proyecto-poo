package gestionAplicacion.cuentas;

import uiMain.Main;
import uiMain.OpcionDeMenu;

import java.io.Serializable;

public class Debito implements Serializable {
    private final int id;
    private final float monto;
    private int vecesDebitado;
    private static int contador;
    private static final String[] menuDefectoDebito = new String[]{"RemoverDebito", "EfectuarDebito", "VerDebitos"};

    public Debito(float monto) {
        id = ++contador;
        this.monto = monto;
        if (!OpcionDeMenu.tieneDebito) Main.usuario.getMenu().anadirOpciones(menuDefectoDebito);
    }

    public void removerOpciones() {
        if (OpcionDeMenu.tieneDebito) Main.usuario.getMenu().removerOpciones(menuDefectoDebito);
    }

    public String toString() { return id + "," + monto + "," + vecesDebitado; }

    public void debitar() { vecesDebitado++; }

    public int getId() { return id; }

    public float getMonto() { return monto; }

    public static int getContador() { return contador; }

    public static void setContador(int contador) { Debito.contador = contador; }

}
