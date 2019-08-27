package gestionAplicacion.usuarios;

public class UsuarioRegistrado extends Usuario {
    
	private String  contrasena, nombre;

	public UsuarioRegistrado(int id, String nombreUsuario,String contrasena, String nombre) {
		super(id, nombreUsuario);
		this.contrasena=contrasena;
		this.nombre=nombre;
	}

   
	
    public String getContrasena() { return contrasena; }

    public String getNombre() { return nombre; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public void setNombre(String nombre) {this.nombre=nombre;}
    public void cerrarSeccion() {uiMain.Main.usuario=new UsuarioInvitado();}
    public Boolean comprobarclave(String nombreUsuario,String contrasena) {
    	if (this.nombreUsuario.equals(nombreUsuario)&&this.contrasena.equals(contrasena)) {
    		return true;
    	}else return false;
    }

}
