package practica.modelo.minijuegos.LoboColCabra;

import aima.search.framework.HeuristicFunction;

public class Heuristica implements HeuristicFunction{

	public double getHeuristicValue(Object state) {
		LoboColCabra lobo = (LoboColCabra) state;
		return lobo.dameHeuristica();
	}

}
