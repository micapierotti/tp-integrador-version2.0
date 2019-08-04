package isi.died.tp.pantallas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;

public class BuscarRuta {

	private JFrame frame;
	private Datos datos;
	private JTextField tfID;
	private JTextField tfNombre;
	private JLabel lblIngreseLosDatos;
	private JLabel lblBsquedaopcional;
	private JLabel lblNombre;
	private JTable table;
	private ListSelectionModel model;
	private Ruta ruta;

	
	public BuscarRuta(Datos dat) {
		datos= new Datos(dat);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Buscar ruta");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("Planta origen:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(5, 104, 140, 14);
		frame.getContentPane().add(lblId);
		
		tfID = new JTextField();
		tfID.setBounds(150, 101, 86, 20);
		frame.getContentPane().add(tfID);
		tfID.setColumns(10);
		
		lblIngreseLosDatos = new JLabel("Ingrese los datos de búsqueda ");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseLosDatos.setBounds(10, 45, 178, 14);
		frame.getContentPane().add(lblIngreseLosDatos);
		
		lblBsquedaopcional = new JLabel("(opcional):");
		lblBsquedaopcional.setHorizontalAlignment(SwingConstants.LEFT);
		lblBsquedaopcional.setBounds(10, 61, 150, 14);
		frame.getContentPane().add(lblBsquedaopcional);
		
		lblNombre = new JLabel("Planta destino:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(5, 135, 140, 14);
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(150, 132, 86, 20);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(260, 200, 100, 25);
		frame.getContentPane().add(btnEditar);
		btnEditar.setEnabled(false);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(370, 200, 100, 25);
		frame.getContentPane().add(btnEliminar);
		btnEliminar.setEnabled(false);
		
		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionLogistica(datos);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 226, 100, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblPlantasEncontradas = new JLabel("Rutas encontradas:");
		lblPlantasEncontradas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlantasEncontradas.setBounds(260, 20, 128, 14);
		frame.getContentPane().add(lblPlantasEncontradas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 45, 500, 151);
		frame.getContentPane().add(scrollPane);
		
		Object[][] datosRutas=datos.getBusquedaRutas();
		String[] columnas= {"Planta origen","Planta destino","Distancia","Duración","Peso Máximo"};
		
		table = new JTable(datosRutas,columnas);
		scrollPane.setViewportView(table);
		model=table.getSelectionModel();
		table.setAutoCreateRowSorter(true);
		table.editingCanceled(null);
		
		tfID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnEditar.setEnabled(false);
				
				table= new JTable(actualizarTabla(datosRutas,tfID.getText(),tfNombre.getText()),columnas);
				scrollPane.setViewportView(table);
				model=table.getSelectionModel();
				table.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged (ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
								btnEditar.setEnabled(true);
								btnEliminar.setEnabled(true);
								
								String aux1=(String) table.getValueAt(model.getMinSelectionIndex(), 0);
								String aux2=(String) table.getValueAt(model.getMinSelectionIndex(), 1);
							
								ruta=datos.buscarRuta(aux1,aux2);
							}
						}
					});
			}
		});
		
		
		
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnEditar.setEnabled(false);
				
				table= new JTable(actualizarTabla(datosRutas,tfID.getText(),tfNombre.getText()),columnas);
				scrollPane.setViewportView(table);
				model=table.getSelectionModel();
				table.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged (ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
								btnEditar.setEnabled(true);
								btnEliminar.setEnabled(true);
								
								String aux1=(String) table.getValueAt(model.getMinSelectionIndex(), 0);
								String aux2=(String) table.getValueAt(model.getMinSelectionIndex(), 1);
								
								ruta=datos.buscarRuta(aux1,aux2);
							}
						}
					});
			}
		});
		
		model.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged (ListSelectionEvent e) {
				if(!model.isSelectionEmpty()) {
						btnEditar.setEnabled(true);
						btnEliminar.setEnabled(true);
						
						String aux1=(String) table.getValueAt(model.getMinSelectionIndex(), 0);
						System.out.println(aux1);
						String aux2=(String) table.getValueAt(model.getMinSelectionIndex(), 1);
						System.out.println(aux2);
						
						ruta=datos.buscarRuta(aux1,aux2);
					}
				}
			});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarRuta(ruta,datos);
				frame.dispose();
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EliminarRuta(ruta,datos);
				frame.dispose();
			}
		});
		
		frame.setVisible(true);
	}
	private Object[][] actualizarTabla(Object[][] datosTabla, String origen, String destino){
		
		Datos datosFinal = new Datos(datos);
		
		if(origen.compareTo("")==0 && destino.compareTo("")==0) {
			Object[][] tabla = datosFinal.getBusquedaRutas();
			return tabla;
		}
		
		ArrayList<Ruta> listaRutas= new ArrayList<Ruta>();
		String origenAux;
		String destinoAux;
		Ruta rut = new Ruta();
		
		for(int i=0; i<datosTabla.length;i++) {
			origenAux = (String) datosTabla[i][0];
			destinoAux = (String)datosTabla[i][1];
			if(origenAux.contains(origen) && destinoAux.contains(destino)) {
				rut= datosFinal.buscarRuta(origenAux,destinoAux);
				listaRutas.add(rut);
			}
		}
		
		datosFinal.setListaRutas(listaRutas);
		Object[][] tabla = datosFinal.getBusquedaRutas();
		return tabla;
	}
}
