package gestionAplicacion.usuarios;

import uiMain.MenuDeConsola;
public abstract class Usuario {
	static int usuarios;
	private int id;
	private MenuDeConsola opciones;
	private String nombreUsuario;
	private String contraseña;
	public int getId() {return id;	}
	public MenuDeConsola getOpciones() {return opciones;}
	public String getNombreUsusario () {return nombreUsuario;}


	}
