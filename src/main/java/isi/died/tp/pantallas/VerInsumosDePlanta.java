package isi.died.tp.pantallas;

import javax.swing.JFrame;
import javax.swing.JTable;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VerInsumosDePlanta {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblIdPlanta;
	private JLabel lblNombrePlanta;
	private static Planta planta;
	private Datos datos;
	
	public VerInsumosDePlanta(Planta pl,Datos datos) {
		this.datos=datos;
		planta = pl;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Ver Insumos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpcionesPlanta(planta,datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
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
		lblId.setBounds(14, 21, 46, 14);
		frame.getContentPane().add(lblId);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(0, 39, 60, 14);
		frame.getContentPane().add(lblNombre);
		
		String id = Integer.toString(planta.getId());
		lblIdPlanta = new JLabel(id);
		lblIdPlanta.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdPlanta.setBounds(79, 21, 46, 14);
		frame.getContentPane().add(lblIdPlanta);
		
		lblNombrePlanta = new JLabel(planta.getNombre());
		lblNombrePlanta.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombrePlanta.setBounds(79, 39, 140, 14);
		frame.getContentPane().add(lblNombrePlanta);
		
		frame.setVisible(true);
	}
}
