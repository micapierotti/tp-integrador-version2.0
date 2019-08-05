package isi.died.tp.pantallas;

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
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionLogistica(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(168, 227, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		JLabel lblElPesoA = new JLabel("El peso a transportar maximo para el flujo maximo de red es:");
		lblElPesoA.setBounds(10, 58, 414, 14);
		frame.getContentPane().add(lblElPesoA);
		
		System.out.println(datos.getGrafo().flujoMaximo());
		
		JLabel lblA = new JLabel(String.valueOf(datos.getGrafo().flujoMaximo()));
		lblA.setBounds(184, 101, 46, 14);
		frame.getContentPane().add(lblA);
		
		frame.setVisible(true);
	}
}
