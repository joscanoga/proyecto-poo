package uiMain.menuConsola;

import gestionAplicacion.cuentas.CuentaDebito;
import gestionAplicacion.usuarios.Usuario;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class Transferir extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, monto = null, numCuenta;
        CuentaDebito cuentaDestino = null,
                cuentaDebito = (CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas());

        if (cuentaDebito == null) {
            System.out.print(margen +
                    "Debes poseer una cuenta débito para poder transferir.\n\nPresiona Enter para continuar");
            esperarEnter();
            return;
        }

        float valorMonto = 0,
                saldo = ((CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas())).getSaldo();

        while (true) {
            System.out.println(margen + "FORMULARIO DE TRANSFERENCIA\n");
            if (textoError != null) System.out.println(textoError + "\n");
            System.out.format("Valor de la%n%-20s: " + (monto != null ? valorMonto + "%n" : ""), "transferencia");
            if (monto == null) {
                if (!esNumerico(monto = entrada.next(), "float")) {
                    textoError = "El valor de la transferencia debe ser un valor numérico, \"" + monto + "\" no lo es.";
                    monto = null;
                    continue;
                }

                valorMonto = Float.parseFloat(monto);
                if (valorMonto <= 0 || valorMonto > saldo) {
                    textoError = "El valor de la transferencia debe ser mayor a 0 y máximo " + quitarZeroDecimal(saldo);
                    monto = null;
                    continue;
                }
            }


            System.out.format("Número de la%n%-20s: ", "cuenta destino");
            if (!esNumerico(numCuenta = entrada.next(), "float")) {
                textoError = "\"" + numCuenta + "\" no es un número válido en el número de la cuenta.";
                continue;
            }

            for (Usuario usuario : Main.usuarios.values()) {
                if ((cuentaDestino = (CuentaDebito)buscarObjetoEn(CuentaDebito.class, usuario.getCuentas())) != null) {
                    if (cuentaDestino.getId() == Float.parseFloat(numCuenta)) break;
                    cuentaDestino = null;
                }
            }

            if (cuentaDestino == null) {
                textoError = "No hay cuentas registradas con el número \"" + numCuenta + "\".";
                continue;
            }

            break;
        }

        cuentaDebito.transferir(cuentaDestino, Float.parseFloat(monto));

        System.out.print(margen + "Transferencia realizado exitosamente.\n\nPresiona Enter para continuar.");
        esperarEnter();
    }

    public String toString() { return "Transferir"; }
}
