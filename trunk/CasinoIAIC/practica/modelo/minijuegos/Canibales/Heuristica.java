package practica.modelo.minijuegos.Canibales;

import aima.search.framework.HeuristicFunction;

public class Heuristica implements HeuristicFunction{

	public double getHeuristicValue(Object state) {
		Canibales canibales = (Canibales) state;
		return canibales.getEstadoActual().getHeuristica();
	}

}
