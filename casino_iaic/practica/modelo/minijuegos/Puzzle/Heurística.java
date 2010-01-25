package practica.modelo.minijuegos.Puzzle;

import aima.search.framework.HeuristicFunction;


public class Heur’stica implements HeuristicFunction {
	
	
	

	public double getHeuristicValue(Object state) {
		Puzzle m = (Puzzle)state;
		return m.h();
	}
	
}
