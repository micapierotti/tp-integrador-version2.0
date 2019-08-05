package isi.died.tp.grafo;

import java.awt.Graphics;


import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;

public class Lienzo extends JPanel implements MouseListener, MouseMotionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<VerticeView> listaNodos;
	private ArrayList<AristaView> listaEnlaces;
	private VerticeView nodoaux;
	private VerticeView nodoMover;
	private int iNodo;
	private int contIdNodo=0;
	private int contIdEnlace=0;
	private ArrayList<Integer> enlacesMover;
	private Datos datos;
	private Insumo insumo;
	
	public Lienzo(Datos datos) {
		insumo=null;
		this.listaNodos = new ArrayList<>();
		this.listaEnlaces = new ArrayList<>();
		this.enlacesMover= new ArrayList<>();
		this.datos = datos;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.crearVertices();
		this.crearAristas();
	}
	
	public Lienzo(Insumo insumo, ArrayList<Ruta> listaRutasPintar,Datos datos) {
		this.insumo=insumo;
		this.listaNodos = new ArrayList<>();
		this.listaEnlaces = new ArrayList<>();
		this.enlacesMover= new ArrayList<>();
		this.datos = datos;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.crearVertices(insumo);
		this.crearAristas(listaRutasPintar);
	}
	
	public Lienzo(Planta plantaInicial,Planta plantaFinal, ArrayList<Ruta> listaRutasPintar,Datos datos) {
		this.listaNodos = new ArrayList<>();
		this.listaEnlaces = new ArrayList<>();
		this.enlacesMover= new ArrayList<>();
		this.datos = datos;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.crearVertices(plantaInicial,plantaFinal);
		this.crearAristas(listaRutasPintar);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(VerticeView nodos: listaNodos) {
			nodos.pintar(g);
		}
		for(AristaView enlace:listaEnlaces) {
			enlace.pintar(g);
		}
	}

	public void crearVertices() {

		this.listaNodos.add(new VerticeView(50,250,datos.getListaPlantas().get(0).getNombre(),0,datos.getListaPlantas().get(0)));
		this.listaNodos.add(new VerticeView(700,250,datos.getListaPlantas().get(1).getNombre(),1,datos.getListaPlantas().get(1)));
		contIdNodo=2;
		
		for(int i=2;i<datos.getListaPlantas().size();i++) {
			this.listaNodos.add(new VerticeView(50*i,50*i,datos.getListaPlantas().get(i).getNombre(),i,datos.getListaPlantas().get(i)));
			repaint();
		}
	}
	
	public void crearVertices(Insumo insumo) {
		
		this.listaNodos.add(new VerticeView(50,250,datos.getListaPlantas().get(0).getNombre(),0,datos.getListaPlantas().get(0)));
		this.listaNodos.add(new VerticeView(700,250,datos.getListaPlantas().get(1).getNombre(),1,datos.getListaPlantas().get(1)));
		contIdNodo=2;
		
		for(int i=2;i<datos.getListaPlantas().size();i++) {
			
			this.listaNodos.add(new VerticeView(50*i,50*i,datos.getListaPlantas().get(i).getNombre(),contIdNodo,datos.getListaPlantas().get(i),datos.getListaPlantas().get(i).necesitaInsumo(insumo)));
			contIdNodo++;
			repaint();
		}
	}
	

	public void crearVertices(Planta plantaInicial,Planta plantaFinal) {
		
		if(plantaInicial.getId()==0||plantaFinal.getId()==0) {
			this.listaNodos.add(new VerticeView(50,250,datos.getListaPlantas().get(0).getNombre(),0,datos.getListaPlantas().get(0),true));
		}else {
			this.listaNodos.add(new VerticeView(50,250,datos.getListaPlantas().get(0).getNombre(),0,datos.getListaPlantas().get(0),false));
		}
		
		if(plantaInicial.getId()==1||plantaFinal.getId()==1) {
			this.listaNodos.add(new VerticeView(700,250,datos.getListaPlantas().get(1).getNombre(),1,datos.getListaPlantas().get(1),true));
		}else {
			this.listaNodos.add(new VerticeView(700,250,datos.getListaPlantas().get(1).getNombre(),1,datos.getListaPlantas().get(1),false));
		}
		
		contIdNodo=2;
		
		for(int i=2;i<datos.getListaPlantas().size();i++) {
			if(datos.getListaPlantas().get(i).getId()==plantaInicial.getId()||datos.getListaPlantas().get(i).getId()==plantaFinal.getId()) {
				this.listaNodos.add(new VerticeView(50*i,50*i,datos.getListaPlantas().get(i).getNombre(),contIdNodo,datos.getListaPlantas().get(i),true));
			}else {
				this.listaNodos.add(new VerticeView(50*i,50*i,datos.getListaPlantas().get(i).getNombre(),contIdNodo,datos.getListaPlantas().get(i),false));
			}
			
			contIdNodo++;
			repaint();
		}
	}
	
	public void crearAristas() {
		String nombre;
		VerticeView v1=null,v2=null;
		
		for(Ruta ruta:datos.getListaRutas()) {
			nombre="Dis= "+ruta.getDistancia()+" Dur="+ruta.getDuracionEnMin()+" Peso="+ruta.getPesoMaxEnToneladas();
			
			for(VerticeView vertice:listaNodos) {
				if(vertice.getPlanta().getId()==ruta.getInicio().getValor().getId()) v1=vertice;
				else if(vertice.getPlanta().getId()==ruta.getFin().getValor().getId()) v2=vertice;
			}
			
			this.listaEnlaces.add(new AristaView(v1,v2,nombre,contIdEnlace,ruta));
			contIdEnlace++;
			repaint();
		}
	}
	
	public void crearAristas(ArrayList<Ruta> listaRutasPintar) {
		String nombre;
		VerticeView v1=null,v2=null;
		boolean pintar;
		for(Ruta ruta:datos.getListaRutas()) {
			
			nombre="Dis= "+ruta.getDistancia()+" Dur="+ruta.getDuracionEnMin()+" Peso="+ruta.getPesoMaxEnToneladas();
			
			pintar=listaRutasPintar.contains(ruta);
			
			for(VerticeView vertice:listaNodos) {
				if(vertice.getPlanta()==ruta.getInicio().getValor()) v1=vertice;
				else if(vertice.getPlanta()==ruta.getFin().getValor()) v2=vertice;
			}
			
			this.listaEnlaces.add(new AristaView(v1,v2,nombre,contIdEnlace,ruta,pintar));
			contIdEnlace++;
			repaint();
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int iN=0;
		for(VerticeView nodo: listaNodos) {
			if(new Rectangle(nodo.getX()-VerticeView.d/2, nodo.getY()-VerticeView.d/2,VerticeView.d,VerticeView.d).contains(e.getPoint())) {
				nodoMover=nodo;
				iNodo=iN;
				
				int iE2=0;
				for(AristaView enlace: listaEnlaces) {
					if(new Rectangle(enlace.getX1()-VerticeView.d/2,enlace.getY1()-VerticeView.d/2,VerticeView.d,VerticeView.d).contains(e.getPoint())) {
						if(!enlacesMover.contains(this.listaEnlaces.get(iE2).getId())) enlacesMover.add(this.listaEnlaces.get(iE2).getId());
					}
					else if(new Rectangle(enlace.getX2()-VerticeView.d/2,enlace.getY2()-VerticeView.d/2,VerticeView.d,VerticeView.d).contains(e.getPoint())) {
						if(!enlacesMover.contains(this.listaEnlaces.get(iE2).getId())) enlacesMover.add(this.listaEnlaces.get(iE2).getId());
					}
					iE2++;
				}
				
				break;
			}
			iN++;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		nodoMover=null;
		enlacesMover=new ArrayList<>();
		iNodo=-1;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(insumo!=null) {
			if(nodoMover!=null) {
			nodoaux=new VerticeView(e.getX(),e.getY(),nodoMover.getNombre(),nodoMover.getId(),nodoMover.getPlanta(),nodoMover.isPintar());
			this.listaNodos.set(iNodo,nodoaux);
			int iE=0;
			for(AristaView enlace: listaEnlaces) {
				if(new Rectangle(enlace.getX1()-VerticeView.d/2,enlace.getY1()-VerticeView.d/2,VerticeView.d,VerticeView.d).contains(e.getPoint())&&enlacesMover.contains(enlace.getId())) {
					this.listaEnlaces.set(iE, new AristaView(nodoaux, enlace.getNodo2(), enlace.getNombre(),enlace.getId(),enlace.getRuta(),enlace.isPintar()));
				}
				else if(new Rectangle(enlace.getX2()-VerticeView.d/2,enlace.getY2()-VerticeView.d/2,VerticeView.d,VerticeView.d).contains(e.getPoint())&&enlacesMover.contains(enlace.getId())) {
					this.listaEnlaces.set(iE, new AristaView(enlace.getNodo1(),nodoaux, enlace.getNombre(),enlace.getId(),enlace.getRuta(),enlace.isPintar()));
				}
				iE++;
			}
		}}else {
			if(nodoMover!=null) {
				nodoaux=new VerticeView(e.getX(),e.getY(),nodoMover.getNombre(),nodoMover.getId(),nodoMover.getPlanta(),nodoMover.isPintar());
				this.listaNodos.set(iNodo,nodoaux);
				int iE=0;
				for(AristaView enlace: listaEnlaces) {
					if(new Rectangle(enlace.getX1()-VerticeView.d/2,enlace.getY1()-VerticeView.d/2,VerticeView.d,VerticeView.d).contains(e.getPoint())&&enlacesMover.contains(enlace.getId())) {
						this.listaEnlaces.set(iE, new AristaView(nodoaux, enlace.getNodo2(), enlace.getNombre(),enlace.getId(),enlace.getRuta(),enlace.isPintar()));
					}
					else if(new Rectangle(enlace.getX2()-VerticeView.d/2,enlace.getY2()-VerticeView.d/2,VerticeView.d,VerticeView.d).contains(e.getPoint())&&enlacesMover.contains(enlace.getId())) {
						this.listaEnlaces.set(iE, new AristaView(enlace.getNodo1(),nodoaux, enlace.getNombre(),enlace.getId(),enlace.getRuta(),enlace.isPintar()));
					}
					iE++;
				}
		}}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
