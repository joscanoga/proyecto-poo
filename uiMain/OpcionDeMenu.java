package uiMain;

import java.io.Serializable;

public abstract class OpcionDeMenu implements Serializable, RecursosVarios {

    protected abstract void ejecutar();

    protected boolean nombreExistente(String nombre) {
        return Main.usuarios.containsKey(nombre);
    }


}
