package practica.modelo.minijuegos.NB;


import aima.search.framework.HeuristicFunction;

public class Heur’stica implements HeuristicFunction {

	public double getHeuristicValue(Object state) {
		NB m = (NB)state;
		return m.h() ;
	}

}
