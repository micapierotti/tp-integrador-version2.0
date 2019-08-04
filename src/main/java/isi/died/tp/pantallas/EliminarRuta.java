package isi.died.tp.pantallas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Ruta;

public class EliminarRuta {

	private JFrame frame;
	private Datos datos;
	private static Ruta ruta;

	public EliminarRuta(Ruta r, Datos dat) {
		ruta=r;
		System.out.println(ruta.getInicio().getValor().getNombre());
		System.out.println(ruta.getFin().getValor().getNombre());
		datos=dat;
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Eliminar ruta");
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarRuta(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		JLabel lblNombrePlantaOrigen = new JLabel("Nombre planta origen:");
		lblNombrePlantaOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePlantaOrigen.setBounds(20, 30, 170, 14);
		frame.getContentPane().add(lblNombrePlantaOrigen);
		
		JLabel lblNombrePlantaDestino = new JLabel("Nombre planta destino:");
		lblNombrePlantaDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePlantaDestino.setBounds(20, 55, 170, 14);
		frame.getContentPane().add(lblNombrePlantaDestino);
		
		JLabel lblDistancia = new JLabel("Distancia:");
		lblDistancia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDistancia.setBounds(120, 80, 70, 14);
		frame.getContentPane().add(lblDistancia);
		
		JLabel lblKms = new JLabel("kms");
		lblKms.setBounds(296, 80, 46, 14);
		frame.getContentPane().add(lblKms);
		
		JLabel lblDuracinDelViaje = new JLabel("Duración del viaje:");
		lblDuracinDelViaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracinDelViaje.setBounds(20, 105, 170, 14);
		frame.getContentPane().add(lblDuracinDelViaje);
		
		JLabel lblMinutos = new JLabel("minutos");
		lblMinutos.setBounds(296, 105, 65, 14);
		frame.getContentPane().add(lblMinutos);
		
		JLabel lblPesoMximo = new JLabel("Peso máximo:");
		lblPesoMximo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoMximo.setBounds(50, 130, 140, 14);
		frame.getContentPane().add(lblPesoMximo);
		
		JLabel lblToneladas = new JLabel("toneladas");
		lblToneladas.setBounds(296, 130, 65, 14);
		frame.getContentPane().add(lblToneladas);
		
		JLabel lblOrigen = new JLabel(ruta.getInicio().getValor().getNombre());
		lblOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrigen.setBounds(200, 30, 100, 14);
		frame.getContentPane().add(lblOrigen);
		
		JLabel lblDestino = new JLabel(ruta.getFin().getValor().getNombre());
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setBounds(200, 55, 100, 14);
		frame.getContentPane().add(lblDestino);
		
		JLabel lblDist = new JLabel(Double.toString(ruta.getDistancia()));
		lblDist.setHorizontalAlignment(SwingConstants.LEFT);
		lblDist.setBounds(200, 80, 80, 14);
		frame.getContentPane().add(lblDist);
		
		JLabel lblDuracion = new JLabel(Integer.toString(ruta.getDuracionEnMin()));
		lblDuracion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuracion.setBounds(200, 105, 80, 14);
		frame.getContentPane().add(lblDuracion);
		
		JLabel lblPesomax = new JLabel(Double.toString(ruta.getPesoMaxEnToneladas()));
		lblPesomax.setHorizontalAlignment(SwingConstants.LEFT);
		lblPesomax.setBounds(200, 130, 80, 14);
		frame.getContentPane().add(lblPesomax);
		
		JLabel lbldeseaEliminarLa = new JLabel("Si presiona \"Eliminar\" la ruta seleccionada\r\n");
		lbldeseaEliminarLa.setLabelFor(frame);
		lbldeseaEliminarLa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldeseaEliminarLa.setHorizontalAlignment(SwingConstants.CENTER);
		lbldeseaEliminarLa.setBounds(86, 175, 275, 14);
		frame.getContentPane().add(lbldeseaEliminarLa);
		
		JLabel lblSeEliminarPermanentemente = new JLabel(" se eliminará permanentemente.");
		lblSeEliminarPermanentemente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeEliminarPermanentemente.setLabelFor(frame);
		lblSeEliminarPermanentemente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeEliminarPermanentemente.setBounds(101, 189, 228, 14);
		frame.getContentPane().add(lblSeEliminarPermanentemente);
		
		JButton btnEliminarRuta = new JButton("Eliminar");
		btnEliminarRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datos.eliminarRuta(ruta);
				new BuscarRuta(datos);
				frame.dispose();
			}
		});
		btnEliminarRuta.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnEliminarRuta);
		
		
		
		
		frame.setVisible(true);
	}

}
