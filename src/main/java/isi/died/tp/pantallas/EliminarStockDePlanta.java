package isi.died.tp.pantallas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EliminarStockDePlanta {

	private JFrame frame;
	private Stock stock;
	private Planta planta;
	private Datos datos;

	public EliminarStockDePlanta(Stock st, Planta pl, Datos dat) {
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
		frame.setTitle("Eliminar Stock de Planta");
		
		JLabel lbldeseaEliminarLa = new JLabel("Si presiona \"Eliminar\" el stock seleccionado\r\n");
		lbldeseaEliminarLa.setLabelFor(frame);
		lbldeseaEliminarLa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldeseaEliminarLa.setHorizontalAlignment(SwingConstants.CENTER);
		lbldeseaEliminarLa.setBounds(81, 143, 275, 14);
		frame.getContentPane().add(lbldeseaEliminarLa);
		
		JLabel lblSeEliminarPermanentemente = new JLabel(" se eliminará permanentemente.");
		lblSeEliminarPermanentemente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeEliminarPermanentemente.setLabelFor(frame);
		lblSeEliminarPermanentemente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeEliminarPermanentemente.setBounds(99, 160, 228, 14);
		frame.getContentPane().add(lblSeEliminarPermanentemente);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarInsumosDePlanta(planta, datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Stock> listaS = planta.getStocks();
				listaS.remove(stock);
				planta.setStocks(listaS);
				new EditarInsumosDePlanta(planta, datos);
				frame.dispose();
			}
		});
		btnEliminar.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnEliminar);
		
		JLabel lblInsumo = new JLabel("Insumo:");
		lblInsumo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInsumo.setBounds(81, 54, 100, 14);
		frame.getContentPane().add(lblInsumo);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setBounds(81, 79, 100, 14);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblPuntoDePedido = new JLabel("Punto de pedido:");
		lblPuntoDePedido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuntoDePedido.setBounds(61, 104, 120, 14);
		frame.getContentPane().add(lblPuntoDePedido);
		
		JLabel lblDescripin = new JLabel(stock.getInsumo().getDescripcion());
		lblDescripin.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripin.setBounds(191, 54, 110, 14);
		frame.getContentPane().add(lblDescripin);
		
		JLabel lblCantstock = new JLabel(Integer.toString(stock.getCantidad()));
		lblCantstock.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantstock.setBounds(191, 79, 100, 14);
		frame.getContentPane().add(lblCantstock);
		
		JLabel lblPuntostock = new JLabel(Integer.toString(stock.getPuntoPedido()));
		lblPuntostock.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntostock.setBounds(191, 104, 100, 14);
		frame.getContentPane().add(lblPuntostock);
		frame.setVisible(true);
	}

}