package practica.modelo.casino;

import practica.Controlador.Controlador;
import practica.modelo.Log.Log;

public class Jugador {
	
	
	
	private Zona zonaActual;
	
	private int diasGanados;
	
	//private Controlador controlador;
	
	public Jugador()
	{
		
	}
	
	public Jugador(Zona zonaActual)
	{
		this.zonaActual = zonaActual;
	}
	public Zona getZonaActual() {
		return zonaActual;
	}

	public void setZonaActual(Zona zonaActual) {
		this.zonaActual = zonaActual;
	}
	
	public Integer dameApuestade(Zona zonaSiguiente)
	{
		Log.addCasino("El explorador mira en la puerta de la zona:  "+this.zonaActual.dameNombreZona()+" para saber cual es su apuesta.\n");
		//this.controlador.vistaMuestraMinijuego("El explorador mira en la puerta de la zona:  "+this.zonaActual.dameNombreZona()+" para saber cual es su apuesta.\n");
		
		Integer apuesta = zonaSiguiente.getPuerta().getApuesta();
		
		//Integer estTot=zonaSiguiente.menorDificultad()+ apuesta;
		
//		Log.addCasino(zonaSiguiente.dameNombreZona()+" responde que tiene una apuesta de "+apuesta.intValue()+" y con estimacion a objetivo de "+zonaSiguiente.menorDificultad()+" apuesta.\n" +
//	               " Por lo tanto pasando por "+zonaSiguiente.dameNombreZona() +" se estima que llegue a un zona objetivo en "+estTot+" apuestas\n");

		//this.controlador.vistaMuestraMinijuego(zonaSiguiente.dameNombreZona()+" responde que tiene una apuesta de "+apuesta.intValue());
		
		return zonaSiguiente.getPuerta().getApuesta();
	}

	public int getDiasGanados() {
		return diasGanados;
	}

	public void setDiasGanados(int diasGanados) {
		this.diasGanados = diasGanados;
	}

	
	
	///Creo que no deberian pasarle una zona por parametro sino jugar con la zona actual!!
	public boolean juegaPrueba(Zona zona)
	{
		int dinero=0;
		 dinero= zona.getPuerta().ejecutaJuego();
		if (dinero ==0)
			return false;
		else return true;
	}

//
//	public void registerControlador(Controlador controlador)
//	{
//		this.controlador=controlador;
//	}



}
