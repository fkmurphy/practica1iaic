package practica.modelo.minijuegos.Puzzle;


import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		Puzzle p =  (Puzzle) toState;
        Double distancia = new Double(p.getCoste());
   	    return distancia;
	}

}
