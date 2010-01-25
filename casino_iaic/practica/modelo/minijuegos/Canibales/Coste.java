package practica.modelo.minijuegos.Canibales;

import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
				Canibales canibales = (Canibales) toState;
				return canibales.getEstadoActual().getCoste();
	}

}
