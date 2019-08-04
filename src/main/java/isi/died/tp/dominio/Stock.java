package isi.died.tp.dominio;

public class Stock {
	
	private int id;
	private int cantidad;
	private int puntoPedido;
	private Insumo insumo;
	
	public Stock(int id, int cantidad, int puntoPedido, Insumo insumo) {
		this.id=id;
		this.cantidad=cantidad;
		this.puntoPedido=puntoPedido;
		this.insumo=insumo;
	}
	
	public Stock() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPuntoPedido() {
		return puntoPedido;
	}

	public void setPuntoPedido(int puntoPedido) {
		this.puntoPedido = puntoPedido;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
}
