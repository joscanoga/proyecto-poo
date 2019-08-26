package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControlLoginAdm;
import controller.ControlMenu;

public class PanelAdm extends JPanel{
	
	public JTextField usuario =  new JTextField("ale");
	public JPasswordField password =  new JPasswordField("123");
	JButton enviar = new JButton("Enviar");
	
	public PanelAdm() {
		
		this.setLayout(new GridLayout(3,1));
		add(usuario);
		add(password);
		add(enviar);
		enviar.addActionListener(new ControlLoginAdm());
	}
}
