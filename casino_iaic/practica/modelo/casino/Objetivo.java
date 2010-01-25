package practica.modelo.casino;

import practica.modelo.Log.Log;
import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	public boolean isGoalState(Object state) {
		
		Casino casino = (Casino) state;
		
		if (casino.getJugador().getZonaActual().esObjetivo())
			 Log.addCasino("Enhorabuena!!! El jugador del casino ha llegado a la zona de salida ");
		else Log.addCasino("La zona " + casino.getJugador().getZonaActual().dameNombreZona() + "no es una casilla de fin y ha de seguir jugando");
			
		return casino.getJugador().getZonaActual().esObjetivo();
	}

}
