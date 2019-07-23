package uiMain.menuConsola;

import gestionAplicacion.cuentas.Cuenta;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class VerCuentas extends OpcionDeMenu {

    public void ejecutar() {
        if (Main.usuario.getCuentas().isEmpty())
            System.out.println(margen + "No tienes cuentas para mostrar.");
        else {
            // textoCuentas = {textoCuentasDébito, textoCuentasCrédito, textoCDTs}
            String[] infoCuenta, textoCuentas = {null, null, null};

            for (Cuenta cuenta : Main.usuario.getCuentas()) {
                infoCuenta = cuenta.toString().split(",");
                if (infoCuenta[1].equals("Cuenta débito"))
                    textoCuentas[0] = ",,SALDO,N�MERO DE CHEQUES,N�MERO DE D�BITOS-" + cuenta + "-";
                else if (infoCuenta[1].equals("CDT")) {
                    if (textoCuentas[2] == null)
                        textoCuentas[2] = ",,MONTO INICIAL,MONTO ACTUAL,TASA DE INCREMENTO,PLAZO INICIAL," +
                                "MESES TRANSCURRIDOS-";
                    textoCuentas[2] += cuenta + "-";
                } else textoCuentas[1] = ",,DEUDA TOTAL,CUPO CREDITICIO,INTER�S,N�MERO DE CR�DITOS-" + cuenta +
                        "-";
            }

            System.out.format(margen + "%-20s%-20s%n", "N�MERO DE CUENTA", "TIPO DE CUENTA");
            for (String textoCuenta : textoCuentas) {
                if (textoCuenta != null) {
                    for (String cuenta : textoCuenta.split("-")) {
                        if (cuenta.length() == 1) continue;

                        for (String campo : cuenta.split(",")) System.out.format("%-20s", campo);
                        System.out.println();

                    }

                    System.out.println();
                }
            }
        }

        System.out.print("Presiona Enter para continuar.");
        esperarEnter();
    }

    public String toString() { return "Ver cuentas"; }

}