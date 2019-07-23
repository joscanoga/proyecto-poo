package uiMain.menuConsola;

import uiMain.OpcionDeMenu;

public class Retirar extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, monto;

        if (filtrarOpcionesCuentaDebito("transferir") || filtrarSaldoNulo("retirar")) return;

        while (true) {
            System.out.print(margen + "RETIRAR\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: ", "Monto");
            if (!esNumerico(monto = entrada.next(), "float"))
                textoError = "El monto debe ser un valor numérico, \"" + monto + "\" no lo es.";
            else if (Float.parseFloat(monto) <= 0 || Float.parseFloat(monto) > cuentaDebito.getSaldo()) {
                textoError = "El monto debe ser mayor a 0 y máximo " + quitarZeroDecimal(cuentaDebito.getSaldo()) +
                        " (el saldo de la cuenta débito), el valor \"" + monto + "\" no lo cumple.";
            } else break;
        }

        cuentaDebito.retirar(Float.parseFloat(monto));

        System.out.print(margen + "Retiro realizado exitosamente.\n\nPresiona Enter para continuar");
        esperarEnter();
    }

    public String toString() { return "Retirar"; }
}
