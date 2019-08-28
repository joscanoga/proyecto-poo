package view;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.ControlVentanaCliente;
import excepciones.ErrorLogin;
import gestionAplicacion.usuarios.Usuario;
import gestionAplicacion.usuarios.UsuarioInvitado;
//import uiMain.Main;
import greenBank.GreenBank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
public class VentanaCliente extends JFrame{
	public static Container panel;
	public static JMenuBar barraMenu = new JMenuBar();
	public static Container panelCentro=new Container();
	JMenu archivo,procesosYConsultas;
	JMenuItem aUsuario,salir,ayuda;
	JButton ayudaBoton;
	public VentanaCliente() {
		super("Usuario: "+GreenBank.getUsuario().getNombreUsuario());
		panel=this.getContentPane();
		panel.setLayout(new BorderLayout());
		 archivo=new JMenu("archivo");
		archivo.setPreferredSize(new Dimension(150, 20));
		 aUsuario = new JMenuItem("Usuario");
		archivo.add(aUsuario);
		salir=new JMenuItem("Salir");
		archivo.add(salir);
		procesosYConsultas =new JMenu("Procesos y Consultas");
		 ayuda =new JMenuItem("Ayuda");
		 ayudaBoton=new JButton("Ayuda");
		 ayuda.addActionListener(new ControlVentanaCliente());
		 archivo.addActionListener(new ControlVentanaCliente());
		 procesosYConsultas.addActionListener(new ControlVentanaCliente());
//		ayuda.add(ayudaBoton);
//		ayuda.addActionListener((ActionListener) this);
		barraMenu.add(archivo);
		barraMenu.add(procesosYConsultas);
		barraMenu.add(ayuda);
		panel.add(barraMenu,BorderLayout.NORTH);
		panel.add(panelCentro,BorderLayout.CENTER);
		
		setLocation(400, 100);
        setSize(700, 400);
        setVisible(true);
	}
	//////////////////////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource().equals(ayuda)) {
			VentanaError ventana =new VentanaError("Usuario o cleve incorecta");
			
			
		}
		
		
		
	}
	/////////////////////////////////////////////////////////////
	public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
}


