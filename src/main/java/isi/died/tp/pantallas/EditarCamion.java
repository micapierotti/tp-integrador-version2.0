package isi.died.tp.pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Camion;

public class EditarCamion {

	private JFrame frame;
	private JTextField textIdCamion;
	private JTextField textMarcaCamion;
	private JTextField textModeloCamion;
	private JTextField textDominioCamion;
	private JTextField textCostoXKm;
	private JTextField textCapacidad;
	private Camion camion;
	private Datos datos;

	private final ButtonGroup buttonGroupLiquidos = new ButtonGroup();
	private JTextField textField;

	public EditarCamion(Camion cam, Datos datos) {
		this.datos=datos;
		camion=cam;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 360);
		frame.setTitle("Editar Camión");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblDatosDelVehculo = new JLabel("Datos del vehículo:");
		lblDatosDelVehculo.setBounds(10, 10, 200, 20);
		frame.getContentPane().add(lblDatosDelVehculo);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(0, 41, 200, 20);
		frame.getContentPane().add(lblId);
		
		textIdCamion = new JTextField();
		textIdCamion.setBounds(202, 41, 130, 20);
		frame.getContentPane().add(textIdCamion);
		textIdCamion.setColumns(10);
		textIdCamion.setText(camion.getId());
		textIdCamion.setEditable(false);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setBounds(0, 72, 200, 20);
		frame.getContentPane().add(lblMarca);
		
		textMarcaCamion = new JTextField();
		textMarcaCamion.setBounds(202, 72, 130, 20);
		frame.getContentPane().add(textMarcaCamion);
		textMarcaCamion.setColumns(10);
		textMarcaCamion.setText(camion.getMarca());
		
		JLabel lblNewLabel = new JLabel("Modelo :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(0, 103, 200, 20);
		frame.getContentPane().add(lblNewLabel);
		
		textModeloCamion = new JTextField();
		textModeloCamion.setBounds(202, 103, 130, 20);
		textModeloCamion.setColumns(10);
		frame.getContentPane().add(textModeloCamion);
		textModeloCamion.setText(camion.getModelo());
		
		JLabel lblNewLabel_1 = new JLabel("Dominio :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 134, 200, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textDominioCamion = new JTextField();
		textDominioCamion.setBounds(202, 134, 130, 20);
		frame.getContentPane().add(textDominioCamion);
		textDominioCamion.setColumns(10);
		textDominioCamion.setText(camion.getDominio());
		
		JLabel lblAo = new JLabel("Año :");
		lblAo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAo.setBounds(0, 165, 200, 20);
		frame.getContentPane().add(lblAo);
		
		JLabel lblCostoPorKm = new JLabel("Costo por Km :");
		lblCostoPorKm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoPorKm.setBounds(0, 196, 200, 20);
		frame.getContentPane().add(lblCostoPorKm);
		
		textCostoXKm = new JTextField();
		textCostoXKm.setBounds(202, 196, 130, 20);
		frame.getContentPane().add(textCostoXKm);
		textCostoXKm.setColumns(10);
		textCostoXKm.setText(Double.toString(camion.getCostoXKM()));
		
		JLabel lblEsAptoPara = new JLabel("¿Es apto para transportar líquidos?");
		lblEsAptoPara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEsAptoPara.setBounds(0, 223, 200, 20);
		frame.getContentPane().add(lblEsAptoPara);
		
		JRadioButton rdbtnS = new JRadioButton("Si");
		rdbtnS.setBounds(202, 223, 55, 20);
		frame.getContentPane().add(rdbtnS);
		
		JLabel lblCapacidad = new JLabel("Capacidad :");
		lblCapacidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidad.setBounds(0, 249, 200, 20);
		frame.getContentPane().add(lblCapacidad);
		
		textCapacidad = new JTextField();
		textCapacidad.setBounds(202, 250, 130, 20);
		frame.getContentPane().add(textCapacidad);
		textCapacidad.setColumns(10);
		textCapacidad.setText(Double.toString(camion.getCapacidad()));
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarCamion(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 290, 200, 20);
		frame.getContentPane().add(btnAtrs);
		
		textField = new JTextField();
		textField.setBounds(202, 165, 130, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(Integer.toString(camion.getAnio()));
		
		JButton btnAgregar = new JButton("Guardar cambios");
		btnAgregar.setBounds(224, 290, 200, 20);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Camion> listaC= datos.getListaCamiones();
				listaC.remove(camion);
				String marca = textMarcaCamion.getText();
				String modelo = textModeloCamion.getText();
				String dominio = textDominioCamion.getText();
				int anio = Integer.parseInt(textField.getText());
				double costoXKM = Double.parseDouble(textCostoXKm.getText());
				boolean AptoLiq=false;
				if(rdbtnS.isSelected()) {
					AptoLiq=true;
				}
				double capacidad = Double.parseDouble(textCapacidad.getText());
				camion.setMarca(marca);
				camion.setModelo(modelo);
				camion.setDominio(dominio);
				camion.setAnio(anio);
				camion.setCostoXKM(costoXKM);
				camion.setAptoLiq(AptoLiq);
				camion.setCapacidad(capacidad);
				listaC.add(camion);
				datos.setListaCamiones(listaC);
				new BuscarCamion(datos);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAgregar);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(284, 223, 48, 20);
		frame.getContentPane().add(rdbtnNo);
		buttonGroupLiquidos.add(rdbtnNo);
		buttonGroupLiquidos.add(rdbtnS);
		if(camion.isAptoLiq()) {
			rdbtnS.setSelected(true);
		}else {rdbtnNo.setSelected(true);}

		frame.setVisible(true);
	}

}
