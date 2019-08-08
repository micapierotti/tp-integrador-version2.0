package isi.died.tp.pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EditarPlanta {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtPlanta;
	private static Planta planta;
	private Datos datos;

	public EditarPlanta(Planta pl, Datos datos) {
		this.datos=datos;
		planta=pl;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Editar Planta");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(135, 55, 50, 14);
		frame.getContentPane().add(lblId);
		lblId.setForeground(beige);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(135, 80, 50, 14);
		frame.getContentPane().add(lblNombre);
		lblNombre.setForeground(beige);
		
		textField = new JTextField();
		textField.setForeground(Color.GRAY);
		textField.setBounds(195, 52, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(Integer.toString(planta.getId()));
		textField.setEditable(false);
		
		txtPlanta = new JTextField();
		txtPlanta.setBounds(195, 77, 86, 20);
		frame.getContentPane().add(txtPlanta);
		txtPlanta.setColumns(10);
		txtPlanta.setText(planta.getNombre());
		
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
		JButton btnAceptar = new JButton("Guardar cambios");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Planta> listaP = datos.getListaPlantas();
				listaP.remove(planta);
				String nombreP= txtPlanta.getText();
				planta.setNombre(nombreP);
				listaP.add(planta);
				datos.setListaPlantas(listaP);
				new OpcionesPlanta(planta,datos);
				frame.dispose();
			}
		});
		btnAceptar.setBounds(271, 225, 153, 25);
		btnAceptar.setForeground(beige);
		btnAceptar.setBackground(rojo);
		frame.getContentPane().add(btnAceptar);
		
		JButton btnAgregarStockA = new JButton("Editar insumos");
		btnAgregarStockA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarInsumosDePlanta(planta,datos);
				frame.dispose();
			}
		});
		btnAgregarStockA.setBounds(141, 120, 141, 40);
		frame.getContentPane().add(btnAgregarStockA);
		btnAgregarStockA.setForeground(azul);
		btnAgregarStockA.setBackground(beige);
		frame.setVisible(true);
	}
}
