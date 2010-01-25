package practica.modelo.casino;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import practica.modelo.GestorModelo;



public class Zona {
	
	Puerta puerta;
	private int idZona;
	private TipoZona tipoZona;
	
	private int dificultadLocal;
	private int dificultadPropagada;
	private ArrayList<Zona> zonasContiguas=new ArrayList<Zona>();
	private GestorModelo gestorModelo;
	
	public ArrayList<Zona> getZonasContiguas() {
		return zonasContiguas;
	}

	public void setZonasContiguas(ArrayList<Zona> zonasContiguas) {
		this.zonasContiguas = zonasContiguas;
	}

	public Zona(Puerta puerta, int idZona, TipoZona tipoZona)
	{
		this.puerta=puerta;
		this.idZona=idZona;
		this.tipoZona=tipoZona;
	}
	
	public TipoZona getTipoZona() {
		return tipoZona;
	}

	public void setTipoZona(TipoZona tipoZona) {
		this.tipoZona = tipoZona;
	}


	
	
	public Zona()
	{
		
	}

	public Puerta getPuerta() {
		return puerta;
	}

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public void setPuerta(Puerta puerta) {
		this.puerta = puerta;
	}

	public int menorDificultad() {
		
		
		  Iterator it = this.zonasContiguas.iterator();
		  int menorDificultad=1000000;
		  if (it.hasNext())
		  menorDificultad  = ((Zona) it.next()).getDificultad();
		  Zona aux =null;
		  while (it.hasNext())
		  {
			  aux = (Zona) it.next();
			  if (menorDificultad > aux.getDificultad())
				  menorDificultad= aux.getDificultad();
			  
		  }
		return menorDificultad;
	}
	
	private int getDificultad() {
		
		return this.dificultadLocal;
	}
	
	public void setDificultad(int dificultad){
		this.dificultadLocal=dificultad;
	}

	
	
	public int dameNombreZona()
	{
		return this.idZona;
	}
	
	
	public boolean esObjetivo()
	{
		if (this.tipoZona==TipoZona.OBJETIVO)
			System.out.println("He llegado");
			
		return this.tipoZona == TipoZona.OBJETIVO;
	}

	public void setDificultadPropagada(int propagacion)
	{
		this.dificultadPropagada=propagacion;
	}
	
	public int getDificultadPropagada()
	{
		return this.dificultadPropagada;
	}

	public String dameInformacion() {
		String info = new String();
		
		info = "ID_ZONA "+this.idZona + "CONTIGUOS :" + this.getContiguas2string() + " ESTRATEGIA: "+this.puerta.getIdEstrategia() + " JUEGO: "+this.puerta.getIdJuego();
				
		return info;
	}
	
	public String getContiguas2string(){
		String salida="{";
		Iterator it = this.zonasContiguas.iterator();
		  while (it.hasNext())
		  {
			  Zona zona= (Zona) it.next();
			  salida+= "Z"+zona.getIdZona()+",";
		  }
		  salida+="}";
		  return salida;
	}

	public void register(GestorModelo gm) {
		this.gestorModelo = gm;
		
	}
	
	
}
