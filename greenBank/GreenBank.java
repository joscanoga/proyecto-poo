package greenBank;
import view.*;

import java.io.IOException;

import controller.*;
import gestionAplicacion.usuarios.*;
public class GreenBank {
	static Usuario usuario;
	public static  Usuario getUsuario() {return usuario;}
	public static void setUsuario(Usuario usu) {usuario=usu;}
 public static void main(String[] args) throws IOException {
	 Usuario.cargarUsusario();
	  usuario=new UsuarioInvitado();
// usuario.agregarUsuario(new Administrador(12345, "superadmin", "12345",  "jose dario"));
//	  usuario.agregarUsuario(new Cliente(123456789, "supercliente", "12345", "juan arango"));
//	 System.out.println(usuario);
//	 System.out.println(usuario.getNumeroUsuarios());
//	 System.out.println(usuario.getUsuarios().size());
//	 for (Usuario usu : usuario.getUsuarios()) {System.out.println(usu);}
//	 usuario.setNumeroUsuarios(usuario.getUsuarios().size());
//	 usuario.guardarUsuarios();
	 Window vista= new Window();
//	 VentanaError ventana = new VentanaError("hola");
	 
//	 VentanaAplicacion vista= new VentanaAplicacion();
 }
}
