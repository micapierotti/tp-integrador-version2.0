package isi.died.tp.dominio;

public class Insumo implements Comparable <Insumo> {
	
	protected String id;
	protected String descripcion;
	protected int stockTotal;
	protected double peso;
	protected double costo;
	protected boolean esRefrigerado;
	protected UnidadMedida unidad;	
	
	public Insumo(String id,String descripcion, int stockTotal,double peso,double costo,boolean ref,UnidadMedida unidadMedida){
		this.id=id;
		this.descripcion=descripcion;
		this.stockTotal=stockTotal;
		this.peso=peso;
		this.costo=costo;
		this.esRefrigerado=ref;
		this.unidad=unidadMedida;
	}
	public Insumo(int stock){this.stockTotal=stock;}
	
	public void incrementarInsumo(int stock){this.stockTotal=stockTotal+stock;}
	public void disminuirInsumo(int stock){
		if(stockTotal<stock)this.stockTotal=0;
		else this.stockTotal=stockTotal-stock;}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getDescripcion() {return descripcion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	public int getStock() {return stockTotal;}
	public void setStock(int stock) {this.stockTotal = stock;}
	public double getPeso() {return peso;}
	public void setPeso(double peso) {this.peso = peso;}
	public double getCosto() {return costo;}
	public void setCosto(double costo) {this.costo = costo;}
	public boolean isEsRefrigerado() {return esRefrigerado;}
	public void setEsRefrigerado(boolean esRefrigerado) {this.esRefrigerado = esRefrigerado;}
	public UnidadMedida getUnidad() {return unidad;}
	public void setUnidad(UnidadMedida unidad) {this.unidad = unidad;}
	
	@Override
	public String toString() {
		return "Insumo [id=" + id + "]";
	}

	public int compareTo(Insumo in) {
		if (this.stockTotal>in.getStock()) return 1;
		else if (this.stockTotal<in.getStock()) return -1;
		else if (this.costo>in.getCosto()) return 1;
		else if (this.costo<in.getCosto()) return -1;
		else return this.descripcion.compareTo(in.getDescripcion());	
	}
	

	/*public double pesoPorStock() {
		return stock*peso;
	}
	
	public boolean nombreParecido(String nombre) {
		if(nombre=="") return true;
		else if(this.getDescripcion().length()<nombre.length()) return false;
		else if(this.getDescripcion().substring(0, nombre.length()).compareTo(nombre)==0) return true;
		else return false;
	}*/
}