package isi.died.tp.pantallas;

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
import javax.swing.JRadioButton;
import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Camion;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;

public class BuscarCamion {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblIngreseLosDatos;
	private JLabel lblBsquedaopcional;
	private JLabel lblNombre;
	private JTextField textField_1;
	private JTable table;
	private JLabel lblIdInsumo;
	private JLabel lblAptoParaLquidos;
	private ListSelectionModel model;
	private Camion camion;
	private final ButtonGroup buttonGroupLiq = new ButtonGroup();
	private JTextField textField_2;
	private Datos datos;

	public BuscarCamion(Datos datos) {
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 334);
		frame.setTitle("Buscar Camión");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(57, 85, 46, 14);
		frame.getContentPane().add(lblId);
		lblId.setForeground(beige);
		
		textField = new JTextField();
		textField.setBounds(108, 82, 93, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblIngreseLosDatos = new JLabel("Ingrese los datos de búsqueda ");
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseLosDatos.setBounds(10, 45, 200, 14);
		frame.getContentPane().add(lblIngreseLosDatos);
		lblIngreseLosDatos.setForeground(beige);
		lblBsquedaopcional = new JLabel("(opcional):");
		lblBsquedaopcional.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBsquedaopcional.setHorizontalAlignment(SwingConstants.LEFT);
		lblBsquedaopcional.setBounds(10, 61, 150, 14);
		frame.getContentPane().add(lblBsquedaopcional);
		lblBsquedaopcional.setForeground(beige);
		lblNombre = new JLabel("Dominio:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(3, 113, 100, 14);
		frame.getContentPane().add(lblNombre);
		lblNombre.setForeground(beige);
		textField_1 = new JTextField();
		textField_1.setBounds(108, 110, 93, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EliminarCamion(camion,datos);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(564, 216, 100, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setEnabled(false);
		btnNewButton.setBackground(rojo);
		btnNewButton.setForeground(beige);
		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionTransporte(datos);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 259, 100, 25);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBackground(rojo);
		btnNewButton_1.setForeground(beige);
		JLabel lblPlantasEncontradas = new JLabel("Camiones encontrados:");
		lblPlantasEncontradas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPlantasEncontradas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlantasEncontradas.setBounds(218, 29, 128, 14);
		frame.getContentPane().add(lblPlantasEncontradas);
		lblPlantasEncontradas.setForeground(beige);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(218, 54, 446, 151);
		frame.getContentPane().add(scrollPane);
		
		Object[][] datosCamiones=datos.getBusquedaCamiones();
		String[] columnas= {"ID","Dominio","Capacidad","Líquidos"};
		
		table = new JTable(datosCamiones,columnas);
		scrollPane.setViewportView(table);
		model=table.getSelectionModel();
		table.setAutoCreateRowSorter(true);
		table.editingCanceled(null);
		
		lblIdInsumo = new JLabel("Capacidad:");
		lblIdInsumo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdInsumo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdInsumo.setBounds(3, 141, 100, 14);
		frame.getContentPane().add(lblIdInsumo);
		lblIdInsumo.setForeground(beige);
		lblAptoParaLquidos = new JLabel("Apto para líquidos:");
		lblAptoParaLquidos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAptoParaLquidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAptoParaLquidos.setBounds(-17, 166, 120, 14);
		frame.getContentPane().add(lblAptoParaLquidos);
		lblAptoParaLquidos.setForeground(beige);
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarCamion(camion,datos);
				frame.dispose();
			}
		});
		btnEditar.setBounds(218, 216, 100, 25);
		frame.getContentPane().add(btnEditar);
		btnEditar.setEnabled(false);
		btnEditar.setBackground(rojo);
		btnEditar.setForeground(beige);
		
