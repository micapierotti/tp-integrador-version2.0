package isi.died.tp.dominio;

public class Camion {
		private String id;
		private String marca;
		private String modelo;
		private String dominio;
		private int anio;
		private double costoXKM;
		private boolean AptoLiq;
		private double capacidad;
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
		public double getCapacidad() {
			return capacidad;
		}
		public void setCapacidad(double capacidad) {
			this.capacidad = capacidad;
		}
		public Camion(String id, String marca, String modelo, String dominio, int anio, double costoXKM, boolean aptoLiq,
				double capacidad) {
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
}