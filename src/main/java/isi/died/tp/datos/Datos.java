package isi.died.tp.datos;

import java.awt.List;
import java.util.ArrayList;

import isi.died.tp.dominio.*;
import isi.died.tp.estructuras.GrafoPlanta;

public class Datos {
	private ArrayList<Insumo> listaInsumos;
	private ArrayList<Planta> listaPlantas;
	private ArrayList<Camion> listaCamiones;
	private ArrayList<Stock> listaStocks;
	private ArrayList<Ruta> listaRutas;
	private GrafoPlanta grafo;
	
	public Datos() {
		grafo = new GrafoPlanta();
		listaInsumos = new ArrayList<Insumo>();
		listaPlantas = new ArrayList<Planta>();
		listaCamiones = new ArrayList<Camion>();
		listaStocks = new ArrayList<Stock>();
		listaRutas = new ArrayList<Ruta>();
		
		listaPlantas.add(grafo.getAcopioPuerto());
		listaPlantas.add(grafo.getAcopioFinal());
		
		Insumo i1=new Insumo("0","I1a",500,5.6,5000,false,UnidadMedida.UNIDAD);
		Insumo i2=new Insumo("1","I2a",600,2.4,6000,false,UnidadMedida.UNIDAD);
		Insumo i3=new Insumo("2","I3",1100,2,5000,false,UnidadMedida.UNIDAD);
		Insumo i4=new Insumo("3","I4",200,1,100,false,UnidadMedida.UNIDAD);
		Insumo i5=new Insumo("4","I5",100,5.6,200,false,UnidadMedida.UNIDAD);
		Insumo i6=new Insumo("5","I6",600,2.4,40,false,UnidadMedida.UNIDAD);
		Insumo i7=new Insumo("6","I1b",6100,2,5400,false,UnidadMedida.UNIDAD);
		Insumo i8=new Insumo("7","I7",700,1,700,false,UnidadMedida.UNIDAD);
		Insumo i9=new Insumo("8","I8",500,5.6,1000,false,UnidadMedida.UNIDAD);
		Insumo i10=new Insumo("9","I2b",600,2.4,2000,false,UnidadMedida.UNIDAD);
		Insumo i11=new Insumo("10","I9",700,2,700,false,UnidadMedida.UNIDAD);
		Insumo i12=new Insumo("11","I10",300,1,300,false,UnidadMedida.UNIDAD);
		
		this.agregarInsumo(i1);
		this.agregarInsumo(i2);
		this.agregarInsumo(i3);
		this.agregarInsumo(i4);
		this.agregarInsumo(i5);
		this.agregarInsumo(i6);
		this.agregarInsumo(i7);
		this.agregarInsumo(i8);
		this.agregarInsumo(i9);
		this.agregarInsumo(i10);
		this.agregarInsumo(i11);
		this.agregarInsumo(i12);
		
		Planta p1= new Planta(2,"Planta A");
		Planta p2= new Planta(3,"Planta B");
		Planta p3= new Planta(4,"Planta C");
		
		this.agregarPlanta(p1);
		this.agregarPlanta(p2);
		this.agregarPlanta(p3);
		
		Stock s1 = new Stock(0,200,100,i1);
		Stock s2 = new Stock(1,100,500,i2);
		Stock s3 = new Stock(2,600,500,i4);
		
		this.agregarStock(p1,s1);
		this.agregarStock(p2,s2);
		this.agregarStock(p2,s3);
		
		Ruta r1= new Ruta(11,60,40,this.getListaPlantas().get(0),this.getListaPlantas().get(1));
		Ruta r2= new Ruta(5,20,20,this.getListaPlantas().get(0),p1);
		Ruta r3= new Ruta(6,22,20,this.getListaPlantas().get(0),p2);
		Ruta r4= new Ruta(14,180,40,p3,this.getListaPlantas().get(1));
		Ruta r5= new Ruta(20,170,60,p2,this.getListaPlantas().get(1));
		Ruta r6= new Ruta(10,180,40,p1,p3);
		Ruta r7= new Ruta(22,170,60,p1,p2);
		
		this.agregarRuta(r1);
		this.agregarRuta(r2);
		this.agregarRuta(r3);
		this.agregarRuta(r4);
		this.agregarRuta(r5);
		this.agregarRuta(r6);
		this.agregarRuta(r7);
		
		Insumo i13=new Insumo("A","A1",0,3,600,false,UnidadMedida.UNIDAD);
		Insumo i14=new Insumo("B","A2",0,2,900,false,UnidadMedida.UNIDAD);
		Insumo i15=new Insumo("C","A3",0,1,500,false,UnidadMedida.UNIDAD);
		Insumo i16=new Insumo("D","A4",0,2,600,false,UnidadMedida.UNIDAD);
		
		this.agregarInsumo(i13);
		this.agregarInsumo(i14);
		this.agregarInsumo(i15);
		this.agregarInsumo(i16);
		
		Stock s4 = new Stock(3,600,700,i13);
		Stock s5 = new Stock(4,100,200,i14);
		Stock s6 = new Stock(5,200,300,i15);
		Stock s7 = new Stock(6,200,300,i16);
		
		this.agregarStock(p3,s4);
		this.agregarStock(p3,s5);
		this.agregarStock(p3,s6);
		this.agregarStock(p3,s7);
		
		Camion c0 = new Camion("001","m1","mod1","AAA111",2010,50,true,400);
		Camion c1 = new Camion("001","m1","mod1","AAA111",2010,50,true,300);
		Camion c2 = new Camion("002","m1","mod2","AAA222",2011,50,false,400);
		Camion c3 = new Camion("003","m1","mod3","AAA333",2012,50,true,5400);
		Camion c4 = new Camion("004","m2","mod1","AAA444",2009,50,false,300);
		Camion c5 = new Camion("005","m2","mod2","AAA555",2008,50,true,600);
		Camion c6 = new Camion("006","m2","mod3","BBB111",2010,50,false,344);
		Camion c7 = new Camion("007","m3","mod1","BBB222",2011,50,true,744);
		Camion c8 = new Camion("008","m3","mod2","BBB333",2012,50,false,444);
		Camion c9 = new Camion("009","m3","mod3","BBB444",2013,50,true,554);
		Camion c10 = new Camion("010","m4","mod1","BBB555",2014,50,false,65);
		Camion c11 = new Camion("011","m4","mod2","CCC111",2015,50,true,104);
		
		listaCamiones.add(c0);
		listaCamiones.add(c1);
		listaCamiones.add(c2);
		listaCamiones.add(c3);
		listaCamiones.add(c4);
		listaCamiones.add(c5);
		listaCamiones.add(c6);
		listaCamiones.add(c7);
		listaCamiones.add(c8);
		listaCamiones.add(c9);
		listaCamiones.add(c10);
		listaCamiones.add(c11);
	}
	
