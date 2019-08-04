
package isi.died.tp.pantallas;

import javax.swing.JFrame;

import isi.died.tp.app.App;
import isi.died.tp.datos.Datos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionTransporte {

	private JFrame frame;
	private Datos datos;
	
	public GestionTransporte(Datos datos) {
		this.datos=datos;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Gestión de Transporte");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnAgregarCamin = new JButton("Agregar camión");
		btnAgregarCamin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CrearCamion(datos);
				frame.dispose();
			}
		});
		btnAgregarCamin.setBounds(147, 60, 130, 40);
		frame.getContentPane().add(btnAgregarCamin);
		
		JButton btnBuscarCamin = new JButton("Buscar camión");
		btnBuscarCamin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarCamion(datos);
				frame.dispose();
			}
		});
		btnBuscarCamin.setBounds(147, 120, 130, 40);
		frame.getContentPane().add(btnBuscarCamin);
		
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
