package isi.died.tp.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CrearRuta {

	private JFrame frame;
	private JTextField txtDistancia;
	private JTextField txtDuracion;
	private JTextField txtPesomax;
	private Datos datos;

	
	public CrearRuta(Datos dat) {
		datos=dat;
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Nueva ruta");
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionLogistica(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		JLabel lblNombrePlantaOrigen = new JLabel("Nombre planta origen:");
		lblNombrePlantaOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePlantaOrigen.setBounds(5, 56, 170, 14);
		frame.getContentPane().add(lblNombrePlantaOrigen);
		
		JLabel lblNombrePlantaDestino = new JLabel("Nombre planta destino:");
		lblNombrePlantaDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePlantaDestino.setBounds(5, 81, 170, 14);
		frame.getContentPane().add(lblNombrePlantaDestino);
		
		JLabel lblDistancia = new JLabel("Distancia:");
		lblDistancia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDistancia.setBounds(105, 106, 70, 14);
		frame.getContentPane().add(lblDistancia);
		
		txtDistancia = new JTextField();
		txtDistancia.setBounds(180, 103, 126, 20);
		frame.getContentPane().add(txtDistancia);
		txtDistancia.setColumns(10);
	
		
		JLabel lblKms = new JLabel("kms");
		lblKms.setBounds(311, 106, 46, 14);
		frame.getContentPane().add(lblKms);
		
		JLabel lblDuracinDelViaje = new JLabel("Duración del viaje:");
		lblDuracinDelViaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracinDelViaje.setBounds(5, 131, 170, 14);
		frame.getContentPane().add(lblDuracinDelViaje);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(180, 128, 126, 20);
		frame.getContentPane().add(txtDuracion);
		txtDuracion.setColumns(10);
		
		JLabel lblMinutos = new JLabel("minutos");
		lblMinutos.setBounds(311, 131, 65, 14);
		frame.getContentPane().add(lblMinutos);
		
		JLabel lblPesoMximo = new JLabel("Peso máximo:");
		lblPesoMximo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoMximo.setBounds(35, 156, 140, 14);
		frame.getContentPane().add(lblPesoMximo);
		
		txtPesomax = new JTextField();
		txtPesomax.setBounds(180, 153, 126, 20);
		frame.getContentPane().add(txtPesomax);
		txtPesomax.setColumns(10);
		
		JLabel lblToneladas = new JLabel("toneladas");
		lblToneladas.setBounds(311, 156, 65, 14);
		frame.getContentPane().add(lblToneladas);
		
		JComboBox<String> nombreOrigen = new JComboBox<String>();
		nombreOrigen.setBounds(180, 53, 126, 20);
		frame.getContentPane().add(nombreOrigen);
		
		ArrayList<Planta> plantas = datos.getListaPlantas();
		for(int i=0; i<datos.getListaPlantas().size(); i++) {
			nombreOrigen.addItem(plantas.get(i).getNombre());
		}
		
		JComboBox<String> nombreDestino = new JComboBox<String>();
		nombreDestino.setBounds(180, 78, 126, 20);
		frame.getContentPane().add(nombreDestino);
		for(int i=0; i<datos.getListaPlantas().size(); i++) {
			nombreDestino.addItem(plantas.get(i).getNombre());
		}
		
		JButton btnCrearRuta = new JButton("Crear ruta");
		btnCrearRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planta origen = datos.buscarPlanta(nombreOrigen.getSelectedItem().toString());
				Planta destino = datos.buscarPlanta(nombreDestino.getSelectedItem().toString());
				double dist = Double.parseDouble(txtDistancia.getText());
				int duracion = Integer.parseInt(txtDuracion.getText());
				double pesomax = Double.parseDouble(txtPesomax.getText());
				
				Ruta nuevaRuta = new Ruta(dist,duracion,pesomax,origen,destino);
				ArrayList<Ruta> rutas = datos.getListaRutas();
				rutas.add(nuevaRuta);
				datos.setListaRutas(rutas);
				new GestionLogistica(datos);
				frame.dispose();
			}
		});
		btnCrearRuta.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnCrearRuta);
		
		
		
		
		frame.setVisible(true);
		
	}
}