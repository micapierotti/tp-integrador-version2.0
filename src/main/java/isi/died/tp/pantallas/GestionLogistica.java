package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import isi.died.tp.app.App;
import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;

public class GestionLogistica {

	private JFrame frame;
	private Datos datos;

	public GestionLogistica(Datos datos) {
		this.datos=datos;
		System.out.println("Gestion Logistica");
		for(Planta planta:datos.getListaPlantasNormal()) {
			System.out.println(planta.getNombre());
		}
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestión Logística");
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		JButton gestionPlantas = new JButton("Ver Mapa de Plantas");
		gestionPlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MapaPlantas(datos);
				frame.dispose();
			}
		});
		gestionPlantas.setBounds(27, 37, 170, 40);
		frame.getContentPane().add(gestionPlantas);
		gestionPlantas.setForeground(azul);
		gestionPlantas.setBackground(beige);
		JButton gestionLogistica = new JButton("Agregar Ruta");
		gestionLogistica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CrearRuta(datos);
				frame.dispose();
			}
		});
		gestionLogistica.setBounds(224, 37, 170, 40);
		frame.getContentPane().add(gestionLogistica);
		gestionLogistica.setForeground(azul);
		gestionLogistica.setBackground(beige);
		JButton gestionInsumos = new JButton("Flujo Máximo de Red");
		gestionInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FlujoMaximo(datos);
				frame.dispose();
			}
		});
		gestionInsumos.setBounds(27, 88, 170, 40);
		frame.getContentPane().add(gestionInsumos);
		gestionInsumos.setForeground(azul);
		gestionInsumos.setBackground(beige);
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		salir.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(salir);
		salir.setForeground(beige);
		salir.setBackground(rojo);
		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new App(datos);
				frame.dispose();
			}
		});
		atras.setBounds(10, 226, 100, 25);
		frame.getContentPane().add(atras);
		atras.setForeground(beige);
		atras.setBackground(rojo);
		JButton btnSeleccinDeEnvo = new JButton("Selección de Envío");
		btnSeleccinDeEnvo.setBounds(27, 139, 170, 40);
		frame.getContentPane().add(btnSeleccinDeEnvo);
		btnSeleccinDeEnvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SeleccionEnvio(datos);
				frame.dispose();
			}
		});
		btnSeleccinDeEnvo.setForeground(azul);
		btnSeleccinDeEnvo.setBackground(beige);
		JButton btnBuscarRuta = new JButton("Buscar Ruta");
		btnBuscarRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarRuta(datos);
				frame.dispose();
			}
		});
		btnBuscarRuta.setBounds(224, 88, 170, 40);
		frame.getContentPane().add(btnBuscarRuta);
		btnBuscarRuta.setForeground(azul);
		btnBuscarRuta.setBackground(beige);
		JButton btnCaminosEntrePlantas = new JButton("Caminos entre plantas");
		btnCaminosEntrePlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CaminoPlantaInicial(datos);
				frame.dispose();
			}
		});
		btnCaminosEntrePlantas.setBounds(224, 139, 170, 40);
		frame.getContentPane().add(btnCaminosEntrePlantas);
		btnCaminosEntrePlantas.setForeground(azul);
		btnCaminosEntrePlantas.setBackground(beige);
		frame.setVisible(true);
	}

}
