package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Camion;

public class EliminarCamion {

	private JFrame frame;
	private static Camion camion;
	private Datos datos;

	public EliminarCamion(Camion cam,Datos datos) {
		this.datos=datos;
		camion=cam;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Eliminar Camión");
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
		lblNewLabel.setBounds(129, 40, 50, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(beige);
		
		JLabel lblNewLabel_1 = new JLabel("Dominio:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(129, 65, 50, 14);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setForeground(beige);
		
		JLabel idCam = new JLabel(camion.getId());
		idCam.setHorizontalAlignment(SwingConstants.LEFT);
		idCam.setBounds(190, 40, 80, 14);
		frame.getContentPane().add(idCam);
		idCam.setForeground(beige);
		
		JLabel domCam = new JLabel(camion.getDominio());
		domCam.setHorizontalAlignment(SwingConstants.LEFT);
		domCam.setBounds(189, 65, 140, 14);
		frame.getContentPane().add(domCam);
		domCam.setForeground(beige);
		
		JLabel lbldeseaEliminarLa = new JLabel("Si presiona \"Eliminar\" el camión seleccionado\r\n");
		lbldeseaEliminarLa.setLabelFor(frame);
		lbldeseaEliminarLa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldeseaEliminarLa.setHorizontalAlignment(SwingConstants.CENTER);
		lbldeseaEliminarLa.setBounds(79, 156, 275, 14);
		frame.getContentPane().add(lbldeseaEliminarLa);
		lbldeseaEliminarLa.setForeground(beige);
		
		JLabel lblSeEliminarPermanentemente = new JLabel(" se eliminará permanentemente.");
		lblSeEliminarPermanentemente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeEliminarPermanentemente.setLabelFor(frame);
		lblSeEliminarPermanentemente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeEliminarPermanentemente.setBounds(101, 170, 228, 14);
		frame.getContentPane().add(lblSeEliminarPermanentemente);
		lblSeEliminarPermanentemente.setForeground(beige);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarCamion(datos);
				frame.dispose();
			}
		});
		btnAtrs.setForeground(beige);
		btnAtrs.setBackground(rojo);
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Camion> listaC = datos.getListaCamiones();
				listaC.remove(camion);
				datos.setListaCamiones(listaC);
				new BuscarCamion(datos);
				frame.dispose();
			}
			
		});
		btnEliminar.setForeground(beige);
		btnEliminar.setBackground(rojo);
		btnEliminar.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnEliminar);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidad.setBounds(79, 90, 100, 14);
		frame.getContentPane().add(lblCapacidad);
		lblCapacidad.setForeground(beige);
		
		JLabel lblAptoParaLquidos = new JLabel("Apto para líquidos:");
		lblAptoParaLquidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAptoParaLquidos.setBounds(39, 118, 140, 14);
		frame.getContentPane().add(lblAptoParaLquidos);
		lblAptoParaLquidos.setForeground(beige);
		
		JLabel capCam = new JLabel(Double.toString(camion.getCapacidad()));
		capCam.setHorizontalAlignment(SwingConstants.LEFT);
		capCam.setBounds(190, 90, 80, 14);
		frame.getContentPane().add(capCam);
		capCam.setForeground(beige);
		
		String liq = new String();
		if(camion.isAptoLiq()) {
			liq = "Si";
		}else {
			liq = "No";
		}
		JLabel liqCam = new JLabel(liq);
		liqCam.setHorizontalAlignment(SwingConstants.LEFT);
		liqCam.setBounds(190, 118, 140, 14);
		frame.getContentPane().add(liqCam);
		liqCam.setForeground(beige);
		
		frame.setVisible(true);
	}

}
