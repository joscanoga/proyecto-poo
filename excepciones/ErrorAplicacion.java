package excepciones;

public class ErrorAplicacion extends Exception{

	public ErrorAplicacion(String texto) {
		super("ErrorAplicacion."+texto);
	}
 
}
