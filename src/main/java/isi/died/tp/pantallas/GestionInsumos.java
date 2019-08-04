package isi.died.tp.pantallas;

import javax.swing.JFrame;
import isi.died.tp.app.App;
import isi.died.tp.datos.Datos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionInsumos {

	private JFrame frame;
	private Datos datos;
	
	public GestionInsumos(Datos datos) {
		this.datos=datos;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Gestión de Insumos");
		
		JButton btnCrearInsumo = new JButton("Crear Insumo");
		btnCrearInsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CrearInsumo(datos);
				frame.dispose();
			}
		});
		btnCrearInsumo.setBounds(143, 68, 140, 40);
		frame.getContentPane().add(btnCrearInsumo);
		
		JButton btnBucarInsumo = new JButton("Buscar Insumo");
		btnBucarInsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new BuscarInsumo(datos);
				frame.dispose();
			}
		});
		
		btnBucarInsumo.setBounds(143, 132, 140, 40);
		frame.getContentPane().add(btnBucarInsumo);
		
		JButton btnNewButton = new JButton("Atrás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new App(datos);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 227, 100, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(324, 227, 100, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setVisible(true);
	}
}
