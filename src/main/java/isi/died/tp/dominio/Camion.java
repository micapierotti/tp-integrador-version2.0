package isi.died.tp.dominio;

import java.util.ArrayList;

public class Camion {
		private String id;
		private String marca;
		private String modelo;
		private String dominio;
		private int anio;
		private double costoXKM;
		private boolean AptoLiq;
		private int capacidad; //en kg
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getDominio() {
			return dominio;
		}
		public void setDominio(String dominio) {
			this.dominio = dominio;
		}
		public int getAnio() {
			return anio;
		}
		public void setAnio(int anio) {
			this.anio = anio;
		}
		public double getCostoXKM() {
			return costoXKM;
		}
		public void setCostoXKM(double costoXKM) {
			this.costoXKM = costoXKM;
		}
		public boolean isAptoLiq() {
			return AptoLiq;
		}
		public void setAptoLiq(boolean aptoLiq) {
			AptoLiq = aptoLiq;
		}
		public int getCapacidad() {
			return capacidad;
		}
		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}
		public Camion(String id, String marca, String modelo, String dominio, int anio, double costoXKM, boolean aptoLiq,
				int capacidad) {
			super();
			this.id = id;
			this.marca = marca;
			this.modelo = modelo;
			this.dominio = dominio;
			this.anio = anio;
			this.costoXKM = costoXKM;
			this.AptoLiq = aptoLiq;
			this.capacidad = capacidad;
		}
		
		public Camion() {
			super();
			this.id = null;
			this.marca = null;
			this.modelo = null;
			this.dominio = null;
			this.anio = 0;
			this.costoXKM = 0;
			this.AptoLiq = false;
			this.capacidad = 0;
		}
		
public ArrayList<Insumo> insumoOptimos(Planta planta) {
			
	
	ArrayList<Integer> pesoAux = new ArrayList<>();
	ArrayList<Integer> valorAux = new ArrayList<>();
	ArrayList<Insumo> insumoAux = new ArrayList<>();
	
	for(Stock stock:planta.getStocks()) {
		if(stock.getCantidad()<stock.getPuntoPedido()) {
			insumoAux.add(stock.getInsumo());
			pesoAux.add((int)((stock.getPuntoPedido()-stock.getCantidad())*stock.getInsumo().getPeso()));
			valorAux.add((int)((stock.getPuntoPedido()-stock.getCantidad())*stock.getInsumo().getCosto()));
		}
	}
	
	if(insumoAux.isEmpty()) return insumoAux;
	
	Insumo[] insumo = new Insumo[insumoAux.size()];
	int[] peso = new int[insumoAux.size()];
	int[] valor = new int[insumoAux.size()];
	
	for(int i=0;i<insumoAux.size();i++) {
		insumo[i]=insumoAux.get(i);
		peso[i]=pesoAux.get(i);
		valor[i]=valorAux.get(i);
	}
	
	System.out.println(insumo);
	   int cant = insumoAux.size(); // items
	   int pesoCamion = capacidad+1; // max peso
	   
	   int[][] escenario = new int[cant][pesoCamion]; //matriz guarda valor de cada escenario
	   boolean[][] posible = new boolean[cant][pesoCamion]; // matriz guarda si el element esta en el escenario
	   
	   for (int n = 0; n < cant; n++) {
	       for (int w = 0; w < pesoCamion; w++) {
	           int opcion1 = (n < 1) ? n : escenario[n-1][w]; 
	           int opcion2 = Integer.MIN_VALUE;
	               if (peso[n] <= w) { 
	            	   if(n==0)
	            		   opcion2 = valor[n] + escenario[n][w - peso[n]];
	            	   else 
	            		   opcion2 = valor[n] + escenario[n-1][w - peso[n]]; 
	               }
	               
	               escenario[n][w] = Math.max(opcion1, opcion2);
	           posible[n][w] = (opcion2 > opcion1);
	       }
	   }
	
	   
	   boolean[] resultado= new boolean[cant];
	   
	   for (int n = cant-1, w = pesoCamion-1; n >= 0; n--) {
	       if (posible[n][w]) {
	           resultado [n] = true;
	           w = w - peso[n];
	       } else {
	           resultado [n] = false;
	       }
	   }
	   
	   
	   insumoAux = new ArrayList<>();
	   
	   for(int i=0;i<insumo.length;i++) {
		   if(resultado[i]) insumoAux.add(insumo[i]);
	   }
	   
	   return insumoAux;
	   
}
}