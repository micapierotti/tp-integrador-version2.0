package isi.died.tp.pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EliminarPlanta {

	private JFrame frame;
	private static Planta planta;
	private Datos datos;

	public EliminarPlanta(Planta pl, Datos datos) {
		this.datos=datos;
		planta=pl;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Eliminar Planta");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(129, 59, 50, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(beige);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(129, 81, 50, 14);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setForeground(beige);
		
		String id = Integer.toString(planta.getId());
		JLabel lblIdPlanta = new JLabel(id);
		lblIdPlanta.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdPlanta.setBounds(190, 59, 80, 14);
		frame.getContentPane().add(lblIdPlanta);
		lblIdPlanta.setForeground(beige);
		
		JLabel lblNombrePlanta = new JLabel(planta.getNombre());
		lblNombrePlanta.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombrePlanta.setBounds(190, 81, 140, 14);
		frame.getContentPane().add(lblNombrePlanta);
		lblNombrePlanta.setForeground(beige);
		
		JLabel lbldeseaEliminarLa = new JLabel("Si presiona \"Eliminar\" la planta seleccionada\r\n");
		lbldeseaEliminarLa.setLabelFor(frame);
		lbldeseaEliminarLa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldeseaEliminarLa.setHorizontalAlignment(SwingConstants.CENTER);
		lbldeseaEliminarLa.setBounds(81, 143, 275, 14);
		frame.getContentPane().add(lbldeseaEliminarLa);
		lbldeseaEliminarLa.setForeground(beige);
		
		JLabel lblSeEliminarPermanentemente = new JLabel(" se eliminará permanentemente.");
		lblSeEliminarPermanentemente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeEliminarPermanentemente.setLabelFor(frame);
		lblSeEliminarPermanentemente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeEliminarPermanentemente.setBounds(99, 160, 228, 14);
		frame.getContentPane().add(lblSeEliminarPermanentemente);
		lblSeEliminarPermanentemente.setForeground(beige);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpcionesPlanta(planta,datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		btnAtrs.setForeground(beige);
		btnAtrs.setBackground(rojo);
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datos.eliminarPlanta(planta);
				new BuscarPlanta(datos);
				frame.dispose();
			}
			
		});
		btnEliminar.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnEliminar);
		btnEliminar.setForeground(beige);
		btnEliminar.setBackground(rojo);
		frame.setVisible(true);
	}

}
