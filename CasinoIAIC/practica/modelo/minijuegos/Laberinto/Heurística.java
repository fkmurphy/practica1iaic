package practica.modelo.minijuegos.Laberinto;

import aima.search.framework.HeuristicFunction;


public class Heurística implements HeuristicFunction {
	
	
	

	public double getHeuristicValue(Object state) {
		Laberinto m = (Laberinto)state;
		return m.h();
	}
	
}
