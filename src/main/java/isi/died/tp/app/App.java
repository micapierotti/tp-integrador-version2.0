package isi.died.tp.app;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import isi.died.tp.datos.Datos;
import isi.died.tp.pantallas.GestionInsumos;
import isi.died.tp.pantallas.GestionLogistica;
import isi.died.tp.pantallas.GestionPlantas;
import isi.died.tp.pantallas.GestionTransporte;

public class App {

	private JFrame frame;
	private Datos datos;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public App() {
		datos = new Datos();
		initialize();
	}
	
	public App(Datos datosActual) {
		datos = datosActual;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Menú");
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton gestionPlantas = new JButton("Gestión de Plantas");
		gestionPlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionPlantas(datos);
				frame.dispose();
			}
		});
		gestionPlantas.setBounds(33, 60, 170, 40);
		frame.getContentPane().add(gestionPlantas);
		
		JButton gestionLogistica = new JButton("Gestión de Logística");
		gestionLogistica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionLogistica(datos);
				frame.dispose();
			}
		});
		gestionLogistica.setBounds(33, 120, 170, 40);
		frame.getContentPane().add(gestionLogistica);
		
		JButton gestionInsumos = new JButton("Gestión de Insumos");
		gestionInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionInsumos(datos);
				frame.dispose();
			}
		});
		
		gestionInsumos.setBounds(230, 60, 170, 40);
		frame.getContentPane().add(gestionInsumos);
		
		JButton gestionTransporte = new JButton("Gestión de Transporte");
		gestionTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionTransporte(datos);
				frame.dispose();
			}
		});
		
		gestionTransporte.setBounds(230, 120, 170, 40);
		frame.getContentPane().add(gestionTransporte);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		salir.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(salir);
	}
}
