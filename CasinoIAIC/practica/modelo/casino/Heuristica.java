package practica.modelo.casino;

import aima.search.framework.HeuristicFunction;

public class Heuristica implements HeuristicFunction{

	public double getHeuristicValue(Object state) {
		
		Casino casino = (Casino) state;
		return casino.getJugador().getZonaActual().getDificultadPropagada();
		 
	}

}
