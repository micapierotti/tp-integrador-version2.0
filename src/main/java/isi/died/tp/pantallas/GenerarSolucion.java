package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Camion;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import javax.swing.JLabel;

public class GenerarSolucion {

	private JFrame frame;
	private JTable table;
	private Datos datos;
	private Planta planta;
	private Camion camion;
	public GenerarSolucion(Datos datos, Planta planta, Camion camion) {
		this.planta=planta;
		this.camion=camion;
		this.datos=datos;
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Generar Solución");
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 62, 380, 128);
		frame.getContentPane().add(scrollPane);
		
		ArrayList<Insumo> listaInsumos = camion.insumoOptimos(planta);
		
		Object[][] datosTabla = null;
		String[] columnas= {"Insumo", "Cantidad Transportada", "Valor"};
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setModel(new DefaultTableModel(datosTabla,columnas));
		scrollPane.setViewportView(table);
		
		JButton salir = new JButton("Realizar envío");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SeleccionEnvio(datos);
				frame.dispose();
			}
		});
		salir.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(salir);
		
		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SeleccionEnvio(datos);
				frame.dispose();
			}
		});
		atras.setBounds(10, 226, 100, 25);
		frame.getContentPane().add(atras);
		
		JLabel lblCamion = new JLabel("Camión: "+camion.getDominio());
		lblCamion.setBounds(30, 26, 138, 14);
		frame.getContentPane().add(lblCamion);
		
		JLabel lblHaciaPlanta = new JLabel("Hacia planta:"+planta.getNombre());
		lblHaciaPlanta.setBounds(232, 26, 178, 14);
		frame.getContentPane().add(lblHaciaPlanta);
		
		
	}
}
