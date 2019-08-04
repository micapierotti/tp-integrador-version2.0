package isi.died.tp.pantallas;

import javax.swing.JFrame;

import isi.died.tp.app.App;
import isi.died.tp.datos.Datos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionPlantas {

	private JFrame frame;
	private Datos datos;
	private final JButton btnVerPlantras = new JButton("Ver plantas");

	public GestionPlantas(Datos datos) {
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Gestión de Plantas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		btnVerPlantras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		frame.getContentPane().setLayout(null);
		
		JButton btnVerPlantas = new JButton("Ver plantas");
		btnVerPlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VerPlantas(datos);
				frame.dispose();
			}
		});
		btnVerPlantas.setBounds(144, 41, 130, 40);
		frame.getContentPane().add(btnVerPlantas);
		
		JButton btnCrearPlanta = new JButton("Crear planta");
		btnCrearPlanta.setBounds(144, 92, 130, 40);
		frame.getContentPane().add(btnCrearPlanta);
		btnCrearPlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CrearPlanta(datos);
				frame.dispose();
			}
		});
		
		JButton btnBuscarPlanta = new JButton("Buscar planta");
		btnBuscarPlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarPlanta(datos);
				frame.dispose();
			}
		});
		btnBuscarPlanta.setBounds(144, 143, 130, 40);
		frame.getContentPane().add(btnBuscarPlanta);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new App(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnSalir.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnSalir);
		
		frame.setVisible(true);
	}
}
