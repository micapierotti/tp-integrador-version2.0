package isi.died.tp.pantallas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CrearPlanta {

	private JFrame frame;
	private JTextField textIDPlanta;
	private JTextField txtNombrePlanta;
	private Datos datos;

	public CrearPlanta(Datos datos1) {
		this.datos=datos1;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setTitle("Ingresar nueva planta");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(124, 40, 18, 14);
		frame.getContentPane().add(lblId);
		lblId.setForeground(beige);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(85, 65, 57, 14);
		frame.getContentPane().add(lblNombre);
		lblNombre.setForeground(beige);
		
		textIDPlanta = new JTextField();
		
		textIDPlanta.setBounds(165, 37, 86, 20);
		frame.getContentPane().add(textIDPlanta);
		textIDPlanta.setColumns(10);
		
		txtNombrePlanta = new JTextField();
		txtNombrePlanta.setBounds(165, 62, 86, 20);
		frame.getContentPane().add(txtNombrePlanta);
		txtNombrePlanta.setColumns(10);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionPlantas(datos);
				frame.dispose();
			}
		});
		
		btnAtrs.setBounds(10, 227, 89, 23);
		btnAtrs.setForeground(beige);
		btnAtrs.setBackground(rojo);
		frame.getContentPane().add(btnAtrs);
		
		JButton btnIngresarPlanta = new JButton("Ingresar planta");
		btnIngresarPlanta.setBounds(303, 227, 121, 23);
		frame.getContentPane().add(btnIngresarPlanta);
		btnIngresarPlanta.setForeground(beige);
		btnIngresarPlanta.setBackground(rojo);
		JLabel lblElIdYa = new JLabel("El ID ya existe.");
		lblElIdYa.setForeground(Color.RED);
		lblElIdYa.setBounds(261, 40, 100, 14);
		frame.getContentPane().add(lblElIdYa);
		lblElIdYa.setVisible(false);
		
		textIDPlanta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				String id = textIDPlanta.getText();
				if(id!="") {
				int idIngresado= Integer.parseInt(id);
				boolean esUnico = datos.idUnicoPlanta(idIngresado);
				if (esUnico) {
					btnIngresarPlanta.setEnabled(true);
					lblElIdYa.setVisible(false);
				}else {
					lblElIdYa.setVisible(true);
					btnIngresarPlanta.setEnabled(false);
				}
				}else {
					
				}
			}
		});
	
		btnIngresarPlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Lista de plantas en datos antes");
				for(Planta planta:datos.getListaPlantasNormal()) {
					System.out.println(planta.getNombre());
				}
				int nuevoID;
				nuevoID= Integer.parseInt(textIDPlanta.getText());
				String nuevoNom = new String();
				nuevoNom = txtNombrePlanta.getText();
				
				Planta nuevaPlanta = new Planta(nuevoID, nuevoNom);

				//datos.setListaPlantas(listaP);
				datos.agregarPlanta(nuevaPlanta);
				System.out.println("Ingresar Planta");
				for(Planta planta:datos.getListaPlantasNormal()) {
					System.out.println(planta.getNombre());
				}
				new GestionPlantas(datos);
				frame.dispose();
			}
		});
		frame.setVisible(true);
	}
}
