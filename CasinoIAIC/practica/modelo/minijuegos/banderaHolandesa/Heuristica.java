package practica.modelo.minijuegos.banderaHolandesa;

import aima.search.framework.HeuristicFunction;

public class Heuristica implements HeuristicFunction {
	
	
	

	public double getHeuristicValue(Object state) {
		banderaHolandesa b = (banderaHolandesa)state;
		return b.h();
	}
}
