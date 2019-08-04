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

public class CrearPlanta {

	private JFrame frame;
	private JTextField textIDPlanta;
	private JTextField txtNombrePlanta;
	private Datos datos;

	public CrearPlanta(Datos datos) {
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ingresar nueva planta");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(124, 40, 18, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(85, 65, 57, 14);
		frame.getContentPane().add(lblNombre);
		
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
		frame.getContentPane().add(btnAtrs);
		
		JButton btnIngresarPlanta = new JButton("Ingresar planta");
		btnIngresarPlanta.setBounds(303, 227, 121, 23);
		frame.getContentPane().add(btnIngresarPlanta);
		btnIngresarPlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nuevoID;
				nuevoID= Integer.parseInt(textIDPlanta.getText());
				String nuevoNom = new String();
				nuevoNom = txtNombrePlanta.getText();
				
				Planta nuevaPlanta = new Planta(nuevoID, nuevoNom);
				ArrayList<Planta> listaP = datos.getListaPlantas();
				listaP.add(nuevaPlanta);
				datos.setListaPlantas(listaP);
				new GestionPlantas(datos);
				frame.dispose();
			}
		});
		frame.setVisible(true);
	}
}
