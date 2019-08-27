package gestionAplicacion.usuarios;

import java.util.ArrayList;
import excepciones.*;
import uiMain.Main;

public class UsuarioInvitado extends Usuario {
	public UsuarioInvitado() {
		super(0,"Invitado");
	}
	public void registrarse(int id, String nombreUsuario, String contrasena, String nombre) {
		agregarUsuario(new Cliente(id,nombreUsuario,contrasena,nombre));
		
	}
	public void iniciarSeccion(String nombreUsuario,String contrasena)throws ErrorLogin {
		ArrayList<UsuarioRegistrado> usuarios=getUsuarios();
		boolean login=false;
		for(UsuarioRegistrado usu : usuarios) {
			
			if(usu.getNombreUsuario().equals(nombreUsuario)) {
				if(usu.comprobarclave(nombreUsuario, contrasena)) {
					Main.usuario=usu;
					login=true;
					break;
					}
			}
		}
		if(!login) {throw new ErrorLogin();}//se trata en otra parte
	}
	
}
