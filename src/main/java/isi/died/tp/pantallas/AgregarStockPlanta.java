package isi.died.tp.pantallas;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AgregarStockPlanta {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private static Planta planta;
	private Datos datos;
	private JTextField txtId;

	public AgregarStockPlanta(Planta pl, Datos datos) {
		this.datos=datos;
		planta=pl;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Agregar stock a planta");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Datos del stock:");
		lblNewLabel.setBounds(43, 47, 150, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Insumo:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(73, 82, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(73, 117, 100, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Punto de pedido:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(43, 152, 130, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox<String> listaInsumos = new JComboBox<String>();
		listaInsumos.setBounds(183, 79, 86, 20);
		frame.getContentPane().add(listaInsumos);
		
		ArrayList<Insumo> insumos = datos.getListaInsumos();
		for(int i=0; i<datos.getListaInsumos().size(); i++) {
			listaInsumos.addItem(insumos.get(i).getDescripcion());
		}
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 114, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 149, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(183, 47, 86, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton = new JButton("Atrás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarInsumosDePlanta(planta,datos);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 226, 100, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id,cantidad,puntopedido;
				id= Integer.parseInt(txtId.getText());
				cantidad= Integer.parseInt(textField_1.getText());
				puntopedido= Integer.parseInt(textField_2.getText());
				String nombreIn = listaInsumos.getSelectedItem().toString();
				Insumo ins= datos.buscarInsumo(nombreIn);
				ArrayList<Stock> listaS = planta.getStocks();
				Stock st = new Stock(id,cantidad,puntopedido,ins);
				listaS.add(st);
				planta.setStocks(listaS);
				new EditarInsumosDePlanta(planta,datos);
				frame.dispose();
			}
		});
		btnGuardar.setBounds(324, 226, 100, 25);
		frame.getContentPane().add(btnGuardar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(127, 50, 46, 14);
		frame.getContentPane().add(lblId);
		
		frame.setVisible(true);
	}
}
