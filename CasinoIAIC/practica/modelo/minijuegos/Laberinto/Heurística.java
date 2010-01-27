package practica.modelo.minijuegos.Laberinto;

import aima.search.framework.HeuristicFunction;


public class Heur’stica implements HeuristicFunction {
	
	
	

	public double getHeuristicValue(Object state) {
		Laberinto m = (Laberinto)state;
		return m.h();
	}
	
}
