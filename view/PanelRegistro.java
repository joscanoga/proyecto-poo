package view;

import java.awt.*;

import javax.swing.*;

import controller.ControlLogin;
import controller.ControlRegistro;

public class PanelRegistro extends JPanel {
	JLabel userLabel = new JLabel("Elija un nombre de usuario:");
	JLabel passLabel = new JLabel("Elija una contraseña:");
	JLabel passLabel1 = new JLabel("Confirma tu contraseña:");
	JLabel nmLabel = new JLabel("Nombre completo:");
	public JTextField usuario =  new JTextField();
	public JPasswordField password =  new JPasswordField();
	public JPasswordField password1 =  new JPasswordField();
	public JPasswordField nombre =  new JPasswordField();
	JButton registro = new JButton("Registrarse");
	
	public PanelRegistro() {
		
		this.setSize(300,150);
		this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
		add(userLabel);
		add(usuario);
		add(passLabel);
		add(password);
		add(passLabel1);
		add(password1);
		add(nmLabel);
		add(nombre);
		add(registro);
		registro.addActionListener(new ControlRegistro());
	}
}
