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
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 62, 380, 128);
		frame.getContentPane().add(scrollPane);
System.out.println("Insumos optimos "+camion.insumoOptimos(planta));
		
		Object[][] datosTabla = generarDatos(camion.insumoOptimos(planta));
		String[] columnas= {"Insumo"};
		
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
		salir.setBounds(294, 226, 130, 25);
		frame.getContentPane().add(salir);
		salir.setForeground(beige);
		salir.setBackground(rojo);
		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SeleccionEnvio(datos);
				frame.dispose();
			}
		});
		atras.setBounds(10, 226, 100, 25);
		frame.getContentPane().add(atras);
		atras.setForeground(beige);
		atras.setBackground(rojo);
		JLabel lblCamion = new JLabel("Camión: "+camion.getDominio());
		lblCamion.setBounds(30, 26, 138, 14);
		frame.getContentPane().add(lblCamion);
		lblCamion.setForeground(beige);
		
		JLabel lblHaciaPlanta = new JLabel("Hacia planta:"+planta.getNombre());
		lblHaciaPlanta.setBounds(232, 26, 178, 14);
		frame.getContentPane().add(lblHaciaPlanta);
		lblHaciaPlanta.setForeground(beige);
		
		
	}
	private Object[][] generarDatos(ArrayList<Insumo> listaInsumos2){
		Object[][] tabla = new Object[listaInsumos2.size()][1];
		
		for(int i=0;i<listaInsumos2.size();i++) {
			tabla[i][0]=listaInsumos2.get(i).getDescripcion();
		}
		return tabla;
	}
}
