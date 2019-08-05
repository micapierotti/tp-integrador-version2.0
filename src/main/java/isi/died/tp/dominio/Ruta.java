package isi.died.tp.dominio;

import isi.died.tp.dominio.Planta;
import isi.died.tp.estructuras.Arista;
import isi.died.tp.estructuras.Vertice;

public class Ruta extends Arista<Planta> {
		private double distancia;
		private int duracionEnMin;
		private double pesoMaxEnToneladas;
		
		@Override
		public String toString() {
			return "Ruta [dis=" + distancia + ", dur=" + duracionEnMin + ", peso="
					+ pesoMaxEnToneladas + " inicial="+this.getInicio()+ " fin="+this.getFin()+"]";
		}
		public double getDistancia() {
			return distancia;
		}
		public void setDistancia(double distancia) {
			this.distancia = distancia;
		}
		public int getDuracionEnMin() {
			return duracionEnMin;
		}
		public void setDuracionEnMin(int duracionEnMin) {
			this.duracionEnMin = duracionEnMin;
		}
		public double getPesoMaxEnToneladas() {
			return pesoMaxEnToneladas;
		}
		public void setPesoMaxEnToneladas(double pesoMaxEnToneladas) {
			this.pesoMaxEnToneladas = pesoMaxEnToneladas;
		}
		public Ruta(double distancia, int duracionEnMin, double pesoMaxEnToneladas,Planta plantaInicial, Planta plantaFinal) {
			super(new Vertice<Planta>(plantaInicial),new Vertice<Planta>(plantaFinal));
			
			this.distancia = distancia;
			this.duracionEnMin = duracionEnMin;
			this.pesoMaxEnToneladas = pesoMaxEnToneladas;
			plantaFinal.incrementarPageRank();
		}
		
		public Ruta() {
			super();
			this.distancia=0;
			this.duracionEnMin=0;
			this.pesoMaxEnToneladas=0;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(distancia);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + duracionEnMin;
			temp = Double.doubleToLongBits(pesoMaxEnToneladas);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
		
}
