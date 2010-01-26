package practica.modelo.minijuegos.Palillos;


import aima.search.framework.HeuristicFunction;

public class Heur’stica implements HeuristicFunction {

	public double getHeuristicValue(Object state) {
		Palillos m = (Palillos)state;
		return m.h() ;
	}

}
