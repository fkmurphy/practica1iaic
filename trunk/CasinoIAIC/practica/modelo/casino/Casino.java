package practica.modelo.casino;

import practica.modelo.GestorModelo;
import practica.modelo.Log.Log;

public class Casino {

	
	private static int numZonas;
	private static int numObjetivos;
	private Jugador jugador;
	private String casinoString;
	private Zona zona;
	private Log log;
	
	
	public Casino(int numZonas, int numObjetivos, Jugador jugador, String string)
	{
		this.numZonas=numZonas;
		this.numObjetivos=numObjetivos;
		this.jugador=jugador;
		this.casinoString=string;
		this.zona=jugador.getZonaActual();
	}

	public Casino(Zona origen, Jugador jugador,int numZonas,int numObjetivos, String string)
	{
		this.numZonas=numZonas;
		this.numObjetivos=numObjetivos;
		this.jugador=jugador;
		this.casinoString=string;
		this.zona = origen;
	}


	public Casino(Zona zona)
	{
		this.zona=zona;
		this.jugador= new Jugador();
		this.jugador.setZonaActual(zona);
	}
	public static int getNumZonas() {
		return numZonas;
	}


	public static void setNumZonas(int numZonas) {
		Casino.numZonas = numZonas;
	}


	public static int getNumObjetivos() {
		return numObjetivos;
	}


	public static void setNumObjetivos(int numObjetivos) {
		Casino.numObjetivos = numObjetivos;
	}


	public Jugador getJugador() {
		return jugador;
	}


	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}


	public String getCasinoString() {
		return this.casinoString;
	}


	public void setCasinoString(String casinoAString) {
		this.casinoString= casinoAString;
	}
	
	
	
	public void registerLog(Log log)
	{
		this.log=log;
	}

	
	public Zona getZonaActual()
	{
		return this.zona;
	}
	
	
	public boolean jugarApuesta()
	{
		if (this.jugador.juegaPrueba(this.zona))
			return true;
			else return false;
	}
	
	
}
