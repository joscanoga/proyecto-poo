package uiMain.menuConsola;

import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class Retirar extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, monto;
        CuentaDebito cuentaDebito = (CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas());

        if (cuentaDebito == null) {
            System.out.print(margen +
                    "Debes poseer una cuenta débito para poder retirar.\n\nPresiona Enter para continuar");
            esperarEnter();
            return;
        }

        float valorMonto,
                saldo = ((CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas())).getSaldo();

        while (true) {
            System.out.println(margen + "FORMULARIO DE RETIRO\n");
            if (textoError != null) System.out.println(textoError + "\n");
            System.out.format("%-20s: ", "Monto");
            if (!esNumerico(monto = entrada.next(), "float")) {
                textoError = "El valor del monto debe ser un valor numérico, \"" + monto + "\" no lo es.";
                continue;
            }

            valorMonto = Float.parseFloat(monto);
            if (valorMonto <= 0 || valorMonto > saldo) {
                textoError = "El monto debe ser mayor a 0 y máximo " + quitarZeroDecimal(saldo);
                continue;
            }

            break;
        }

        cuentaDebito.retirar(Float.parseFloat(monto));

        System.out.print(margen + "Retiro realizado exitosamente.\n\nPresiona Enter para continuar");
        esperarEnter();
    }

    public String toString() { return "Retirar"; }
}
