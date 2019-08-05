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

public class CaminoPlantaFinal {

	private JFrame frame;
	private JTextField tfID;
	private JTextField tfNombre;
	private JLabel lblIngreseLosDatos;
	private JLabel lblNombre;
	private JTable table;
	private ListSelectionModel model;
	private Planta plantaInicial;
	private Planta planta;
	private Datos datos;
	
	public CaminoPlantaFinal(Planta planta,Datos datos) {
		this.plantaInicial=planta;
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Caminos entre plantas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(34, 104, 46, 14);
		frame.getContentPane().add(lblId);
		
		tfID = new JTextField();
		tfID.setBounds(85, 101, 86, 20);
		frame.getContentPane().add(tfID);
		tfID.setColumns(10);
		
		lblIngreseLosDatos = new JLabel("Ingrese la planta final del camino ");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseLosDatos.setBounds(10, 45, 178, 14);
		frame.getContentPane().add(lblIngreseLosDatos);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 135, 70, 14);
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(85, 132, 86, 20);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CaminosEntrePlantas(plantaInicial,planta,datos,0);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(324, 226, 100, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CaminoPlantaInicial(datos);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 226, 100, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblPlantasEncontradas = new JLabel("Plantas encontradas:");
		lblPlantasEncontradas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlantasEncontradas.setBounds(198, 20, 128, 14);
		frame.getContentPane().add(lblPlantasEncontradas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(198, 45, 226, 151);
		frame.getContentPane().add(scrollPane);
		
		Object[][] datosPlantas=datos.getBusquedaPlantas();
		String[] columnas= {"ID","Nombre"};
		
		table = new JTable(datosPlantas,columnas);
		scrollPane.setViewportView(table);
		model=table.getSelectionModel();
		table.setAutoCreateRowSorter(true);
		table.editingCanceled(null);
		
		tfID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnNewButton.setEnabled(false);
				
				table= new JTable(actualizarTabla(datosPlantas,tfID.getText(),tfNombre.getText()),columnas);
				scrollPane.setViewportView(table);
				model=table.getSelectionModel();
				table.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged (ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
								btnNewButton.setEnabled(true);
								
								int aux1=(int) table.getValueAt(model.getMinSelectionIndex(), 0);
								String aux2=(String) table.getValueAt(model.getMinSelectionIndex(), 1);
								
								planta=datos.buscarPlanta(aux1,aux2);
							}
						}
					});
			}
		});
		
		
		
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnNewButton.setEnabled(false);
				
				table= new JTable(actualizarTabla(datosPlantas,tfID.getText(),tfNombre.getText()),columnas);
				scrollPane.setViewportView(table);
				model=table.getSelectionModel();
				table.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged (ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
								btnNewButton.setEnabled(true);
								
								int aux1=(int) table.getValueAt(model.getMinSelectionIndex(), 0);
								String aux2=(String) table.getValueAt(model.getMinSelectionIndex(), 1);
								
								planta=datos.buscarPlanta(aux1,aux2);
							}
						}
					});
			}
		});
		
		model.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged (ListSelectionEvent e) {
				if(!model.isSelectionEmpty()) {
						btnNewButton.setEnabled(true);
						
						int aux1=(int) table.getValueAt(model.getMinSelectionIndex(), 0);
						String aux2=(String) table.getValueAt(model.getMinSelectionIndex(), 1);
						
						planta=datos.buscarPlanta(aux1,aux2);
					}
				}
			});
		
		frame.setVisible(true);
	}
		
	private Object[][] actualizarTabla(Object[][] datosTabla, String id, String nombre){
			
			Datos datosFinal = new Datos();
			ArrayList<Planta> listaPlantas= new ArrayList<Planta>();
			String idAux;
			String nombreAux;
			Planta pl = new Planta();
			
			for(int i=0; i<datosTabla.length;i++) {
				idAux = Integer.toString((int)datosTabla[i][0]);
				nombreAux = (String)datosTabla[i][1];
				if(nombreAux.contains(nombre) && idAux.contains(id)) {
					pl= datosFinal.buscarPlanta(Integer.parseInt(idAux), nombreAux);
					listaPlantas.add(pl);
				}
			}
			
			datosFinal.setListaPlantas(listaPlantas);
			return datosFinal.getBusquedaPlantas();
		}
	//
	}
