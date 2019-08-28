package gestionAplicacion.usuarios;

import java.util.ArrayList;
import excepciones.*;
import greenBank.GreenBank;
//import uiMain.Main;

public class UsuarioInvitado extends Usuario {
	public UsuarioInvitado() {
		super(0,"Invitado");
	}
	public static void registrarse(int id, String nombreUsuario, String contrasena, String nombre) {
		agregarUsuario(new Cliente(id,nombreUsuario,contrasena,nombre));
		
	}
	public static void login (String nombreUsuario,String contrasena)throws ErrorLogin {
		ArrayList<Usuario> usuarios=getUsuarios();
		boolean login=false;
		for(Usuario usu : usuarios) {
			
			if(usu.getNombreUsuario().equals(nombreUsuario)) {
				if(((UsuarioRegistrado) usu).comprobarclave(nombreUsuario, contrasena)) {
					GreenBank.setUsuario(usu);
					login=true;
					break;
					}
			}
		}
		if(!login) {throw new ErrorLogin();}//se trata en otra parte
	}
	
}
