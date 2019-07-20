package uiMain.menuConsola;

import gestionAplicacion.cuentas.CDT;
import gestionAplicacion.cuentas.Cuenta;
import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CrearCDT implements OpcionDeMenu {

    public void ejecutar() {
        CuentaDebito cuentaDebito = null;
        float monto = 0;
        int meses = 0;
        String mensajeError = null;

        if ((cuentaDebito = (CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas())) == null) {
            System.out.print(margen + "Debes tener una cuenta débito para poder crear un CDT." +
                    "\n\nPresiona Enter para continuar.");
        } else {
            if (cuentaDebito.getSaldo() == 0) {
                System.out.print(margen + "El saldo de tu cuenta débito es 0, no es posible Crear un CDT." +
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

                    System.out.format("%-20s: " + (meses == 0 ? "" : meses), "Cantidad de meses");
                    if (meses == 0) {
                        if (entrada.hasNextInt() && (meses = entrada.nextInt()) <= 0)
                            mensajeError = "\"" + meses + "\" no es una cantidad de meses válido, debe ser mayor a 0.";
                        else if (meses == 0 && !entrada.hasNextInt())
                            mensajeError = "La los meses deben ser un número entero, \"" + entrada.next() + "\" no lo" +
                                    " " +
                                    "es.";
                        if (mensajeError != null) {
                            meses = 0;
                            continue;
                        }
                    }

                    break;
                }
                Main.usuario.anadirCuenta(new CDT(Main.usuario, monto, meses));
                System.out.print(margen + "Cuenta crédito creada exitosamente.\n\nPresiona Enter para " +
                        "continuar.");
            }
            entrada.nextLine();
        }

        entrada.nextLine();
    }

    public String toString() { return "Crear CDT"; }
}