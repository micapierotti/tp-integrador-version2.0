package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Planta {
	
	private int id;
	private String nombre;
	private ArrayList<Stock> stocks;
	private int pageRank;
	
	public Planta() {
		stocks= new ArrayList<Stock>();
		this.pageRank =0;
	}
	
	public Planta(int i, String n) {
		this.id=i;
		this.nombre=n;
		stocks= new ArrayList<Stock>();
		this.pageRank=0;
	}
	
	public double costoTotal() {
		
		return stocks.stream().mapToDouble((s) -> s.getInsumo().getCosto()*s.getCantidad()).sum();
		}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public void agregarStock(Stock stock) {
		this.stocks.add(stock);
	}


	public ArrayList<Insumo> stockEntre(int s1, int s2){
		
		ArrayList<Stock> aux = (ArrayList<Stock>) this.stocks.stream().filter((s)->(s.getCantidad()>s1)).filter((s)->(s.getCantidad()<s2)).collect(Collectors.toList());
		ArrayList<Insumo> aux2= new ArrayList<Insumo>();
		
		for(int i=0;i<aux.size();i++) {
			aux2.add(aux.get(i).getInsumo());
		}
		
		return aux2;
	}
	
	public boolean necesitaInsumo(Insumo insumo) {
		
		for(int i=0; i<stocks.size();i++) {
			if (stocks.get(i).getInsumo().compareTo(insumo)==0 && stocks.get(i).getCantidad()<stocks.get(i).getPuntoPedido()) return true;
		}
		
		return false; 
	}

	public Object[][] getDatosStock(){
		Object[][] p= new Object[this.stocks.size()][3];
		
		for(int i=0; i<this.stocks.size(); i++) {
			p[i][0]= stocks.get(i).getInsumo().getDescripcion();
			p[i][1]= stocks.get(i).getCantidad();
			p[i][2]= stocks.get(i).getPuntoPedido();
		}
		return p;
	}
	public Stock getOneStock(String insumo, int cant, int puntoPed) {
		for(Stock st:stocks) 
			if(st.getInsumo().getDescripcion().contains(insumo) && (st.getCantidad()==cant) && (st.getPuntoPedido()==puntoPed)) {
				return st;
			}
		return null;
	}
	public void incrementarPageRank() {
		pageRank++;
	}
	public void decrementarPageRank() {
		pageRank--;
	}
	public int getPageRank() {
		return this.pageRank;
	}
	public void setPageRank(int pr) {
		this.pageRank=pr;
	}
	@Override
	public String toString() {
		return nombre;
	}
}
