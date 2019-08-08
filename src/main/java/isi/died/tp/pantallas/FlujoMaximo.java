package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import isi.died.tp.app.App;
import isi.died.tp.datos.Datos;
import javax.swing.JLabel;

public class FlujoMaximo {

	private JFrame frame;
	private Datos datos;

	public FlujoMaximo(Datos datos) {
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Flujo Máximo de Red");
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionLogistica(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		btnAtrs.setForeground(beige);
		btnAtrs.setBackground(rojo);
		JLabel lblElPesoA = new JLabel("El peso a transportar maximo para el flujo maximo de red es:");
		lblElPesoA.setBounds(48, 76, 414, 14);
		frame.getContentPane().add(lblElPesoA);
		lblElPesoA.setForeground(beige);
		
		//System.out.println(datos.getGrafo().flujoMaximo());
		
		JLabel lblA = new JLabel(String.valueOf(datos.getGrafo().flujoMaximo()));
		lblA.setBounds(203, 120, 46, 14);
		frame.getContentPane().add(lblA);
		lblA.setForeground(beige);
		
		frame.setVisible(true);
	}
}
