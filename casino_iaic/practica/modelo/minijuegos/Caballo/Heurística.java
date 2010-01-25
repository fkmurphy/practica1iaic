package practica.modelo.minijuegos.Caballo;


import aima.search.framework.HeuristicFunction;

public class Heur’stica implements HeuristicFunction {

	public double getHeuristicValue(Object state) {
		Caballo c = (Caballo)state;
		return c.h();
		
	}

}
