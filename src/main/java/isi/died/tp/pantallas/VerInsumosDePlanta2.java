package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;

public class VerInsumosDePlanta2 {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblIdPlanta;
	private JLabel lblNombrePlanta;
	private static Planta planta;
	private JTable table;
	private Datos datos;
	
	public VerInsumosDePlanta2(Planta pl,Datos datos) {
		this.datos=datos;
		planta=pl;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Ver Insumos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VerPlantas(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		btnAtrs.setForeground(beige);
		btnAtrs.setBackground(rojo);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 64, 402, 144);
		frame.getContentPane().add(scrollPane);
		
		Object[][] datosStocks= planta.getDatosStock();
		String[] columnas= {"Insumo","Cantidad","Cantidad Mínima"};
		
		table = new JTable(datosStocks, columnas);
		table.editingCanceled(null);
		scrollPane.setViewportView(table);
		
		lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(18, 21, 46, 14);
		frame.getContentPane().add(lblId);
		lblId.setForeground(beige);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(4, 39, 60, 14);
		frame.getContentPane().add(lblNombre);
		lblNombre.setForeground(beige);
		
		String id = Integer.toString(planta.getId());
		lblIdPlanta = new JLabel(id);
		lblIdPlanta.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdPlanta.setBounds(79, 21, 46, 14);
		frame.getContentPane().add(lblIdPlanta);
		lblIdPlanta.setForeground(beige);
		
		lblNombrePlanta = new JLabel(planta.getNombre());
		lblNombrePlanta.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombrePlanta.setBounds(79, 39, 140, 14);
		frame.getContentPane().add(lblNombrePlanta);
		lblNombrePlanta.setForeground(beige);
		
		frame.setVisible(true);
	}
}