	public Datos(Datos datos1) {
		this.setListaInsumos(datos1.getListaInsumos());
		this.setListaPlantas(datos1.getListaPlantas());
		this.setListaCamiones(datos1.getListaCamiones());
		this.setListaStocks(datos1.getListaStocks());
		this.setListaRutas(datos1.getListaRutas());
		this.setGrafo(datos1.getGrafo());
	}
	
	public void agregarInsumo(Insumo insumo) {
		listaInsumos.add(insumo);
	}
	
	public void agregarPlanta(Planta planta) {
		listaPlantas.add(planta);
		grafo.addNodo(planta);
	}
	
	public void agregarStock(Planta planta,Stock stock) {
		listaStocks.add(stock);
		planta.agregarStock(stock);
	}
	
	public void agregarRuta(Ruta ruta) {
		listaRutas.add(ruta);
		grafo.conectar(ruta.getInicio().getValor(),ruta.getFin().getValor(),ruta.getDistancia(),ruta.getPesoMaxEnToneladas());
	}

	public ArrayList<Insumo> getListaInsumos() {
		return listaInsumos;
	}

	public void setListaInsumos(ArrayList<Insumo> listaInsumos) {
		this.listaInsumos = listaInsumos;
	}

	public ArrayList<Planta> getListaPlantasNormal() {
		return listaPlantas;
	}
	public ArrayList<Planta> getListaPlantas() {
		return grafo.getVertices();
	}
	
