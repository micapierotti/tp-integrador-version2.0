package isi.died.tp.grafo;

import java.awt.Color;
import java.awt.Graphics;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
	
public class VerticeView {
	private int x,y;
	private int id;
	private String nombre;
	public static final int d=40;
	private Planta planta;
	private boolean pintar=false;
	
	public VerticeView(int x,int y,String nombre,int id, Planta planta) {
		this.planta=planta;
		this.id=id;
		this.x=x;
		this.y=y;
		this.nombre=nombre;
	}
	
	public VerticeView(int x,int y,String nombre,int id, Planta planta,boolean pintar) {
		this.planta=planta;
		this.id=id;
		this.x=x;
		this.y=y;
		this.nombre=nombre;
		this.pintar=pintar;
	}
	
	
	public boolean isPintar() {
		return pintar;
	}

	public void setPintar(boolean pintar) {
		this.pintar = pintar;
	}

	public void pintar(Graphics g) {
		
		g.setColor(Color.BLACK);
		if(pintar) {
	//		System.out.println(planta.getNombre()+" pinto rojo");
			g.setColor(Color.RED);
		}
		g.drawOval(this.x -d/2,this.y-d/2,d,d);
		g.drawString(nombre,x,y);
		g.setColor(Color.BLACK);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getD() {
		return d;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}
	
	
	
}
