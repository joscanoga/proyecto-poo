package view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import controller.tableButton.ControlTableButtonProductos;
import controller.tableButton.JTableButtonMouseListener;
import model.gestorAplicacion.logic.Producto;
import view.tableButton.JTableModel;

public class PanelProductos extends JPanel{
	JTable table;
	public PanelProductos(){
		HashMap<String, Producto> productos = Producto.productos;
		String nombreBoton = "Ordenar";
		String [] nombreColumnas = {"Codigo", "Nombre", "Precio", nombreBoton};
		Object [][] datos = new Object [productos.size()][nombreColumnas.length];
		int contador = 0;
		for(Map.Entry<String, Producto> producto : productos.entrySet()) {
			Producto item = producto.getValue();
			
			JButton boton = new JButton(nombreBoton);
			boton.setActionCommand(item.getCodigo());
			boton.addActionListener(new ControlTableButtonProductos());
			
			datos[contador][0]= item.getCodigo();
			datos[contador][1]= item.getNombre();
			datos[contador][2]= item.getPrecio();
			datos[contador][3]= boton;
			contador++;
		}
		table = new JTable(new JTableModel(nombreColumnas,datos)); 
		table.setFillsViewportHeight(true);
		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
	    table.getColumn(nombreBoton).setCellRenderer(buttonRenderer);
	    table.addMouseListener(new JTableButtonMouseListener(table));
	    
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

	}
}
