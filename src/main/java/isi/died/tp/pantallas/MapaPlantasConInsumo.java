package isi.died.tp.pantallas;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import isi.died.tp.dominio.Ruta;
import isi.died.tp.grafo.Lienzo;

public class MapaPlantasConInsumo {
	
	private JFrame ventana;
	private JPanel lienzo;
	private Datos datos;
	private Insumo insumoBuscar;
	private ArrayList<Ruta> listaRutasPintar;
	
	public MapaPlantasConInsumo(Insumo insumo, Datos datos) {
		this.datos=datos;
		initialize(insumo);
	}

	private void initialize (Insumo insumo) {
		Object [] listaInsumos = datos.listaInsumosString();
		listaRutasPintar = new ArrayList<Ruta>();
		listaRutasPintar = datos.getGrafo().caminoPlanta();
		
		listaRutasPintar = datos.getListaRutas();
		
		ventana = new JFrame("Mapa de Plantas");
		ventana.setSize(1300,500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(null);
		
		lienzo = new Lienzo(insumo,listaRutasPintar,datos);
		lienzo.setBackground(Color.LIGHT_GRAY);
		lienzo.setForeground(Color.BLACK);
		lienzo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lienzo.setLocation(0, 0);
		lienzo.setSize(900,500);
		lienzo.setLayout(null);
		ventana.getContentPane().add(lienzo);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(910, 106, 264, 30);
		for(int i=0; i<listaInsumos.length; i++) {
			comboBox.addItem((String) listaInsumos[i]);
		}
		//comboBox.setModel(new DefaultComboBoxModel(listaInsumos));
		ventana.getContentPane().add(comboBox);
		comboBox.setSelectedItem(insumo.getDescripcion());
		
		JLabel lblSeleccioneElInsumo = new JLabel("Seleccione el insumo para:");
		lblSeleccioneElInsumo.setBounds(910, 11, 186, 14);
		ventana.getContentPane().add(lblSeleccioneElInsumo);
		
		JLabel lblPlantasQue = new JLabel("- Plantas que necesiten ese insumo.");
		lblPlantasQue.setBounds(910, 36, 220, 14);
		ventana.getContentPane().add(lblPlantasQue);
		
		JLabel lblElMejor = new JLabel("- El mejor camino para ir desde el acopio puerto");
		lblElMejor.setHorizontalAlignment(SwingConstants.LEFT);
		lblElMejor.setToolTipText("");
		lblElMejor.setBounds(910, 61, 400, 14);
		ventana.getContentPane().add(lblElMejor);
		
		JLabel lblHastaElAcopio = new JLabel("hasta el acopio final pasando por todas esas plantas.");
		lblHastaElAcopio.setToolTipText("");
		lblHastaElAcopio.setHorizontalAlignment(SwingConstants.LEFT);
		lblHastaElAcopio.setBounds(910, 81, 400, 14);
		ventana.getContentPane().add(lblHastaElAcopio);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()!=0) {
					
					insumoBuscar=datos.buscarInsumoNombre((String)listaInsumos[comboBox.getSelectedIndex()]);
					new MapaPlantasConInsumo(insumoBuscar,datos);
					ventana.dispose();
					
				}
			}
		});
		btnBuscar.setBounds(1174, 425, 100, 25);
		ventana.getContentPane().add(btnBuscar);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GestionLogistica(datos);
				ventana.dispose();
			}
		});
		btnAtrs.setBounds(910, 425, 100, 25);
		ventana.getContentPane().add(btnAtrs);
		
		ventana.setVisible(true);
	}
}
