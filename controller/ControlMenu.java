package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.gestorAplicacion.users.Usuario;
import view.PanelAdm;
import view.PanelContacto;
import view.PanelInicio;
import view.PanelLogin;
import view.PanelPedido;
import view.PanelProductos;
import view.PanelRegistro;
import view.VentanaAplicacion;

public class ControlMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String menuAccionado = e.getActionCommand();
		VentanaAplicacion.contenedor.removeAll();
		if (menuAccionado.equals("Iniciar sesión como cliente")) {
			VentanaAplicacion.contenedor.add( new PanelLogin());
		}else if(menuAccionado.equals("Iniciar sesión como administrador")){
			VentanaAplicacion.contenedor.add( new PanelAdm());
		}else if(menuAccionado.equals("Contactenos")){
			VentanaAplicacion.contenedor.add( new PanelContacto());
		}else if(menuAccionado.equals("Productos")){
			VentanaAplicacion.contenedor.add( new PanelProductos());
		}else if(menuAccionado.equals("Registrarse")){
			VentanaAplicacion.contenedor.add( new PanelRegistro());
		}
		else if(menuAccionado.equals("Pedido")){
			VentanaAplicacion.contenedor.add( new PanelPedido());
		}else if(menuAccionado.equals("Cerrar Sesion")){
			VentanaAplicacion.barraMenu.removeAll();
			JMenuItem menuInicio = new JMenuItem("Inicio");
			JMenuItem menuLogin = new JMenuItem("Iniciar Sesion");
			VentanaAplicacion.barraMenu.add(menuInicio);
			VentanaAplicacion.barraMenu.add(menuLogin);
			menuInicio.addActionListener(new ControlMenu());
			menuLogin.addActionListener(new ControlMenu());
			Usuario.signOut();
			VentanaAplicacion.contenedor.add( new PanelInicio());
		}else {
			VentanaAplicacion.contenedor.add( new PanelInicio());
		}
		VentanaAplicacion.ventana.pack();
	}
	
}
