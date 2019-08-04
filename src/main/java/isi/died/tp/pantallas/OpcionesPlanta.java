package isi.died.tp.pantallas;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.*;

public class OpcionesPlanta {

	private JFrame frame;
	private static Planta planta;
	private Datos datos;

	public OpcionesPlanta(Planta pl,Datos datos) {
		this.datos=datos;
		planta=pl;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Opciones");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnEditarPlanta = new JButton("Editar planta");
		btnEditarPlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarPlanta(planta,datos);
				frame.dispose();
			}
		});
		btnEditarPlanta.setBounds(150, 138, 130, 35);
		frame.getContentPane().add(btnEditarPlanta);
		
		JButton btnEliminarPlanta = new JButton("Eliminar planta");
		btnEliminarPlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EliminarPlanta(planta,datos);
				frame.dispose();
			}
		});
		btnEliminarPlanta.setBounds(150, 180, 130, 35);
		frame.getContentPane().add(btnEliminarPlanta);
		
		JLabel lblPlantaSeleccionada = new JLabel("Nombre:");
		lblPlantaSeleccionada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlantaSeleccionada.setBounds(85, 64, 60, 20);
		frame.getContentPane().add(lblPlantaSeleccionada);
		
		JLabel lblNombre = new JLabel(planta.getNombre());
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setBounds(155, 64, 140, 20);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(85, 38, 60, 20);
		frame.getContentPane().add(lblId);
		
		JLabel lblIdPl = new JLabel(Integer.toString(planta.getId()));
		lblIdPl.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdPl.setBounds(155, 38, 60, 20);
		frame.getContentPane().add(lblIdPl);
		
		JButton btnVerInsumos = new JButton("Ver insumos");
		btnVerInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VerInsumosDePlanta(planta,datos);
				frame.dispose();
			}
		});
		btnVerInsumos.setBounds(150, 95, 130, 35);
		frame.getContentPane().add(btnVerInsumos);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarPlanta(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionPlantas(datos);
				frame.dispose();
			}
		});
		btnAceptar.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnAceptar);
		
		frame.setVisible(true);
	}
}
