package isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.List;

public abstract class Arbol<E extends Comparable<E>> {
	
	protected E valor;
	
	public abstract List<E> preOrden();

	public abstract List<E> inOrden();

	public abstract List<E> posOrden();

	public abstract boolean esVacio();

	public abstract E valor();

	public abstract Arbol<E> izquierdo();

	public abstract Arbol<E> derecho();
	
	public abstract boolean contiene(E unValor);

	public abstract boolean equals(Arbol<E> unArbol);
	
	public abstract void agregar(E a);

	public abstract int profundidad();

	public abstract int cuentaNodosDeNivel(int nivel);

	public abstract boolean esCompleto();

	public abstract boolean esLleno();

	protected abstract ArrayList<E> rangoStock(String nombre, int stockMin,int stockMax,ArrayList<E> lista);

	protected abstract ArrayList<E> rangoCosto(String nombre, double costoMin, double costoMax,ArrayList<E> lista);

	protected abstract Object rango(String nombre, int stockMin,int stockMax, double costoMin, double costoMax);	
}