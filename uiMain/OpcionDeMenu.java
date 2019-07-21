package uiMain;

import java.io.Serializable;

public abstract class OpcionDeMenu implements Serializable, RecursosVarios {
    protected String textoError = null;

    protected abstract void ejecutar();

    protected boolean nombreExistente(String nombre) {
        return Main.usuarios.containsKey(nombre);
    }


}
