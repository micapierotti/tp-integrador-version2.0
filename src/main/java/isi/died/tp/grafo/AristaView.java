package isi.died.tp.grafo;

import java.awt.Color;
import java.awt.Graphics;
import isi.died.tp.dominio.Ruta;

public class AristaView {
	
	private int x1,y1,x2,y2;
	private VerticeView nodo1, nodo2;
	private String nombre;
	private int id;
	private Ruta ruta;
	private boolean pintar=false;
	
	public AristaView(VerticeView nodo1,VerticeView nodo2,String nombre,int id, Ruta ruta) {
		this.ruta=ruta;
		this.x1=nodo1.getX();
		this.y1=nodo1.getY();
		this.x2=nodo2.getX();
		this.y2=nodo2.getY();
		this.nodo1=nodo1;
		this.nodo2=nodo2;
		this.nombre=nombre;
		this.id=id;
	}
	
	public AristaView(VerticeView nodo1,VerticeView nodo2,String nombre,int id, Ruta ruta,boolean pintar) {
		this.ruta=ruta;
		this.x1=nodo1.getX();
		this.y1=nodo1.getY();
		this.x2=nodo2.getX();
		this.y2=nodo2.getY();
		this.nodo1=nodo1;
		this.nodo2=nodo2;
		this.nombre=nombre;
		this.id=id;
		this.pintar=pintar;
	}
	
	public boolean isPintar() {
		return pintar;
	}

	public void setPintar(boolean pintar) {
		this.pintar = pintar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void pintar(Graphics g){
		
		g.setColor(Color.BLACK);
		if(pintar) g.setColor(Color.RED);
		g.drawLine(x1,y1,x2,y2);
		
		if(x1>x2 && y1>y2) g.drawString(nombre, x1-Math.abs((x1-x2)/2), y1- Math.abs((y1-y2)/2));

		if(x1<x2 && y1<y2) g.drawString(nombre, x2-Math.abs((x1-x2)/2), y2- Math.abs((y1-y2)/2));

		if(x1>x2 && y1<y2) g.drawString(nombre, x1-Math.abs((x1-x2)/2), y2- Math.abs((y1-y2)/2));

		if(x1<x2 && y1>y2) g.drawString(nombre, x2-Math.abs((x1-x2)/2), y1- Math.abs((y1-y2)/2));
		
		g.setColor(Color.BLACK);
	
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public VerticeView getNodo1() {
		return nodo1;
	}

	public void setNodo1(VerticeView nodo1) {
		this.nodo1 = nodo1;
	}

	public VerticeView getNodo2() {
		return nodo2;
	}

	public void setNodo2(VerticeView nodo2) {
		this.nodo2 = nodo2;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
}
