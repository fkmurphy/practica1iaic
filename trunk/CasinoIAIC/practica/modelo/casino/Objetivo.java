package practica.modelo.casino;

import practica.Controlador.Controlador;
import practica.modelo.Log.Log;
import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	private Controlador controlador;
	public boolean isGoalState(Object state) {
		
		Casino casino = (Casino) state;
		
		if (casino.getJugador().getZonaActual().esObjetivo())
			{this.controlador.vistaMuestraMinijuego("\n");
			this.controlador.vistaMuestraMinijuego("Enhorabuena!!! El jugador del casino ha llegado a la zona de salida " + " y sus dias ganados son los siguientes " +casino.getJugador().getDiasGanados()); 
			Log.addCasino("Enhorabuena!!! El jugador del casino ha llegado a la zona de salida " );
			}
			else {this.controlador.vistaMuestraMinijuego("\n");
				Log.addCasino("La zona " + casino.getJugador().getZonaActual().dameNombreZona() + "no es una casilla de fin y ha de seguir jugando");
				this.controlador.vistaMuestraMinijuego("EL JUGADOR DECIDIO JUGAR EN LA ZONA " + casino.getJugador().getZonaActual().dameNombreZona()+ " Y PASÓ LA PRUEBA Y AUMENTÓ SUS DÍAS GANADOS");
				this.controlador.vistaMuestraMinijuego("\n");
				this.controlador.vistaMuestraMinijuego(" A pesar de ello la zona " + casino.getJugador().getZonaActual().dameNombreZona() + " no es una casilla de fin y ha de seguir jugando");
					}
		
		return casino.getJugador().getZonaActual().esObjetivo();
	}
	
	
	public void registerControlador(Controlador controlador)
	{
		this.controlador=controlador;
	}

}
