package uiMain.menuConsola;

import gestionAplicacion.cuentas.CDT;
import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CrearCDT extends OpcionDeMenu {

    public void ejecutar() {
        CuentaDebito cuentaDebito;
        float monto = 0;
        int meses = 0;
        String mensajeError = null;

        if ((cuentaDebito = (CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas())) == null) {
            System.out.print(margen + "Debes tener una cuenta débito para poder crear un CDT." +
                    "\n\nPresiona Enter para continuar.");
        } else {
            if (cuentaDebito.getSaldo() == 0) {
                System.out.print(margen + "El saldo de tu cuenta débito es 0, no es posible crear un CDT" +
                        ".\n\nPresiona Enter para continuar.");
            } else {
                while (true) {
                    System.out.println(margen + "FORMULARIO DE CREACIÓN DE CTD.\n");

                    if (mensajeError != null) System.out.println(mensajeError + "\n");
                    mensajeError = null;

                    System.out.format("%-20s: " + (monto == 0 ? "" : quitarZeroDecimal(monto) + "%n"), "Monto");
                    if (monto == 0) {
                        if (entrada.hasNextFloat() && (monto = entrada.nextFloat()) <= 0 || monto > cuentaDebito.getSaldo()) {
                            mensajeError = "\"" + quitarZeroDecimal(monto) + "\" no es un valor válido para monto, " +
                                    "este debe de estar dentro del saldo de tu cuenta débito, mayor a 0 y máximo " +
                                    quitarZeroDecimal(cuentaDebito.getSaldo()) + ".";
                        } else if (monto == 0 && !entrada.hasNextFloat())
                            mensajeError = "El monto debe ser un valor numérico, \"" + entrada.next() + "\" no lo es.";

                        if (mensajeError != null) {
                            monto = 0;
                            continue;
                        }
                    }

                    System.out.format("%-20s: ", "Cantidad de meses");
                    if (entrada.hasNextInt() && (meses = entrada.nextInt()) <= 0)
                        mensajeError = "\"" + meses + "\" no es una cantidad de meses válido, debe ser mayor a 0.";
                    else if (meses == 0 && !entrada.hasNextInt())
                        mensajeError = "Los meses deben ser un número entero, \"" + entrada.next() + "\" no lo es.";
                    if (mensajeError != null) {
                        meses = 0;
                        continue;
                    }

                    break;
                }
                cuentaDebito.retirar(monto);
                Main.usuario.anadirCuenta(new CDT(Main.usuario, monto, meses));
                System.out.print(margen + "CDT creado exitosamente.\n\nPresiona Enter para " +
                        "continuar.");
            }
        }

        esperarEnter();
    }

    public String toString() { return "Crear CDT"; }
}