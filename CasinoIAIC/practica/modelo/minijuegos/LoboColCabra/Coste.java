package practica.modelo.minijuegos.LoboColCabra;

import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		
		LoboColCabra lobo = (LoboColCabra) toState;
		
		 Double distancia = lobo.dameCosteArista();
	        return distancia;
	}

}
