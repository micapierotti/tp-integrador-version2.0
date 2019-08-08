
package isi.died.tp.pantallas;

import javax.swing.JFrame;

import isi.died.tp.app.App;
import isi.died.tp.datos.Datos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
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
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		JButton btnAgregarCamin = new JButton("Agregar camión");
		btnAgregarCamin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CrearCamion(datos);
				frame.dispose();
			}
		});
		btnAgregarCamin.setBounds(147, 60, 130, 40);
		frame.getContentPane().add(btnAgregarCamin);
		btnAgregarCamin.setForeground(azul);
		btnAgregarCamin.setBackground(beige);
		JButton btnBuscarCamin = new JButton("Buscar camión");
		btnBuscarCamin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarCamion(datos);
				frame.dispose();
			}
		});
		btnBuscarCamin.setBounds(147, 120, 130, 40);
		frame.getContentPane().add(btnBuscarCamin);
		btnBuscarCamin.setForeground(azul);
		btnBuscarCamin.setBackground(beige);
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new App(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		btnAtrs.setForeground(beige);
		btnAtrs.setBackground(rojo);
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnSalir.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnSalir);
		btnSalir.setForeground(beige);
		btnSalir.setBackground(rojo);
		frame.setVisible(true);
	}

}
