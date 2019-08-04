package isi.died.tp.pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VerPlantas {

	private JFrame frame;
	private JButton btnVerInsumos;
	private JButton btnAtrs;
	private ListSelectionModel model;
	private Planta planta;
	private JTable table;
	private Datos datos;

	public VerPlantas(Datos datos) {
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setTitle("Ver Plantas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblTexto = new JLabel("Plantas ordenadas por Page Rank (cantidad de caminos):");
		lblTexto.setBounds(50, 20, 450, 14);
		frame.getContentPane().add(lblTexto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 38, 472, 150);
		frame.getContentPane().add(scrollPane);
		
		Object[][] datosPlantas=datos.getBusquedaPlantasConPageRank();
		String[] columnas= {"ID","Nombre","Cantidad de caminos"};
		
		table = new JTable(datosPlantas,columnas);
		model=table.getSelectionModel();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		table.editingCanceled(null);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		 
		int columnIndexToSort = 2;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
		 
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
		btnVerInsumos = new JButton("Ver insumos");
		btnVerInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VerInsumosDePlanta2(planta,datos);
				frame.dispose();
			}
		});
		btnVerInsumos.setBounds(411, 202, 110, 25);
		frame.getContentPane().add(btnVerInsumos);
		btnVerInsumos.setEnabled(false);
		
		btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionPlantas(datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		model.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!model.isSelectionEmpty()) {
					btnVerInsumos.setEnabled(true);
					
					int aux1=(int) table.getValueAt(model.getMinSelectionIndex(), 0);
					String aux2=(String) table.getValueAt(model.getMinSelectionIndex(), 1);
					
					planta=datos.buscarPlanta(aux1,aux2);
				}
			}
		});
		
		frame.setVisible(true);
	}
}
