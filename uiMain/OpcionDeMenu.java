package uiMain;

import gestionAplicacion.cuentas.CDT;
import gestionAplicacion.cuentas.Cheque;
import gestionAplicacion.cuentas.CuentaCredito;
import gestionAplicacion.cuentas.CuentaDebito;

import java.io.Serializable;

public abstract class OpcionDeMenu implements Serializable, RecursosVarios {
    public static CuentaDebito cuentaDebito;
    public static CuentaCredito cuentaCredito;
    public static boolean tieneCDT, tieneDebito, tieneCheque, tieneCredito, chequesPorCobrar;

    protected abstract void ejecutar();

    protected boolean nombreExistente(String nombre) {
        return Main.usuarios.containsKey(nombre);
    }


    public boolean filtrarOpcionesCuentaCredito(String verbo) {
        if (cuentaCredito == null) {
            System.out.print(margen +
                    "Debes tener una cuenta crédito para poder " + verbo + ".\n\nPresiona Enter para continuar");
            esperarEnter();
        }
        return cuentaCredito == null;
    }

    public boolean filtrarCupoNulo(String verbo) {
        if (cuentaCredito.getCupo() == 0) {
            System.out.print(margen + "El cupo de tu cuenta crédito es 0, no puedes " + verbo + ".\n\nPresiona Enter " +
                    "para continuar.");
            esperarEnter();
        }
        return cuentaCredito.getCupo() == 0;
    }

    public boolean filtrarOpcionesCuentaDebito(String verbo) {
        if (cuentaDebito == null) {
            System.out.print(margen +
                    "Debes tener una cuenta débito para poder " + verbo + ".\n\nPresiona Enter para continuar");
            esperarEnter();
        }
        return cuentaDebito == null;
    }

    public boolean filtrarOpcionesCDT(String verbo) {
        if (!tieneCDT) {
            System.out.print(margen +
                    "Debes tener un CDT para poder " + verbo + ".\n\nPresiona Enter para continuar");
            esperarEnter();
        }
        return !tieneCDT;
    }

    public boolean filtrarSaldoNulo(String verbo) {
        if (cuentaDebito.getSaldo() == 0) {
            System.out.print(margen + "El saldo de tú cuenta débito es 0, no puedes " + verbo + ".\n\nPresiona Enter " +
                    "para continuar.");
            esperarEnter();
        }
        return cuentaDebito.getSaldo() == 0;
    }

    public boolean filtrarOpcionesCheque(String verbo) {
        if (!tieneCheque) {
            System.out.print(margen + "No tienes cheques para " + verbo + ".\n\nPresiona Enter " +
                    "para continuar.");
            esperarEnter();
        }
        return !tieneCheque;
    }

    public boolean filtrarOpcionesDebito(String verbo) {
        if (!tieneDebito) {
            System.out.print(margen + "No tienes débitos para " + verbo + ".\n\nPresiona Enter " +
                    "para continuar.");
            esperarEnter();
        }
        return !tieneDebito;
    }

    public boolean filtrarOpcionesCredito(String verbo) {
        if (!tieneCredito) {
            System.out.println(margen + "No tienes créditos para " + verbo + ".\n\nPresiona Enter " +
                    "para continuar.");
        }
        return !tieneCredito;
    }

    public void cargarInfoUsuario() {
        setCuentaDebito();
        setCuentaCredito();
        setTieneCDT();
        setTieneDebito();
        setTieneCheque();
        setTieneCredito();
        setChequesPorCobrar();
    }

    public void setCuentaDebito() {
        cuentaDebito = (CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas());
    }

    public void setCuentaCredito() {
        cuentaCredito = (CuentaCredito)buscarObjetoEn(CuentaCredito.class, Main.usuario.getCuentas());
    }

    public void setTieneCDT() { tieneCDT = buscarObjetoEn(CDT.class, Main.usuario.getCuentas()) != null; }

    public void setTieneCredito() {
        tieneCredito = cuentaCredito != null && !cuentaCredito.getCreditos().isEmpty();
    }

    public void setTieneDebito() {
        tieneDebito = cuentaDebito != null && !cuentaDebito.getDebitos().isEmpty();
    }

    public void setTieneCheque() {
        tieneCheque = cuentaDebito != null && !cuentaDebito.getCheques().isEmpty();
    }

    public void setChequesPorCobrar() {
        if (cuentaDebito == null) chequesPorCobrar = false;
        else {
            for (Cheque cheque : cuentaDebito.getCheques()) {
                if (!cheque.getCobrado()) {
                    chequesPorCobrar = true;
                    return;
                }
            }
            chequesPorCobrar = false;
        }
    }

}
