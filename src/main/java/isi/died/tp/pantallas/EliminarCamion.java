package isi.died.tp.pantallas;

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
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(129, 40, 50, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dominio:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(129, 65, 50, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel idCam = new JLabel(camion.getId());
		idCam.setHorizontalAlignment(SwingConstants.LEFT);
		idCam.setBounds(190, 40, 80, 14);
		frame.getContentPane().add(idCam);
		
		JLabel domCam = new JLabel(camion.getDominio());
		domCam.setHorizontalAlignment(SwingConstants.LEFT);
		domCam.setBounds(189, 65, 140, 14);
		frame.getContentPane().add(domCam);
		
		JLabel lbldeseaEliminarLa = new JLabel("Si presiona \"Eliminar\" el camión seleccionado\r\n");
		lbldeseaEliminarLa.setLabelFor(frame);
		lbldeseaEliminarLa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldeseaEliminarLa.setHorizontalAlignment(SwingConstants.CENTER);
		lbldeseaEliminarLa.setBounds(79, 156, 275, 14);
		frame.getContentPane().add(lbldeseaEliminarLa);
		
		JLabel lblSeEliminarPermanentemente = new JLabel(" se eliminará permanentemente.");
		lblSeEliminarPermanentemente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeEliminarPermanentemente.setLabelFor(frame);
		lblSeEliminarPermanentemente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeEliminarPermanentemente.setBounds(101, 170, 228, 14);
		frame.getContentPane().add(lblSeEliminarPermanentemente);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarCamion(datos);
				frame.dispose();
			}
		});
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
		btnEliminar.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnEliminar);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidad.setBounds(79, 90, 100, 14);
		frame.getContentPane().add(lblCapacidad);
		
		JLabel lblAptoParaLquidos = new JLabel("Apto para líquidos:");
		lblAptoParaLquidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAptoParaLquidos.setBounds(39, 118, 140, 14);
		frame.getContentPane().add(lblAptoParaLquidos);
		
		JLabel capCam = new JLabel(Double.toString(camion.getCapacidad()));
		capCam.setHorizontalAlignment(SwingConstants.LEFT);
		capCam.setBounds(190, 90, 80, 14);
		frame.getContentPane().add(capCam);
		
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
		
		frame.setVisible(true);
	}

}