	public ArrayList<Planta> plantasSinInsumo(Insumo insumo){
		return grafo.plantasSinInsumo(insumo);
	}
	
	public void setListaPlantas(ArrayList<Planta> listaPlantas1) {
		this.listaPlantas = listaPlantas1;
	}

	public ArrayList<Camion> getListaCamiones() {
		return listaCamiones;
	}

	public void setListaCamiones(ArrayList<Camion> listaCamiones) {
		this.listaCamiones = listaCamiones;
	}

	public ArrayList<Stock> getListaStocks() {
		return listaStocks;
	}

	public void setListaStocks(ArrayList<Stock> listaStocks) {
		this.listaStocks = listaStocks;
	}
	
	public Object[][] getBusquedaInsumos() {
		Object [][] aux = new Object[this.listaInsumos.size()][3]; 
		
		for(int i=0; i<this.listaInsumos.size(); i++) {
			aux[i][0]= listaInsumos.get(i).getDescripcion();
			aux[i][1]= listaInsumos.get(i).getCosto();
			aux[i][2]= listaInsumos.get(i).getStock();
		}
		
		return aux;
	}
	
	public Object[][] getBusquedaCamiones(){
		Object[][] aux=new Object[this.listaCamiones.size()][4];
		String liq = new String();
		for(int i=0; i<this.listaCamiones.size(); i++) {
			aux[i][0]=listaCamiones.get(i).getId();
			aux[i][1]=listaCamiones.get(i).getDominio();
			aux[i][2]=listaCamiones.get(i).getCapacidad();
			if(listaCamiones.get(i).isAptoLiq()) {
				liq="Si";
			} else {
				liq="No";
			}
			aux[i][3]=liq;
		}
		
		return aux;
	}
	
	public Object[][] getBusquedaPlantas(){
		Object [][] aux=new Object[this.listaPlantas.size()][2];
		
		for(int i=0; i<this.listaPlantas.size(); i++) {
			aux[i][0]=listaPlantas.get(i).getId();
			aux[i][1]=listaPlantas.get(i).getNombre();
		}
		return aux;
	}
	public Object[][] getBusquedaPlantasConPageRank(){
		Object [][] aux=new Object[this.listaPlantas.size()][3];
		
		for(int i=0; i<this.listaPlantas.size(); i++) {
			aux[i][0]=listaPlantas.get(i).getId();
			aux[i][1]=listaPlantas.get(i).getNombre();
			aux[i][2]=listaPlantas.get(i).getPageRank();
		}
		return aux;
	}
	
	public Object[] listaInsumosString() {
		Object [] aux = new Object[this.listaInsumos.size()+1]; 
		aux[0]="Seleccione un insumo";
		for(int i=0; i<this.listaInsumos.size(); i++) {
			aux[i+1]=listaInsumos.get(i).getDescripcion();
		}
		
		return aux;
	}
	
	public Object[] listaPlantasString() {
		Object [] aux = new Object[this.listaPlantas.size()-1]; 
		aux[0]="Seleccione una planta";
		for(int i=2; i<this.listaPlantas.size(); i++) {
			aux[i-1]=listaPlantas.get(i).getNombre();
		}
		
		return aux;
	}
	
	public Insumo buscarInsumo(String nombre, double costo, int stock) {
		for(Insumo in:listaInsumos) {
			if(in.getDescripcion().compareTo(nombre)==0 && in.getCosto()==costo && in.getStock()==stock) return in;
		}
		return null;
	}
	public Insumo buscarInsumo(String nombre) {
		for(Insumo in:listaInsumos) {
			if(in.getDescripcion().compareTo(nombre)==0) return in;
		}
		return null;
	}

