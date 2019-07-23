package uiMain.menuConsola;

import gestionAplicacion.cuentas.CuentaDebito;
import gestionAplicacion.usuarios.Usuario;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class Transferir extends OpcionDeMenu {
    public void ejecutar() {
        String numCuenta, textoError = null, monto = null;
        CuentaDebito cuentaDestino = null;

        if (filtrarOpcionesCuentaDebito("transferir") || filtrarSaldoNulo("transferir")) return;

        while (true) {
            System.out.print(margen + "TRANSFERIR\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (monto != null ? monto + "\n" : ""), "Monto a transferir");
            if (monto == null && !esNumerico(monto = entrada.next(), "float")) {
                textoError = "El monto a transferir debe ser un valor numérico, \"" + monto + "\" no lo es.";
                monto = null;
                continue;
            } else if (Float.parseFloat(monto) <= 0 || Float.parseFloat(monto) > cuentaDebito.getSaldo()) {
                textoError = "El monto a transferir debe ser mayor a 0 y máximo " +
                        quitarZeroDecimal(cuentaDebito.getSaldo()) + " (el saldo de la cuenta débito de " +
                        "origen), \"" + monto + "\" no lo cumple.";
                monto = null;
                continue;
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
            } else break;
        }

        cuentaDebito.transferir(cuentaDestino, Float.parseFloat(monto));

        System.out.print(margen + "Transferencia realizado exitosamente.\n\nPresiona Enter para continuar.");
        esperarEnter();
    }

    public String toString() { return "Transferir"; }
}
