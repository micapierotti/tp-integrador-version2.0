package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class EditarStockDePlanta {

	private JFrame frame;
	private Stock stock;
	private Planta planta;
	private Datos datos;
	private JTextField textField;
	private JTextField textField_1;

	public EditarStockDePlanta(Stock st, Planta pl, Datos dat) {
		planta=pl;
		stock=st;
		datos=dat;
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Editar Stock de Planta");
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarInsumosDePlanta(planta, datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		btnAtrs.setForeground(beige);
		btnAtrs.setBackground(rojo);
		JLabel lblInsumo = new JLabel("Insumo:");
		lblInsumo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInsumo.setBounds(91, 68, 100, 14);
		frame.getContentPane().add(lblInsumo);
		lblInsumo.setForeground(beige);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setBounds(91, 104, 100, 14);
		frame.getContentPane().add(lblCantidad);
		lblCantidad.setForeground(beige);
		
		JLabel lblPuntoDePedido = new JLabel("Punto de pedido:");
		lblPuntoDePedido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuntoDePedido.setBounds(71, 140, 120, 14);
		frame.getContentPane().add(lblPuntoDePedido);
		lblPuntoDePedido.setForeground(beige);
		
		JComboBox<String> listaInsumos = new JComboBox<String>();
		listaInsumos.setBounds(201, 65, 86, 20);
		frame.getContentPane().add(listaInsumos);
		
		ArrayList<Insumo> insumos = datos.getListaInsumos();
		for(int i=0; i<datos.getListaInsumos().size(); i++) {
			listaInsumos.addItem(insumos.get(i).getDescripcion());
		}
		listaInsumos.setSelectedItem(stock.getInsumo().getDescripcion());
		listaInsumos.setEnabled(false);
		
		textField = new JTextField();
		textField.setBounds(201, 101, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(Integer.toString(stock.getCantidad()));
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 137, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(Integer.toString(stock.getPuntoPedido()));
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cant, puntoped;
				int cantViejo,difCant;
				
				ArrayList<Stock> listaS = planta.getStocks();
				ArrayList<Insumo> listaI = datos.getListaInsumos();
				
				listaS.remove(stock);
				cant=Integer.parseInt(textField.getText());
				puntoped=Integer.parseInt(textField_1.getText());
				
				cantViejo=stock.getCantidad();
				difCant=cant-cantViejo;
				Insumo insumo = stock.getInsumo();
				
				listaI.remove(insumo);
				insumo.incrementarInsumo(difCant);
				listaI.add(insumo);
				datos.setListaInsumos(listaI);
				
				stock.setCantidad(cant);
				stock.setPuntoPedido(puntoped);
				listaS.add(stock);
				planta.setStocks(listaS);
				new EditarInsumosDePlanta(planta, datos);
				frame.dispose();
			}
		});
		btnGuardarCambios.setBounds(279, 225, 145, 25);
		btnGuardarCambios.setForeground(beige);
		btnGuardarCambios.setBackground(rojo);
		frame.getContentPane().add(btnGuardarCambios);
		frame.setVisible(true);
	}
}
