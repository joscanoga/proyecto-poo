package uiMain.menuConsola;

import gestionAplicacion.cuentas.CDT;
import gestionAplicacion.cuentas.CuentaDebito;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class CrearCDT extends OpcionDeMenu {

    public void ejecutar() {
        CuentaDebito cuentaDebito = (CuentaDebito)buscarObjetoEn(CuentaDebito.class, Main.usuario.getCuentas());
        String monto = null, meses = null;

        if (cuentaDebito == null) {
            System.out.print(margen + "Debes tener una cuenta débito para poder crear un CDT." +
                    "\n\nPresiona Enter para continuar.");
        } else {
            if (cuentaDebito.getSaldo() == 0) {
                System.out.print(margen + "El saldo de tu cuenta débito es 0, no es posible crear un CDT." +
                        "\n\nPresiona Enter para continuar.");
            } else {
                while (true) {
                    System.out.print(margen + "CREAR CTD.\n\n" + (textoError != null ? textoError + "\n\n" : ""));
                    System.out.format("%-20s: " + (monto != null ? monto + "\n" : ""), "Monto");
                    if (monto == null && !esNumerico(monto = entrada.next(), "float")) {
                        textoError = "El monto debe ser un valor numérico, \"" + monto + "\" no lo es.";
                        monto = null;
                        continue;
                    } else if (Float.parseFloat(monto) <= 0 || Float.parseFloat(monto) > cuentaDebito.getSaldo()) {
                        textoError = "El monto debe ser mayor a 0 y máximo " + cuentaDebito.getSaldo() + " (saldo" +
                                " de la cuenta débito), \"" + monto + "\" no lo cumple.";
                        monto = null;
                        continue;
                    }

                    System.out.format("%-20s: ", "Cantidad de meses");
                    if (!esNumerico(meses = entrada.next(), "int"))
                        textoError = "Cantidad de meses debe ser un entero \"" + meses + "\" no lo es.";
                    else if (Integer.parseInt(meses) == 0)
                        textoError = "Cantidad de meses no puede ser 0.";
                    else break;
                }
                cuentaDebito.retirar(Float.parseFloat(monto));

                Main.usuario.anadirCuenta(new CDT(Main.usuario, Float.parseFloat(monto), Integer.parseInt(meses)));
                System.out.print(margen + "CDT creado exitosamente.\n\nPresiona Enter para continuar.");
            }
        }

        esperarEnter();
    }

    public String toString() { return "Crear CDT"; }
}