package view;

import java.awt.*;
import javax.swing.*;
import controller.ControlLogin;
import controller.ControlMenu;

public class PanelLogin extends JPanel{
	JLabel userLabel = new JLabel("Usuario:");
	JLabel passLabel = new JLabel("Contraseña:");
	public JTextField usuario =  new JTextField();
	public JPasswordField password =  new JPasswordField();
	JButton enviar = new JButton("Enviar");
	
	public PanelLogin() {
		
		this.setSize(300,150);
		this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
		add(userLabel);
		add(usuario);
		add(passLabel);
		add(password);
		add(enviar);
		enviar.addActionListener(new ControlLogin());
	}
}
