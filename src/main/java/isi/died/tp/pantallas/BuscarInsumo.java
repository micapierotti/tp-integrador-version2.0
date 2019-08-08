package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.estructuras.ArbolBinarioBusqueda;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Comparator;

public class BuscarInsumo {

	private JFrame frame;
	private JTextField tfDescripcion;
	private JTextField tfCostoMin;
	private JTextField tfCostoMax;
    private JTextField tfStockMax;
    private JTable busqueda;
    private ListSelectionModel model;
    private Insumo seleccion;
	private Datos datos;
	
    public BuscarInsumo(Datos datos) {
    	this.datos=datos;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();		
		frame.setSize(600,350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Buscar Insumo");
		Color gris= new Color(187,187,187);
		Color azul= new Color(40,49,72);
		Color rojo= new Color(145,53,53);
		Color beige= new Color(233,238,201);
		
		frame.getContentPane().setBackground(azul);
		
		JButton borrar = new JButton("Borrar");
		borrar.setBounds(447, 276, 109, 25);
		frame.getContentPane().add(borrar);
		borrar.setEnabled(false);
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EliminarInsumo(seleccion,datos);
				frame.dispose();
			}
		});
		borrar.setForeground(beige);
		borrar.setBackground(rojo);
		JButton Atrás = new JButton("Atrás");
		Atrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionInsumos(datos);
				frame.dispose();
			}
		});
		Atrás.setBounds(10, 275, 100, 25);
		frame.getContentPane().add(Atrás);
		Atrás.setForeground(beige);
		Atrás.setBackground(rojo);
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del insumo:");
		lblIngreseLosDatos.setBounds(10, 11, 200, 14);
		frame.getContentPane().add(lblIngreseLosDatos);
		lblIngreseLosDatos.setForeground(beige);

		JLabel descripcion = new JLabel("Descripción: ");
		descripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		descripcion.setBounds(-59, 39, 200, 14);
		frame.getContentPane().add(descripcion);
		descripcion.setForeground(beige);

		tfDescripcion = new JTextField();
		tfDescripcion.setColumns(10);
		tfDescripcion.setBounds(151, 36, 130, 20);
		frame.getContentPane().add(tfDescripcion);
		
		JLabel costoMax = new JLabel("Costo maximo: ");
		costoMax.setHorizontalAlignment(SwingConstants.RIGHT);
		costoMax.setBounds(-59, 101, 200, 14);
		frame.getContentPane().add(costoMax);
		costoMax.setForeground(beige);
		
		tfCostoMin = new JTextField();
		tfCostoMin.setColumns(10);
		tfCostoMin.setBounds(151, 67, 130, 20);
		frame.getContentPane().add(tfCostoMin);
		
		JLabel stockMin = new JLabel("Stock mínimo: ");
		stockMin.setHorizontalAlignment(SwingConstants.RIGHT);
		stockMin.setBounds(-13, 132, 154, 20);
		frame.getContentPane().add(stockMin);
		stockMin.setForeground(beige);
		
		tfCostoMax = new JTextField();
		tfCostoMax.setColumns(10);
		tfCostoMax.setBounds(151, 98, 130, 20);
		frame.getContentPane().add(tfCostoMax);
	
		JLabel stockMax = new JLabel("Stock máximo: ");
		stockMax.setHorizontalAlignment(SwingConstants.RIGHT);
		stockMax.setBounds(-59, 163, 200, 14);
		frame.getContentPane().add(stockMax);
		stockMax.setForeground(beige);
		
		JTextField tfStockMin = new JTextField();
		tfStockMin.setColumns(10);
		tfStockMin.setBounds(151, 129, 130, 20);
		frame.getContentPane().add(tfStockMin);
		
		JLabel costoMin = new JLabel("Costo mínimo: ");
		costoMin.setHorizontalAlignment(SwingConstants.RIGHT);
		costoMin.setBounds(-59, 70, 200, 14);
		frame.getContentPane().add(costoMin);
		costoMin.setForeground(beige);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 38, 225, 200);
		frame.getContentPane().add(scrollPane);
		
		Object[][] datosInsumos= datos.getBusquedaInsumos();
		String[] columnas= {"Nombre","Costo","Stock"};
		
		busqueda = new JTable(datosInsumos,columnas);
		model=busqueda.getSelectionModel();
		busqueda.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(busqueda);
		busqueda.editingCanceled(null);
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(busqueda.getModel());
		busqueda.setRowSorter(sorter);
		
		sorter.setComparator(0, new Comparator<String>() {
		    @Override
		    public int compare(String name1, String name2) {
		    	System.out.println("hola");
		        return name1.compareTo(name2);
		    }
		});
		
		sorter.setComparator(1, new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				if((o1-o2)<0) return -1;
		        else if((o1-o2)>0)return 1;
		        else return 0;
			}
		});
		
		sorter.setComparator(2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		tfStockMax = new JTextField();
		tfStockMax.setColumns(10);
		tfStockMax.setBounds(151, 160, 130, 20);
		frame.getContentPane().add(tfStockMax);
		
		JButton editar = new JButton("Editar");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditarInsumo(seleccion,datos);
				frame.dispose();
			}
		});
		
		editar.setBounds(337, 276, 100, 25);
		frame.getContentPane().add(editar);
		editar.setEnabled(false);		
		editar.setForeground(beige);
		editar.setBackground(rojo);
		
		tfDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				Datos datosAux = new Datos(datos);
				busqueda= new JTable(actualizarTabla(datosAux,datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
							editar.setEnabled(true);
							borrar.setEnabled(true);
							
							String aux1=(String) busqueda.getValueAt(model.getMinSelectionIndex(), 0);
							Double aux2=(Double) busqueda.getValueAt(model.getMinSelectionIndex(), 1);
							Integer aux3=(Integer) busqueda.getValueAt(model.getMinSelectionIndex(), 2);

							seleccion=datos.buscarInsumo(aux1,aux2,aux3);
						}
					}
				});
			}
		});		
		
		tfCostoMin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				Datos datosAux = new Datos(datos);
				busqueda= new JTable(actualizarTabla(datosAux,datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
							editar.setEnabled(true);
							borrar.setEnabled(true);
							
							String aux1=(String) busqueda.getValueAt(model.getMinSelectionIndex(), 0);
							Double aux2=(Double) busqueda.getValueAt(model.getMinSelectionIndex(), 1);
							Integer aux3=(Integer) busqueda.getValueAt(model.getMinSelectionIndex(), 2);

							seleccion=datos.buscarInsumo(aux1,aux2,aux3);
						}
					}
				});
			}
		});	
		
		tfCostoMax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				Datos datosAux = new Datos(datos);
				busqueda= new JTable(actualizarTabla(datosAux,datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
							editar.setEnabled(true);
							borrar.setEnabled(true);

							String aux1=(String) busqueda.getValueAt(model.getMinSelectionIndex(), 0);
							Double aux2=(Double) busqueda.getValueAt(model.getMinSelectionIndex(), 1);
							Integer aux3=(Integer) busqueda.getValueAt(model.getMinSelectionIndex(), 2);

							seleccion=datos.buscarInsumo(aux1,aux2,aux3);
						}
					}
				});
			}
		});	
		
		tfStockMin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				Datos datosAux = new Datos(datos);
				busqueda= new JTable(actualizarTabla(datosAux,datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
							editar.setEnabled(true);
							borrar.setEnabled(true);
							
							String aux1=(String) busqueda.getValueAt(model.getMinSelectionIndex(), 0);
							Double aux2=(Double) busqueda.getValueAt(model.getMinSelectionIndex(), 1);
							Integer aux3=(Integer) busqueda.getValueAt(model.getMinSelectionIndex(), 2);

							seleccion=datos.buscarInsumo(aux1,aux2,aux3);	
						}
					}
				});
			}
		});	
		
		tfStockMax.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				Datos datosAux = new Datos(datos);
				busqueda= new JTable(actualizarTabla(datosAux,datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						
						if(!model.isSelectionEmpty()) {						
							editar.setEnabled(true);
							borrar.setEnabled(true);
							
							String aux1=(String) busqueda.getValueAt(model.getMinSelectionIndex(), 0);
							Double aux2=(Double) busqueda.getValueAt(model.getMinSelectionIndex(), 1);
							Integer aux3=(Integer) busqueda.getValueAt(model.getMinSelectionIndex(), 2);

							seleccion=datos.buscarInsumo(aux1,aux2,aux3);
						}
					}
				});
			}
		});	
	
	model.addListSelectionListener(new ListSelectionListener() {
	
			public void valueChanged(ListSelectionEvent e) {
				if(!model.isSelectionEmpty()) {
					editar.setEnabled(true);
					borrar.setEnabled(true);
					
					String aux1=(String) busqueda.getValueAt(model.getMinSelectionIndex(), 0);
					Double aux2=(Double) busqueda.getValueAt(model.getMinSelectionIndex(), 1);
					Integer aux3=(Integer) busqueda.getValueAt(model.getMinSelectionIndex(), 2);

					seleccion=datos.buscarInsumo(aux1,aux2,aux3);	
				}
			}
		});
	frame.setVisible(true);
	}
	
	private Object[][] actualizarTabla(Datos datosAux,Object[][] datosTabla,String des,String cMin, String cMax, String sMin, String sMax){

		ArbolBinarioBusqueda<Insumo> arbolDatos = new ArbolBinarioBusqueda<Insumo>(datosAux.getListaInsumos().get(0));
		int stockMin;
		int stockMax;
		double costoMin;
		double costoMax;
		
		for(int i=1;i<datosTabla.length;i++){
			arbolDatos.agregar(datosAux.getListaInsumos().get(i));
		}
		
		if(sMin.compareTo("")==0) sMin="0";
		if(sMax.compareTo("")==0) sMax="99999999";
		if(cMin.compareTo("")==0) cMin="0";
		if(cMax.compareTo("")==0) cMax="99999999";

		stockMin=Integer.parseInt(sMin);
		stockMax=Integer.parseInt(sMax);
		costoMin=Double.parseDouble(cMin);
		costoMax=Double.parseDouble(cMax);
		
		ArrayList<Insumo> listaInsumos=arbolDatos.rango(des,stockMin,stockMax,costoMin,costoMax);
		
		datosAux.setListaInsumos(listaInsumos);
		
		return datosAux.getBusquedaInsumos();
	}	
}
