package uiMain.menuConsola;

import gestionAplicacion.cuentas.CDT;
import gestionAplicacion.cuentas.Cuenta;
import uiMain.Main;
import uiMain.OpcionDeMenu;


public class TranscurrirMesesEnCDT extends OpcionDeMenu {
    public void ejecutar() {
        String textoError = null, numero = null, meses;
        CDT cdt = null;

        if (filtrarOpcionesCDT("transcurrir sus meses")) return;

        while (true) {
            System.out.print(margen + "TRANSCURRIR MESES DE CDT\n\n" + (textoError != null ? textoError + "\n\n" : ""));
            System.out.format("%-20s: " + (numero != null ? numero + "\n" : ""), "Número del CDT");
            if (numero == null && !esNumerico(numero = entrada.next(), "int")) {
                textoError = "El numero del CDT debe ser un valor numérico, \"" + numero + "\" no lo es.";
                numero = null;
                continue;
            } else {
                for (Cuenta cuenta : Main.usuario.getCuentas()) {
                    if (cuenta instanceof CDT && cuenta.getId() == Integer.parseInt(numero)) {
                        cdt = (CDT)cuenta;
                        break;
                    }
                }
                if (cdt == null) {
                    textoError = "No se encontró ningún CDT con el número \"" + numero + "\".";
                    numero = null;
                    continue;
                }
            }

            System.out.format("%-20s: ", "Meses");
            if (!esNumerico(meses = entrada.next(), "int"))
                textoError = "El número de meses debe ser un valor numérico, " + "\"" + meses + "\" no lo es.";
            else if (Integer.parseInt(meses) <= 0 || Integer.parseInt(meses) > cdt.getMeses()) {
                textoError = "El número de meses a transcurrir debe ser mayor a 0 y máximo " + cdt.getMeses() +
                        "(meses por transcurrir del CDT), \"" + meses + "\" no lo cumple.";
            } else break;

        }

        cdt.transcurirMeses(Integer.parseInt(meses));

        System.out.print("\nMeses transcurridos exitosamente.");

        setTieneCDT();

        if (cdt.getMeses() == 0) System.out.print("\n\nYa fueron transcurridos todos los meses del CDT, el monto " +
                "final (" + cdt.getMonto() + ") ha sido agregado a tu cuenta.");

        if (!tieneCDT) {
            Main.usuario.getMenu().removerOpciones(CDT.getMenuDefectoCDT());
        }

        System.out.print("\n\nPresiona Enter para continuar.");

        esperarEnter();
    }

    public String toString() {
        System.out.println("Transcurrir meses");
        return " de un CDT";
    }
}
