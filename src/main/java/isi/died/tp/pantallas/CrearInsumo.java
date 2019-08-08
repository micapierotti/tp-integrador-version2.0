package isi.died.tp.pantallas;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.InsumoLiquido;
import isi.died.tp.dominio.UnidadMedida;
import javax.swing.JRadioButton;

public class CrearInsumo {

	private JFrame frame;
	private JTextField tfId;
	private JTextField tfDescripcion;
	private JTextField tfCosto;
	private Datos datos;
	
	private final ButtonGroup buttonGroupRefrigerado = new ButtonGroup();
	private final ButtonGroup buttonGroupLiquidos = new ButtonGroup();

	public CrearInsumo(Datos datos) {
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Crear Insumo");
		frame.setSize(500,380);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		tfId = new JTextField();
		tfId.setBounds(214, 36, 130, 20);
		frame.getContentPane().add(tfId);
		tfId.setColumns(10);
		
		JButton Atrás = new JButton("Atrás");
		Atrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionInsumos(datos);
				frame.dispose();
			}
		});
		Atrás.setBounds(10, 305, 100, 25);
		frame.getContentPane().add(Atrás);
		Atrás.setForeground(beige);
		Atrás.setBackground(rojo);
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del insumo:");
		lblIngreseLosDatos.setBounds(10, 11, 200, 14);
		frame.getContentPane().add(lblIngreseLosDatos);
		lblIngreseLosDatos.setForeground(beige);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(164, 39, 46, 14);
		frame.getContentPane().add(lblId);
		lblId.setForeground(beige);
		
		JLabel lblDescripcin = new JLabel("Descripción: ");
		lblDescripcin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcin.setBounds(10, 70, 200, 14);
		frame.getContentPane().add(lblDescripcin);
		lblDescripcin.setForeground(beige);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setColumns(10);
		tfDescripcion.setBounds(214, 67, 130, 20);
		frame.getContentPane().add(tfDescripcion);
		
		JLabel lblUnidadDeMedida = new JLabel("Unidad de medida: ");
		lblUnidadDeMedida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnidadDeMedida.setBounds(10, 98, 200, 14);
		frame.getContentPane().add(lblUnidadDeMedida);
		lblUnidadDeMedida.setForeground(beige);
		
		JLabel lblCostoPorUnidad = new JLabel("Costo por unidad: ");
		lblCostoPorUnidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoPorUnidad.setBounds(10, 126, 200, 14);
		frame.getContentPane().add(lblCostoPorUnidad);
		lblCostoPorUnidad.setForeground(beige);
		
		tfCosto = new JTextField();
		tfCosto.setColumns(10);
		tfCosto.setBounds(214, 123, 130, 20);
		frame.getContentPane().add(tfCosto);
		
		JLabel lblRef = new JLabel("¿Es refrigerado? ");
		lblRef.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRef.setBounds(10, 148, 200, 14);
		frame.getContentPane().add(lblRef);
		lblRef.setForeground(beige);
		
		JComboBox cbUnidad = new JComboBox();
		cbUnidad.setModel(new DefaultComboBoxModel(UnidadMedida.values()));
		cbUnidad.setBounds(214, 95, 130, 20);
		frame.getContentPane().add(cbUnidad);
		
		JRadioButton siR = new JRadioButton("Si");
		siR.setBounds(214, 144, 46, 23);
		frame.getContentPane().add(siR);
		siR.setForeground(beige);
		siR.setBackground(azul);
		JRadioButton noR = new JRadioButton("No");
		noR.setBounds(298, 144, 46, 23);
		frame.getContentPane().add(noR);
		noR.setForeground(beige);
		noR.setBackground(azul);
		JLabel lblesLquido = new JLabel("¿Es líquido? ");
		lblesLquido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblesLquido.setBounds(10, 173, 200, 14);
		frame.getContentPane().add(lblesLquido);
		lblesLquido.setForeground(beige);
		
		JRadioButton noL = new JRadioButton("No");
		noL.setBounds(298, 170, 46, 23);
		frame.getContentPane().add(noL);
		noL.setForeground(beige);
		noL.setBackground(azul);
		JRadioButton siL = new JRadioButton("Si");
		siL.setBounds(214, 170, 46, 23);
		frame.getContentPane().add(siL);
		siL.setForeground(beige);
		siL.setBackground(azul);
		buttonGroupRefrigerado.add(noR);
		buttonGroupRefrigerado.add(siR);
		buttonGroupLiquidos.add(noL);
		buttonGroupLiquidos.add(siL);
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setBounds(10, 198, 200, 14);
		frame.getContentPane().add(lblPeso);
		lblPeso.setVisible(false);
		lblPeso.setForeground(beige);
		
		JTextField tfPeso = new JTextField();
		tfPeso.setColumns(10);
		tfPeso.setBounds(214, 195, 130, 20);
		frame.getContentPane().add(tfPeso);
		tfPeso.setVisible(false);
		
		JLabel lblDensidad = new JLabel("Densidad: ");
		lblDensidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDensidad.setBounds(10, 198, 200, 14);
		frame.getContentPane().add(lblDensidad);
		lblDensidad.setVisible(false);
		lblDensidad.setForeground(beige);
		
		JTextField tfDensidad = new JTextField();
		tfDensidad.setColumns(10);
		tfDensidad.setBounds(214, 195, 130, 20);
		frame.getContentPane().add(tfDensidad);
		tfDensidad.setVisible(false);
		
		JLabel lblVol = new JLabel("Volumen: ");
		lblVol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVol.setBounds(10, 229, 200, 14);
		frame.getContentPane().add(lblVol);
		lblVol.setVisible(false);
		lblVol.setForeground(beige);
		
		JTextField tfVol = new JTextField();
		tfVol.setColumns(10);
		tfVol.setBounds(214, 226, 130, 20);
		frame.getContentPane().add(tfVol);
		tfVol.setVisible(false);
		
		siL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPeso.setVisible(false);
				lblDensidad.setVisible(true);
				lblVol.setVisible(true);
				tfPeso.setVisible(false);
				tfDensidad.setVisible(true);
				tfVol.setVisible(true);
			}
		});
		
		noL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPeso.setVisible(true);
				lblDensidad.setVisible(false);
				lblVol.setVisible(false);
				tfPeso.setVisible(true);
				tfDensidad.setVisible(false);
				tfVol.setVisible(false);
			}
		});
		JButton agregarInsumo = new JButton("Agregar Insumo");
		agregarInsumo.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				String id=tfId.getText();
				String descripcion=tfDescripcion.getText();
				int stockTotal=0;
				double costo=Double.parseDouble(tfCosto.getText());
				boolean esRefrigerado=false;
				if(siR.isSelected()) {
					esRefrigerado=true;
				}
				UnidadMedida unidad= UnidadMedida.valueOf(cbUnidad.getSelectedItem().toString());
				ArrayList<Insumo> listaI = datos.getListaInsumos();
				if(siL.isSelected()) {
					double densidad=Double.parseDouble(tfDensidad.getText());
					double volumen=Double.parseDouble(tfVol.getText());
					InsumoLiquido nuevoInsumo = new InsumoLiquido(id,descripcion,stockTotal,densidad,volumen,costo,esRefrigerado, unidad);
					listaI.add(nuevoInsumo);
					datos.setListaInsumos(listaI);
				}else {
					double peso=Double.parseDouble(tfPeso.getText());
					Insumo nuevoInsumo = new Insumo(id,descripcion,stockTotal,peso,costo,esRefrigerado, unidad);
					listaI.add(nuevoInsumo);
					datos.setListaInsumos(listaI);
				}
				new GestionInsumos(datos);
				frame.dispose();
			}
		});
		agregarInsumo.setBounds(344, 305, 130, 25);
		agregarInsumo.setForeground(beige);
		agregarInsumo.setBackground(rojo);
		frame.getContentPane().add(agregarInsumo);
		
		frame.setVisible(true);
	}
}