		JRadioButton rdbtnS = new JRadioButton("Sí");
		rdbtnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEditar.setEnabled(false);
				btnNewButton.setEnabled(false);
				table=new JTable(actualizarTabla(datosCamiones,textField.getText(),textField_1.getText(),textField_2.getText(),"1"), columnas);
				scrollPane.setViewportView(table);
				model=table.getSelectionModel();
				table.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged (ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
								btnEditar.setEnabled(true);
								btnNewButton.setEnabled(true);
								
								String aux1ID= (String) table.getValueAt(model.getMinSelectionIndex(), 0);
								String aux2DOMINIO= (String) table.getValueAt(model.getMinSelectionIndex(), 1);
								
								camion=datos.buscarCamion(aux1ID,aux2DOMINIO);
							}
						}
					});
			}
		});
		buttonGroupLiq.add(rdbtnS);
		rdbtnS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnS.setBounds(108, 162, 52, 23);
		frame.getContentPane().add(rdbtnS);
		rdbtnS.setBackground(azul);
		rdbtnS.setForeground(beige);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.setEnabled(false);
				btnNewButton.setEnabled(false);
				table=new JTable(actualizarTabla(datosCamiones,textField.getText(),textField_1.getText(),textField_2.getText(),"2"), columnas);
				scrollPane.setViewportView(table);
				model=table.getSelectionModel();
				table.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged (ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
								btnEditar.setEnabled(true);
								btnNewButton.setEnabled(true);
								
								String aux1ID= (String) table.getValueAt(model.getMinSelectionIndex(), 0);
								String aux2DOMINIO= (String) table.getValueAt(model.getMinSelectionIndex(), 1);
								
								camion=datos.buscarCamion(aux1ID,aux2DOMINIO);
							}
						}
					});
			}
		});
		buttonGroupLiq.add(rdbtnNo);
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnNo.setBounds(162, 162, 52, 23);
		frame.getContentPane().add(rdbtnNo);
		rdbtnNo.setForeground(beige);
		rdbtnNo.setBackground(azul);
		textField_2 = new JTextField();
		textField_2.setBounds(108, 141, 93, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnEditar.setEnabled(false);
				btnNewButton.setEnabled(false);
				String liqq = "0";
				if(rdbtnS.isSelected()) {
					liqq="1";
				}else if(rdbtnNo.isSelected()){
					liqq="2";
				}
				table=new JTable(actualizarTabla(datosCamiones,textField.getText(),textField_1.getText(),textField_2.getText(),liqq), columnas);
				scrollPane.setViewportView(table);
				model=table.getSelectionModel();
				table.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged (ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
								btnEditar.setEnabled(true);
								btnNewButton.setEnabled(true);
								
								String aux1ID= (String) table.getValueAt(model.getMinSelectionIndex(), 0);
								String aux2DOMINIO= (String) table.getValueAt(model.getMinSelectionIndex(), 1);
								
								camion=datos.buscarCamion(aux1ID,aux2DOMINIO);
							}
						}
					});
			}
		});
		
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnEditar.setEnabled(false);
				btnNewButton.setEnabled(false);
				String liqq = "0";
				if(rdbtnS.isSelected()) {
					liqq="1";
				}else if(rdbtnNo.isSelected()){
					liqq="2";
				}
				table=new JTable(actualizarTabla(datosCamiones,textField.getText(),textField_1.getText(),textField_2.getText(),liqq), columnas);
				scrollPane.setViewportView(table);
				model=table.getSelectionModel();
				table.setAutoCreateRowSorter(true);
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged (ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
								btnEditar.setEnabled(true);
								btnNewButton.setEnabled(true);
								
								String aux1ID= (String) table.getValueAt(model.getMinSelectionIndex(), 0);
								String aux2DOMINIO= (String) table.getValueAt(model.getMinSelectionIndex(), 1);
								
								camion=datos.buscarCamion(aux1ID,aux2DOMINIO);
							}
						}
					});
			}
		});
		
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnEditar.setEnabled(false);
				btnNewButton.setEnabled(false);
				String liqq = "0";
				if(rdbtnS.isSelected()) {
					liqq="1";
				}else if(rdbtnNo.isSelected()){
					liqq="2";
				}
				table=new JTable(actualizarTabla(datosCamiones,textField.getText(),textField_1.getText(),textField_2.getText(),liqq), columnas);
				scrollPane.setViewportView(table);
				model=table.getSelectionModel();
				table.setAutoCreateRowSorter(true);
				model.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged (ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
								btnEditar.setEnabled(true);
								btnNewButton.setEnabled(true);
								
								String aux1ID= (String) table.getValueAt(model.getMinSelectionIndex(), 0);
								String aux2DOMINIO= (String) table.getValueAt(model.getMinSelectionIndex(), 1);
								
								camion=datos.buscarCamion(aux1ID,aux2DOMINIO);
							}
						}
					});
			}
		});
		
		
		
		model.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged (ListSelectionEvent e) {
				if(!model.isSelectionEmpty()) {
						btnEditar.setEnabled(true);
						btnNewButton.setEnabled(true);
						
						String aux1ID= (String) table.getValueAt(model.getMinSelectionIndex(), 0);
						String aux2DOMINIO= (String) table.getValueAt(model.getMinSelectionIndex(), 1);
						
						camion=datos.buscarCamion(aux1ID,aux2DOMINIO);
					}
				}
			});
		
		frame.setVisible(true);
		
	} 
	
	private Object[][] actualizarTabla(Object[][] datosTabla, String id, String dominio, String cant, String liq){
		
		Datos datosFinal = new Datos(datos);
		ArrayList<Camion> listaCamiones = new ArrayList<Camion>();
		String idAux;
		String domAux;
		String cantAux;
		String liqAux;
		Camion cam = new Camion();
		for(int i=0; i<datosTabla.length;i++) {
			idAux=(String) datosTabla[i][0];
			domAux=(String) datosTabla[i][1];
			cantAux= Integer.toString((int)datosTabla[i][2]);
			if(((String) datosTabla[i][3]).contains("Si")) {
				liqAux = "1";
			}else { liqAux = "2";}
			
			if(idAux.contains(id) && domAux.contains(dominio) && cantAux.contains(cant)) {
				if(liq.contains(liqAux)) {
					cam = datosFinal.buscarCamion(idAux, domAux);
					listaCamiones.add(cam);
				} else if(liq.contains("0")){
					cam = datosFinal.buscarCamion(idAux, domAux);
					listaCamiones.add(cam);
				}
			}
		}
		
		datosFinal.setListaCamiones(listaCamiones);
		return datosFinal.getBusquedaCamiones();
	  }
	}


