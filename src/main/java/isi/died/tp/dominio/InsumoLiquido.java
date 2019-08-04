package isi.died.tp.dominio;

public class InsumoLiquido extends Insumo {
	
	private double densidad;
	private double volumen;
	
	public InsumoLiquido(int stock){
		super(stock);
	}
	
	public InsumoLiquido(String i,String des, int s,double den,double vol,double costo,boolean ref,UnidadMedida u){	//vol en m3
		super(i,des,s,vol*den,costo,ref,u);
		this.densidad=den;
		this.volumen=vol;
	}
	
	public double getDensidad() {return densidad;}
	public void setDensidad(double densidad) {this.densidad = densidad;}

	public double getVolumen() {return volumen;}
	public void setVolumen(double vol) {this.densidad = vol;}
	

}
