package excepciones;

public class ErrorUsuario extends ErrorAplicacion {
	public ErrorUsuario(String texto) {
		super("ErrorUsuario"+texto);
	}
}
