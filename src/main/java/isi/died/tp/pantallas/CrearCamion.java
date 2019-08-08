package isi.died.tp.pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Camion;

public class CrearCamion {

	private JFrame frame;
	private JTextField textIdCamion;
	private JTextField textMarcaCamion;
	private JTextField textModeloCamion;
	private JTextField textDominioCamion;
	private JTextField textCostoXKm;
	private JTextField textCapacidad;
	private Datos datos;

	private final ButtonGroup buttonGroupLiquidos = new ButtonGroup();
	private JTextField textField;

	public CrearCamion(Datos datos) {
		this.datos=datos;
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Agregar Camión");
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		
		JLabel lblDatosDelVehculo = new JLabel("Datos del vehículo:");
		lblDatosDelVehculo.setBounds(10, 10, 200, 20);
		frame.getContentPane().add(lblDatosDelVehculo);
		lblDatosDelVehculo.setForeground(beige);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(0, 41, 200, 20);
		frame.getContentPane().add(lblId);
		lblId.setForeground(beige);
		
		textIdCamion = new JTextField();
		textIdCamion.setBounds(202, 249, 130, 20);
		frame.getContentPane().add(textIdCamion);
		textIdCamion.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setBounds(0, 72, 200, 20);
		frame.getContentPane().add(lblMarca);
		lblMarca.setForeground(beige);
		
		textMarcaCamion = new JTextField();
		textMarcaCamion.setBounds(202, 41, 130, 20);
		frame.getContentPane().add(textMarcaCamion);
		textMarcaCamion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Modelo :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(0, 103, 200, 20);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(beige);
		
		textModeloCamion = new JTextField();
		textModeloCamion.setBounds(202, 72, 130, 20);
		textModeloCamion.setColumns(10);
		frame.getContentPane().add(textModeloCamion);
		
		JLabel lblNewLabel_1 = new JLabel("Dominio :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 134, 200, 20);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setForeground(beige);
		
		textDominioCamion = new JTextField();
		textDominioCamion.setBounds(202, 103, 130, 20);
		frame.getContentPane().add(textDominioCamion);
		textDominioCamion.setColumns(10);
		
		JLabel lblAo = new JLabel("Año :");
		lblAo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAo.setBounds(0, 165, 200, 20);
		frame.getContentPane().add(lblAo);
		lblAo.setForeground(beige);
		
		JLabel lblCostoPorKm = new JLabel("Costo por Km :");
		lblCostoPorKm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoPorKm.setBounds(0, 196, 200, 20);
		frame.getContentPane().add(lblCostoPorKm);
		lblCostoPorKm.setForeground(beige);
		
		textCostoXKm = new JTextField();
		textCostoXKm.setBounds(202, 134, 130, 20);
		frame.getContentPane().add(textCostoXKm);
		textCostoXKm.setColumns(10);
		
		JLabel lblEsAptoPara = new JLabel("¿Es apto para transportar líquidos?");
		lblEsAptoPara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEsAptoPara.setBounds(0, 223, 200, 20);
		frame.getContentPane().add(lblEsAptoPara);
		lblEsAptoPara.setForeground(beige);
		
		JRadioButton rdbtnS = new JRadioButton("Si");
		rdbtnS.setBounds(202, 223, 55, 20);
		frame.getContentPane().add(rdbtnS);
		rdbtnS.setForeground(beige);
		rdbtnS.setBackground(azul);
		JLabel lblCapacidad = new JLabel("Capacidad :");
		lblCapacidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidad.setBounds(0, 249, 200, 20);
		frame.getContentPane().add(lblCapacidad);
		lblCapacidad.setForeground(beige);
		
		textCapacidad = new JTextField();
		textCapacidad.setBounds(202, 196, 130, 20);
		frame.getContentPane().add(textCapacidad);
		textCapacidad.setColumns(10);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(284, 223, 48, 20);
		frame.getContentPane().add(rdbtnNo);
		buttonGroupLiquidos.add(rdbtnNo);
		buttonGroupLiquidos.add(rdbtnS);
		rdbtnNo.setForeground(beige);
		rdbtnNo.setBackground(azul);
		textField = new JTextField();
		textField.setBounds(202, 165, 130, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionTransporte(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 280, 200, 20);
		frame.getContentPane().add(btnAtrs);
		btnAtrs.setForeground(beige);
		btnAtrs.setBackground(rojo);
		JButton btnAgregar = new JButton("Crear camión");
		btnAgregar.setBounds(224, 280, 200, 20);
		btnAgregar.setForeground(beige);
		btnAgregar.setBackground(rojo);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevoId = new String();
				String nuevaMarca = new String();
				String nuevoMod = new String();
				String nuevoDom = new String();
				nuevoId = textMarcaCamion.getText();
				nuevaMarca = textModeloCamion.getText();
				nuevoMod = textDominioCamion.getText();
				nuevoDom = textCostoXKm.getText();
				int nuevoAnio = Integer.parseInt(textField.getText());
				double costoXKM =Double.parseDouble(textCapacidad.getText());
				boolean AptoLiq=false;
				if(rdbtnS.isSelected()) { 
					AptoLiq=true;}
				else if(rdbtnNo.isSelected()) {
					AptoLiq=false;
				}
				int capacidad=Integer.parseInt(textIdCamion.getText());
				Camion nuevoCamion = new Camion(nuevoId,nuevaMarca,nuevoMod,nuevoDom,nuevoAnio,costoXKM,AptoLiq,capacidad);
				ArrayList<Camion> listaC = datos.getListaCamiones();
				listaC.add(nuevoCamion);
				datos.setListaCamiones(listaC);
				new GestionTransporte(datos);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAgregar);
		
		frame.setVisible(true);
	}

}
