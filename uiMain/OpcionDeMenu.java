package uiMain;

import gestionAplicacion.cuentas.CDT;
import gestionAplicacion.cuentas.CuentaCredito;
import gestionAplicacion.cuentas.CuentaDebito;

import java.io.Serializable;

public abstract class OpcionDeMenu implements Serializable, RecursosVarios {
    public static CuentaDebito cuentaDebito;
    public static CuentaCredito cuentaCredito;
    public static boolean tieneCDT, tieneDebito, tieneCheque, tieneCredito;

    protected abstract void ejecutar();

    protected boolean nombreExistente(String nombre) {
        return Main.usuarios.containsKey(nombre);
    }

    public boolean filtrarOpcionesCuentaDebito(String verbo) {
        if (cuentaDebito == null) {
            System.out.print(margen +
                    "Debes tener una cuenta débito para poder " + verbo + ".\n\nPresiona Enter para continuar");
            esperarEnter();
        }
        return cuentaDebito == null;
    }

    public boolean filtrarSaldoNulo(String verbo) {
        if (cuentaDebito.getSaldo() == 0) {
            System.out.print(margen + "El saldo de tú cuenta débito es 0, no puedes " + verbo + ".\n\nPresiona Enter " +
                    "para continuar.");
            esperarEnter();
        }
        return cuentaDebito.getSaldo() == 0;
    }

    public void cargarInfoUsuario() {
        setCuentaDebito();
        setCuentaCredito();
        setTieneCDT();
        setTieneDebito();
        setTieneCheque();
        setTieneCredito();
    }

    public void setCuentaDebito() {
        cuentaDebito = (CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas());
    }

    public void setCuentaCredito() {
        cuentaCredito = (CuentaCredito)buscarObjetoEn(CuentaCredito.class, Main.usuario.getCuentas());
    }

    public void setTieneCDT() { tieneCDT = buscarObjetoEn(CDT.class, Main.usuario.getCuentas()) != null; }

    public void setTieneDebito() {
        tieneDebito = cuentaDebito != null && !cuentaDebito.getDebitos().isEmpty();
    }

    public void setTieneCheque() {
        tieneCheque = cuentaDebito != null && !cuentaDebito.getCheques().isEmpty();
    }

    public void setTieneCredito() {
        tieneCredito = cuentaCredito != null && !cuentaCredito.getCreditos().isEmpty();
    }

}
