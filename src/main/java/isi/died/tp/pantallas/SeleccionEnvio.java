package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Camion;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;
import isi.died.tp.estructuras.ArbolBinarioBusqueda;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SeleccionEnvio {

	private JFrame frame;
	private JTable tableInsumos;
	private Datos datos;
	private JTable tablaCamion;
    private ListSelectionModel model;
    private Planta seleccionPlanta;
    private Camion seleccionCamion;
	
	public SeleccionEnvio(Datos datos) {
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 300);
		frame.setTitle("Ver Insumos Faltantes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(datos.listaPlantasString()));
		comboBox.setBounds(69, 27, 160, 25);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPlanta = new JLabel("Planta: ");
		lblPlanta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlanta.setBounds(22, 32, 46, 14);
		frame.getContentPane().add(lblPlanta);
		
		JScrollPane scrollPaneInsumo = new JScrollPane();
		scrollPaneInsumo.setBounds(22, 62, 310, 130);
		frame.getContentPane().add(scrollPaneInsumo);
		
		Object[][] datosTabla = null;
		String[] columnasInsumos= {"Insumo", "Cantidad Actual", "Cantidad Faltante"};
		
		tableInsumos = new JTable();
		tableInsumos.setModel(new DefaultTableModel(datosTabla,columnasInsumos));
		scrollPaneInsumo.setViewportView(tableInsumos);

		
		JButton btnSalir = new JButton("Generar Solución");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GenerarSolucion(datos, seleccionPlanta, seleccionCamion);
				frame.dispose();
			}
		});
		btnSalir.setBounds(574, 225, 100, 25);
		frame.getContentPane().add(btnSalir);
		btnSalir.setEnabled(false);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionLogistica(datos);
				frame.dispose();
			}
		});
		
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		JScrollPane scrollPaneCamion = new JScrollPane();
		scrollPaneCamion.setBounds(352, 62, 310, 130);
		frame.getContentPane().add(scrollPaneCamion);
		
		Object[][] datosCamiones=datos.getBusquedaCamiones();
		String[] columnasCamion= {"ID","Dominio","Capacidad","Líquidos"};
		
		tablaCamion = new JTable(datosCamiones,columnasCamion);
		scrollPaneCamion.setViewportView(tablaCamion);
		model=tablaCamion.getSelectionModel();
		
		JLabel lblSeleccioneUnCamin = new JLabel("Seleccione un camión: ");
		lblSeleccioneUnCamin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeleccioneUnCamin.setBounds(352, 32, 160, 14);
		frame.getContentPane().add(lblSeleccioneUnCamin);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedIndex()!=0) {
				seleccionPlanta=datos.getListaPlantas().get(comboBox.getSelectedIndex()+1);
				
				tableInsumos= new JTable(actualizarTabla(seleccionPlanta),columnasInsumos);
				scrollPaneInsumo.setViewportView(tableInsumos);
				tableInsumos.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						
						if(!model.isSelectionEmpty()) {						
							btnSalir.setEnabled(true);
						}
					}
				});}
			}
		});

		
		model.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				if(!model.isSelectionEmpty()) {
					btnSalir.setEnabled(true);
					
					String aux1ID= (String) tablaCamion.getValueAt(model.getMinSelectionIndex(), 0);
					String aux2DOMINIO= (String) tablaCamion.getValueAt(model.getMinSelectionIndex(), 1);
					
					seleccionCamion=datos.buscarCamion(aux1ID,aux2DOMINIO);	
				}
			}
		});
		
		frame.setVisible(true);
	}
	
	private Object[][] actualizarTabla(Planta plantaSeleccion){
		
		ArrayList<Stock> listaStocks = new ArrayList<>();
		
		for(Stock stock:plantaSeleccion.getStocks()) {
			if(stock.getCantidad()<stock.getPuntoPedido()) {
				listaStocks.add(stock);
			}
		}
		
		Object[][] datosStock = new Object[listaStocks.size()][3];
		
		for(int i=0;i<listaStocks.size();i++) {
			datosStock[i][0]=listaStocks.get(i).getInsumo().getDescripcion();
			datosStock[i][1]=listaStocks.get(i).getCantidad();
			datosStock[i][2]=listaStocks.get(i).getPuntoPedido()-listaStocks.get(i).getCantidad();
		}
		
		return datosStock;
	}	
}
