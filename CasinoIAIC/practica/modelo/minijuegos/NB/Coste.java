package practica.modelo.minijuegos.NB;


import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction {

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		NB p =  (NB) toState;
        Double distancia = new Double(p.getCoste());
   	    return distancia;
	}

}
