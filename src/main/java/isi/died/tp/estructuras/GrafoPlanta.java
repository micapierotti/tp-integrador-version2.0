package isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.List;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;
import isi.died.tp.dominio.Stock;

public class GrafoPlanta extends Grafo<Planta> {
	
	private Planta acopioPuerto,acopioFinal;
	
	public GrafoPlanta(){
		super();
		
		acopioPuerto= new Planta(0,"Acopio Puerto");
		acopioFinal= new Planta(1,"Acopio Final");
		
		this.addNodo(acopioPuerto);
		this.addNodo(acopioFinal);
	}
	
	
	public Planta getAcopioPuerto() {
		return acopioPuerto;
	}


	public void setAcopioPuerto(Planta acopioPuerto) {
		this.acopioPuerto = acopioPuerto;
	}


	public Planta getAcopioFinal() {
		return acopioFinal;
	}


	public void setAcopioFinal(Planta acopioFinal) {
		this.acopioFinal = acopioFinal;
	}


	public void imprimirDistanciaAdyacentes(Planta inicial) {
	
		List<Planta> adyacentes = super.getAdyacentes(inicial);
		for(Planta unAdyacente: adyacentes) {
			
			Arista<Planta> camino = super.buscarArista(inicial, unAdyacente);
			System.out.println("camino de "+inicial.getNombre()+" a "+ unAdyacente.getNombre()+ " tiene valor de "+ camino.getValor() );
			}
		}
 // a
	public Planta buscarPlanta(Planta inicial, Insumo i, Integer saltos) {
		
		if(saltos==0) return null;
		
		
		if(inicial.necesitaInsumo(i))
			return inicial;
		else{
			List<Planta> plantasAd = this.getAdyacentes(inicial);
			Integer saltosAux = saltos -1;
			for (int cont=0; cont<plantasAd.size(); cont++) {
				Planta planta1= this.buscarPlanta(plantasAd.get(cont), i, saltosAux);
				if(planta1 != null) return planta1;
			}
		}
		
		return null;
	}
	
	
 // b
	public Planta buscarPlanta(Planta inicial, Insumo i) { 
		
		if(inicial.necesitaInsumo(i))
			return inicial;
		else {
			Vertice<Planta> inicial1= new Vertice<Planta> (inicial);
			List<Planta> plantasOrd = this.recorridoAnchura(inicial1);
			for(int c=0;c<plantasOrd.size();c++) {
				if(plantasOrd.get(c).necesitaInsumo(i)) return plantasOrd.get(c);
			}
		}	
		return null;
	}
 // c
	public Planta buscarPlanta(Insumo i) {
		int max=0;
		Planta planta=null;
		Vertice<Planta> inicial=this.vertices.get(0);
		List<Planta> plantasOrd = this.recorridoAnchura(inicial);
		for(int c=0;c<plantasOrd.size();c++) {
			if(plantasOrd.get(c).necesitaInsumo(i)) {
				ArrayList<Stock> listastocks= plantasOrd.get(c).getStocks();
				for(int cont=0; cont<listastocks.size(); cont++) {
					if(listastocks.get(cont).getInsumo()==i) {
						if(((listastocks.get(cont).getPuntoPedido())-(listastocks.get(cont).getCantidad()))>max){
							max=((listastocks.get(cont).getPuntoPedido())-(listastocks.get(cont).getCantidad()));
							planta= plantasOrd.get(c);
						}
					}
				}
			}
		}
	return planta;	
	
	}
	public ArrayList<Ruta> caminoPlanta() {
		// TODO Auto-generated method stub
		return new ArrayList<Ruta>();
	}
}
