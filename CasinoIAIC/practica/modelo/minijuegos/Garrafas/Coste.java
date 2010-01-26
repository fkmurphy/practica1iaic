package practica.modelo.minijuegos.Garrafas;


import aima.search.framework.*;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		
		
		Garrafas g =  (Garrafas) toState;
        Double cost = new Double(g.getCoste());
        return cost;
	}

}
