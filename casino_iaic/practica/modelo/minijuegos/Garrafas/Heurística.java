package practica.modelo.minijuegos.Garrafas;

import aima.search.framework.*;

public class Heur’stica implements HeuristicFunction {

	public double getHeuristicValue(Object state) {
		
		Garrafas g = (Garrafas)state;
		return g.Heuristica();
	}

}
