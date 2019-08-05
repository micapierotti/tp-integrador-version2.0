package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;
import isi.died.tp.estructuras.Vertice;
import isi.died.tp.grafo.Lienzo;

public class CaminosEntrePlantas {
	
	private JFrame ventana;
	private JPanel lienzo;
	private Datos datos;
	private Insumo insumoBuscar;
	private Planta plantaInicial;
	private Planta plantaFinal;
	private int posicion;
	private int nuevaPosicion;
	private ArrayList<Ruta> listaRutasPintar;
	
	public CaminosEntrePlantas(Planta plantaInicial, Planta plantaFinal, Datos datos,int posicion) {
		this.plantaFinal=plantaFinal;
		this.plantaInicial=plantaInicial;
		this.datos=datos;
		this.nuevaPosicion=0;
		this.posicion=posicion;
		initialize();
	}

	private void initialize () {
		Object [] listaInsumos = listaCaminos();
		listaRutasPintar = new ArrayList<Ruta>();
		List<Vertice<Planta>> listaRutas;
		
		if(datos.getGrafo().caminos(plantaInicial, plantaFinal).size()==0) {
			listaRutas=new ArrayList<>();
		}else {
			listaRutas=datos.getGrafo().caminos(plantaInicial, plantaFinal).get(posicion);
		}
		
		ArrayList<Planta> listaPlantas=new ArrayList<>();
		
		for(Vertice<Planta> planta:listaRutas) {
			listaPlantas.add(planta.getValor());
		}
				
		listaRutasPintar = datos.rutasPlantas(listaPlantas);
		
		ventana = new JFrame("Mapa de Plantas");
		ventana.setSize(1300,500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(null);
		
		lienzo = new Lienzo(plantaInicial, plantaFinal,listaRutasPintar,datos);
		lienzo.setBackground(Color.LIGHT_GRAY);
		lienzo.setForeground(Color.BLACK);
		lienzo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lienzo.setLocation(0, 0);
		lienzo.setSize(900,500);
		lienzo.setLayout(null);
		ventana.getContentPane().add(lienzo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevaPosicion=comboBox.getSelectedIndex();
			}
		});
		comboBox.setBounds(910, 36, 364, 30);
		comboBox.setModel(new DefaultComboBoxModel(listaInsumos));
		ventana.getContentPane().add(comboBox);
		
		JLabel lblSeleccioneElInsumo = new JLabel("Elija un camino entre "+plantaInicial.getNombre()+" y "+plantaFinal.getNombre()+":");
		lblSeleccioneElInsumo.setBounds(910, 11, 364, 14);
		ventana.getContentPane().add(lblSeleccioneElInsumo);
		
		JButton btnBuscar = new JButton("Mostrar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new CaminosEntrePlantas(plantaInicial,plantaFinal,datos,nuevaPosicion);
					ventana.dispose();
			}
		});
		btnBuscar.setBounds(1174, 426, 100, 25);
		ventana.getContentPane().add(btnBuscar);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CaminoPlantaFinal(plantaInicial,datos);
				ventana.dispose();
			}
		});
		btnAtrs.setBounds(910, 426, 100, 25);
		ventana.getContentPane().add(btnAtrs);
		
		ventana.setVisible(true);
	}
	
	private Object[] listaCaminos() {
		
		List<List<Vertice<Planta>>> todosCaminos = datos.getGrafo().caminos(plantaInicial, plantaFinal);

		Object[] lista= new Object[todosCaminos.size()];
		
		int cont=0;
		String opcion="[";
		for(List<Vertice<Planta>> camino:todosCaminos) {
			for(Vertice<Planta> planta:camino) {
				opcion=opcion+"  "+planta.getValor().getNombre();
			}
			
			lista[cont]=opcion+"  ]";
			opcion="[";
			cont++;
		}
		
		return lista;
	}
}
