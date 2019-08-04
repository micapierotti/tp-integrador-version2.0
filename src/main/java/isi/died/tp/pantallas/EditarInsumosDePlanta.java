
//El botón editar stocks está comentado ya que no está la pantalla para editar dichos stocks por el momento

package isi.died.tp.pantallas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarInsumosDePlanta {

	private JFrame frame;
	private JTable table;
	private JButton btnAgregarStockA;
	private JButton btnAtrs;
	private Planta planta;
	private Datos datos;
	private JButton btnEditar;
	private JButton btnBorrar;
	private Stock stock;
	private ListSelectionModel model;

	public EditarInsumosDePlanta(Planta pl, Datos datos) {
		this.datos=datos;
		planta=pl;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Editar Insumos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 21, 394, 154);
		frame.getContentPane().add(scrollPane);
		
		Object[][] datosStocks= planta.getDatosStock();
		String[] columnas= {"Insumo","Cantidad","Cantidad Mínima"};
		
		table = new JTable(datosStocks, columnas);
		table.editingCanceled(null);
		scrollPane.setViewportView(table);
		model=table.getSelectionModel();
		
		btnAgregarStockA = new JButton("Agregar stock a planta");
		btnAgregarStockA.setBounds(20, 186, 180, 25);
		frame.getContentPane().add(btnAgregarStockA);
		btnAgregarStockA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AgregarStockPlanta(planta,datos);
				frame.dispose();
			}
		});

		btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarPlanta(planta,datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(225, 186, 89, 25);
		frame.getContentPane().add(btnEditar);
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarStockDePlanta(stock,planta,datos);
				frame.dispose();
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(324, 186, 89, 25);
		frame.getContentPane().add(btnBorrar);
		btnBorrar.setEnabled(false);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EliminarStockDePlanta(stock,planta,datos);
				frame.dispose();
			}
		});
		model.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged (ListSelectionEvent e) {
				if(!model.isSelectionEmpty()) {
						btnEditar.setEnabled(true);
						btnBorrar.setEnabled(true);
						
						String aux1=(String) table.getValueAt(model.getMinSelectionIndex(), 0);
						int aux2=(int) table.getValueAt(model.getMinSelectionIndex(), 1);
						int aux3=(int) table.getValueAt(model.getMinSelectionIndex(), 2);
						
						stock=planta.getOneStock(aux1,aux2,aux3);
					}
				}
			});
		
		frame.setVisible(true);
	}
}
