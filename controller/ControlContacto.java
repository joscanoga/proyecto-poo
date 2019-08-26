package controller;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControlContacto implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Icon icono = new ImageIcon(getClass().getResource("src/logom.PNG"));
		JOptionPane.showMessageDialog(null," Aprendiendo a poner imagenes ", "Contactenos", JOptionPane.INFORMATION_MESSAGE, icono);
		
	}
}
