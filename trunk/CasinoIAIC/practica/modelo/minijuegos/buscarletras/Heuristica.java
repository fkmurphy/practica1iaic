package practica.modelo.minijuegos.buscarletras;


import aima.search.framework.HeuristicFunction;

public class Heuristica implements HeuristicFunction {
	
	
	

	public double getHeuristicValue(Object state) {
		buscarLetras b = (buscarLetras)state;
		return b.h();
	}
}
