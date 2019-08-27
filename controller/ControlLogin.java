package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import excepciones.ErrorLogin;
import gestionAplicacion.usuarios.*;
//import model.gestorAplicacion.users.Usuario;
import view.PanelInicio;
import view.PanelLogin;
import view.VentanaAplicacion;

public class ControlLogin implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelLogin panel =(PanelLogin) VentanaAplicacion.contenedor.getComponent(0);
		String usuario = panel.usuario.getText();
		String password = panel.password.getText();
		try {
			UsuarioInvitado.login(usuario, password);
		} catch (ErrorLogin e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();//tratar error
		}
		
		VentanaAplicacion.barraMenu.removeAll();
		JMenuItem menuInicio = new JMenuItem("Inicio");
		JMenuItem menuProductos = new JMenuItem("Productos");
		JMenuItem menuPedido = new JMenuItem("Pedido");
		JMenuItem menuSignOut = new JMenuItem("Cerrar Sesion");
		VentanaAplicacion.barraMenu.add(menuInicio);
		VentanaAplicacion.barraMenu.add(menuProductos);
		VentanaAplicacion.barraMenu.add(menuPedido);
		VentanaAplicacion.barraMenu.add(menuSignOut);
		menuInicio.addActionListener(new ControlMenu());
		menuProductos.addActionListener(new ControlMenu());
		menuPedido.addActionListener(new ControlMenu());
		menuSignOut.addActionListener(new ControlMenu());
		
		VentanaAplicacion.contenedor.removeAll();
		VentanaAplicacion.contenedor.add( new PanelInicio());
		VentanaAplicacion.ventana.pack();
		
	}

}
