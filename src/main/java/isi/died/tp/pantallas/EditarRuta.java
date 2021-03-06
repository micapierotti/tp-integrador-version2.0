package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;
import isi.died.tp.estructuras.Arista;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EditarRuta {

	private JFrame frame;
	private Datos datos;
	private Ruta ruta;
	private JTextField txtDistancia;
	private JTextField txtDuracion;
	private JTextField txtPesomax;

	public EditarRuta(Ruta r, Datos dat) {
		ruta=r;
		datos=dat;
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Editar ruta");
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarRuta(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 227, 100, 25);
		frame.getContentPane().add(btnAtrs);
		btnAtrs.setForeground(beige);
		btnAtrs.setBackground(rojo);
		JLabel lblNombrePlantaOrigen = new JLabel("Nombre planta origen:");
		lblNombrePlantaOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePlantaOrigen.setBounds(5, 56, 170, 14);
		frame.getContentPane().add(lblNombrePlantaOrigen);
		lblNombrePlantaOrigen.setForeground(beige);
		
		JLabel lblNombrePlantaDestino = new JLabel("Nombre planta destino:");
		lblNombrePlantaDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePlantaDestino.setBounds(5, 81, 170, 14);
		frame.getContentPane().add(lblNombrePlantaDestino);
		lblNombrePlantaDestino.setForeground(beige);
		
		JLabel lblDistancia = new JLabel("Distancia:");
		lblDistancia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDistancia.setBounds(105, 106, 70, 14);
		frame.getContentPane().add(lblDistancia);
		lblDistancia.setForeground(beige);
		
		txtDistancia = new JTextField();
		txtDistancia.setBounds(180, 103, 126, 20);
		frame.getContentPane().add(txtDistancia);
		txtDistancia.setColumns(10);
		txtDistancia.setText(Double.toString(ruta.getDistancia()));
		
		JLabel lblKms = new JLabel("kms");
		lblKms.setBounds(311, 106, 46, 14);
		frame.getContentPane().add(lblKms);
		lblKms.setForeground(beige);
		
		JLabel lblDuracinDelViaje = new JLabel("Duración del viaje:");
		lblDuracinDelViaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracinDelViaje.setBounds(5, 131, 170, 14);
		frame.getContentPane().add(lblDuracinDelViaje);
		lblDuracinDelViaje.setForeground(beige);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(180, 128, 126, 20);
		frame.getContentPane().add(txtDuracion);
		txtDuracion.setColumns(10);
		txtDuracion.setText(Integer.toString(ruta.getDuracionEnMin()));
		
		JLabel lblMinutos = new JLabel("minutos");
		lblMinutos.setBounds(311, 131, 65, 14);
		frame.getContentPane().add(lblMinutos);
		lblMinutos.setForeground(beige);
		
		JLabel lblPesoMximo = new JLabel("Peso máximo:");
		lblPesoMximo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoMximo.setBounds(35, 156, 140, 14);
		frame.getContentPane().add(lblPesoMximo);
		lblPesoMximo.setForeground(beige);
		
		txtPesomax = new JTextField();
		txtPesomax.setBounds(180, 153, 126, 20);
		frame.getContentPane().add(txtPesomax);
		txtPesomax.setColumns(10);
		txtPesomax.setText(Double.toString(ruta.getPesoMaxEnToneladas()));
		
		JLabel lblToneladas = new JLabel("toneladas");
		lblToneladas.setBounds(311, 156, 65, 14);
		frame.getContentPane().add(lblToneladas);
		lblToneladas.setForeground(beige);
		
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
		
		nombreOrigen.setSelectedItem(ruta.getInicio().getValor().getNombre());
		nombreDestino.setSelectedItem(ruta.getFin().getValor().getNombre());
		nombreOrigen.setEnabled(false);
		nombreDestino.setEnabled(false);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setBounds(284, 227, 140, 25);
		frame.getContentPane().add(btnGuardarCambios);
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				datos.eliminarRuta(ruta);
				ArrayList<Ruta> listaR = datos.getListaRutas();
				double dist = Double.parseDouble(txtDistancia.getText());
				int duracion = Integer.parseInt(txtDuracion.getText());
				double pesomax = Double.parseDouble(txtPesomax.getText());
				ruta.setDistancia(dist);
				ruta.setDuracionEnMin(duracion);
				ruta.setPesoMaxEnToneladas(pesomax);
				listaR.add(ruta);
				
				ArrayList<Arista<Planta>> listaAristas=(ArrayList<Arista<Planta>>) datos.getGrafo().getAristas();
				listaAristas.remove(datos.getGrafo().buscarArista(ruta.getInicio(), ruta.getFin()));
				datos.getGrafo().setAristas(listaAristas);
				datos.getGrafo().conectar(ruta.getInicio(), ruta.getFin(), ruta.getDistancia(), ruta.getPesoMaxEnToneladas());
				datos.setListaRutas(listaR);
				new BuscarRuta(datos);
				frame.dispose();
			}
		});
		btnGuardarCambios.setForeground(beige);
		btnGuardarCambios.setBackground(rojo);
		
		
		
		
		
		frame.setVisible(true);
	}

}
