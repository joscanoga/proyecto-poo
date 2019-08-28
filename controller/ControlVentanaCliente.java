package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;

public class ControlVentanaCliente implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		String menuAccionado = e.getActionCommand();
		if(menuAccionado.equals("Ayuda")) {
			VentanaCliente.panelCentro.setLayout(new BorderLayout(10,10));
//			VentanaError ventana =new VentanaError("Usuario o cleve incorecta"); 
//			VentanaCliente.panelCentro.add(comp);
		}else if(menuAccionado.equals("Usuario")) {
			VentanaCliente.panelCentro.setLayout(new BorderLayout(10,10));//west datos personales center cuentadebito ycdt east cuenta credito
		}
	}
}