	public Insumo buscarInsumoNombre(String nombre) {
		for(Insumo in:listaInsumos) {
			if(in.getDescripcion().compareTo(nombre)==0) return in;
		}
		return null;
	}
	
	public ArrayList<Ruta> getListaRutas() {
		return listaRutas;
	}

	public void setListaRutas(ArrayList<Ruta> listaRutas) {
		this.listaRutas = listaRutas;
	}

	public GrafoPlanta getGrafo() {
		return grafo;
	}

	public void setGrafo(GrafoPlanta grafo) {
		this.grafo = grafo;
	}
	
	public Planta buscarPlanta(int id, String nombre) {
		for(Planta pl:listaPlantas) {
			if(pl.getId()==id && pl.getNombre().compareTo(nombre)==0) return pl;
		}
		return null;
	}
	public Planta buscarPlanta(String nombre) {
		for(Planta pl:listaPlantas) {
			if(pl.getNombre().compareTo(nombre)==0) return pl;
		}
		return null;
	}
	
	public Camion buscarCamion(String id, String dominio) {
		for(Camion cam:listaCamiones) {
			if(cam.getId().contains(id) && cam.getDominio().contains(dominio)) return cam;
		}
		return null;
	}
	public ArrayList<Ruta> rutasPlantas(ArrayList<Planta> listaDePlantas){
		
		ArrayList<Ruta> listaDeRutas = new ArrayList<>();
		
		int cont=1;
		for(Ruta ruta:listaRutas) {
			cont=1;
			for(Planta planta:listaDePlantas) {
				if(cont<listaDePlantas.size()) {
					if((ruta.getInicio().getValor().getId()==listaDePlantas.get(cont-1).getId())&&(ruta.getFin().getValor().getId()==listaDePlantas.get(cont).getId())){
						listaDeRutas.add(ruta);
					}
				}
				cont++;
			}
		}
		return listaDeRutas;
	}
	public Object[][] getBusquedaRutas() {
		Object [][] aux = new Object[this.listaRutas.size()][5]; 
		
		for(int i=0; i<this.listaRutas.size(); i++) {
			aux[i][0]= listaRutas.get(i).getInicio().getValor().getNombre();
			aux[i][1]= listaRutas.get(i).getFin().getValor().getNombre();
			aux[i][2]= listaRutas.get(i).getDistancia();
			aux[i][3]= listaRutas.get(i).getDuracionEnMin();
			aux[i][4]= listaRutas.get(i).getPesoMaxEnToneladas();
		}
		
		return aux;
	}
	public Ruta buscarRuta(String origen, String destino) {
		for(Ruta rut:listaRutas) {
			if(rut.getInicio().getValor().getNombre().contains(origen) && rut.getFin().getValor().getNombre().contains(destino)) return rut;
		}
		return null;
	}
	public void eliminarRuta(Ruta r) {
		boolean encontrada = false;
		int i=0;
		while(!encontrada) {
			if(this.listaRutas.get(i).getInicio().getValor().getNombre().contains(r.getInicio().getValor().getNombre()) && this.listaRutas.get(i).getFin().getValor().getNombre().contains(r.getFin().getValor().getNombre())) {
				listaRutas.remove(i);
				encontrada=true;
			}
			i++;
		}
		r.getFin().getValor().decrementarPageRank();
		
	}
	public boolean idUnicoPlanta(int id) {
		for(Planta planta:this.listaPlantas) {
			if(planta.getId()==id) {
				return false;
			}
		}
		return true;
	}
	public void eliminarPlanta (Planta planta) {
	this.listaPlantas.remove(planta);
	ArrayList<Ruta> rutas = new ArrayList<Ruta>();
	for(Ruta r:listaRutas) {
		if(!(r.getInicio().getValor().equals(planta)) && !(r.getFin().getValor().equals(planta)))
			rutas.add(r);
	}
	this.listaRutas.clear();
	this.setListaRutas(rutas);
	this.grafo.eliminarPlantaGrafo(planta);
		
	}
}