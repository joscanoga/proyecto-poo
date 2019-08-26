package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import controller.ControlEstandar;
import controller.ControlMenu;
import javax.swing.*;

public class VentanaAplicacion extends JFrame{
	
	public static Container contenedor;
	public static Container logo;
	public static JFrame ventana;
	public static JMenuBar barraMenu = new JMenuBar();
	JLabel etiquetaTexto, etiquetaImagen;
	
	public VentanaAplicacion(){
		
		super("Green Bank Inc.");
		ventana = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(barraMenu);
		JMenuItem menuInicio = new JMenuItem("Inicio");
		menuInicio.setPreferredSize(new Dimension(150, menuInicio.getPreferredSize().height));
		JMenu menuLogin = new JMenu("Iniciar Sesion");
		menuLogin.setPreferredSize(new Dimension(150, menuLogin.getPreferredSize().height));
		JMenuItem menuUser = new JMenuItem("Iniciar sesión como cliente");
		JMenuItem menuAdm = new JMenuItem("Iniciar sesión como administrador");
		menuLogin.add(menuUser);
		menuLogin.add(menuAdm);
		JMenuItem menuRegistro = new JMenuItem("Registrarse");
		menuRegistro.setPreferredSize(new Dimension(150, menuRegistro.getPreferredSize().height));
		JMenuItem menuSalir = new JMenuItem("Salir de la aplicacion");
		menuSalir.setPreferredSize(new Dimension(150, menuSalir.getPreferredSize().height));
		JMenuItem menuContacto = new JMenuItem("Contactenos");
		menuContacto.setPreferredSize(new Dimension(150, menuContacto.getPreferredSize().height));
		barraMenu.add(menuInicio);
		barraMenu.add(menuLogin);
		barraMenu.add(menuRegistro);
		barraMenu.add(menuSalir);
		barraMenu.add(menuContacto);
		menuInicio.addActionListener(new ControlMenu());
		menuUser.addActionListener(new ControlMenu());
		menuRegistro.addActionListener(new ControlMenu());
		menuSalir.addActionListener(new ControlMenu());
		menuContacto.addActionListener(new ControlMenu());
		contenedor = this.getContentPane();
		contenedor.add(new PanelInicio());
		setVisible(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		etiquetaTexto= new JLabel ("\n\n                           Bienvedid@ a Green Bank\n\n");
		etiquetaTexto.setFont(new java.awt.Font("Tahoma", 2, 25));
		etiquetaTexto.setForeground(new java.awt.Color(0, 153, 0));
		contenedor.add(etiquetaTexto);
		contenedor.setLayout(new BoxLayout (contenedor, BoxLayout.Y_AXIS));
		etiquetaImagen= new JLabel (new ImageIcon("src/logo.PNG"));
		contenedor.add(etiquetaImagen);
		etiquetaTexto= new JLabel ("\n\n                  Un banco al alcance de sus posibilidades");
		etiquetaTexto.setFont(new java.awt.Font("Tahoma", 10, 25));
		etiquetaTexto.setForeground(new java.awt.Color(0, 153, 0));
		contenedor.add(etiquetaTexto);	
		
	}
	
	public void arranca() {
		pack();// coloca los componentes
		setLocationRelativeTo(null);// centra la ventana en la pantalla
		setVisible(true);// visualiza la ventana
	}
}
