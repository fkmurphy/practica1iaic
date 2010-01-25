package practica.modelo.minijuegos.Caballo;


import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		Caballo c =  (Caballo) toState;
        Double cost = new Double(c.getCoste());
        return cost;
	}

}
