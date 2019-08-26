package view;

import java.awt.*;

import javax.swing.*;

import controller.ControlLogin;
import controller.ControlRegistro;

public class PanelContacto extends JPanel {
	JLabel userLabel = new JLabel("Puedes ponerte en contacto con nosotros a tráves de:");
	JLabel passLabel = new JLabel("Nuestro correo electronico: contacto@greenbank.com");
	JButton atras = new JButton("Atras");
	
	public PanelContacto() {
		
		this.setSize(300,150);
		this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
		add(userLabel);
		add(passLabel);
		atras.addActionListener(new ControlAtras());
	}
}