package isi.died.tp.pantallas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.InsumoLiquido;

public class EliminarInsumo {

	private JFrame frame;
	private static Insumo insumo;
	private Datos datos;


	public EliminarInsumo(Insumo ins, Datos dat) {
		insumo=ins;
		this.datos=dat;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Eliminar Insumo");
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(129, 26, 50, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(59, 45, 120, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lbldeseaEliminarLa = new JLabel("Si presiona \"Eliminar\" el insumo seleccionado\r\n");
		lbldeseaEliminarLa.setLabelFor(frame);
		lbldeseaEliminarLa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldeseaEliminarLa.setHorizontalAlignment(SwingConstants.CENTER);
		lbldeseaEliminarLa.setBounds(83, 175, 275, 14);
		frame.getContentPane().add(lbldeseaEliminarLa);
		
		JLabel lblSeEliminarPermanentemente = new JLabel(" se eliminará permanentemente.");
		lblSeEliminarPermanentemente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeEliminarPermanentemente.setLabelFor(frame);
		lblSeEliminarPermanentemente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeEliminarPermanentemente.setBounds(102, 188, 228, 14);
		frame.getContentPane().add(lblSeEliminarPermanentemente);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarInsumo(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Insumo> listaI = datos.getListaInsumos();
				listaI.remove(insumo);
				datos.setListaInsumos(listaI);
				new BuscarInsumo(datos);
				frame.dispose();
			}
			
		});
		btnEliminar.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(btnEliminar);
		
		JLabel lblNewLabel_2 = new JLabel("Unidad de medida:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(59, 64, 120, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblCostoPorUnidad = new JLabel("Costo por unidad:");
		lblCostoPorUnidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoPorUnidad.setBounds(59, 83, 120, 14);
		frame.getContentPane().add(lblCostoPorUnidad);
		
		JLabel lblStockEnCentro = new JLabel("Stock en centro de acopio:");
		lblStockEnCentro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStockEnCentro.setBounds(9, 102, 170, 14);
		frame.getContentPane().add(lblStockEnCentro);
		
		JLabel lblRefrigerado = new JLabel("Refrigerado:");
		lblRefrigerado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRefrigerado.setBounds(79, 121, 100, 14);
		frame.getContentPane().add(lblRefrigerado);
		
		JLabel lblLquido = new JLabel("Líquido:");
		lblLquido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLquido.setBounds(79, 140, 100, 14);
		frame.getContentPane().add(lblLquido);
		
		JLabel lblIdin = new JLabel(insumo.getId());
		lblIdin.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdin.setBounds(183, 26, 46, 14);
		frame.getContentPane().add(lblIdin);
		
		JLabel lblDescin = new JLabel(insumo.getDescripcion());
		lblDescin.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescin.setBounds(183, 45, 46, 14);
		frame.getContentPane().add(lblDescin);
		
		JLabel lblUnidadin = new JLabel(insumo.getUnidad().toString());
		lblUnidadin.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnidadin.setBounds(183, 64, 46, 14);
		frame.getContentPane().add(lblUnidadin);
		
		JLabel lblCostoin = new JLabel(Double.toString(insumo.getCosto()));
		lblCostoin.setHorizontalAlignment(SwingConstants.LEFT);
		lblCostoin.setBounds(183, 83, 46, 14);
		frame.getContentPane().add(lblCostoin);
		
		JLabel lblStockin = new JLabel(Integer.toString(insumo.getStock()));
		lblStockin.setHorizontalAlignment(SwingConstants.LEFT);
		lblStockin.setBounds(183, 102, 46, 14);
		frame.getContentPane().add(lblStockin);
		
		String ref=new String();
		if(insumo.isEsRefrigerado()) ref="Si";
		else {ref="No";}
		JLabel lblRefin = new JLabel(ref);
		lblRefin.setHorizontalAlignment(SwingConstants.LEFT);
		lblRefin.setBounds(183, 121, 46, 14);
		frame.getContentPane().add(lblRefin);
		
		String liq=new String();
		if(insumo instanceof InsumoLiquido) liq="Si";
		else { liq="No";}
		JLabel lblLiqin = new JLabel(liq);
		lblLiqin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLiqin.setBounds(183, 140, 46, 14);
		frame.getContentPane().add(lblLiqin);
		
		frame.setVisible(true);
	}
}

