package practica.modelo.minijuegos.Mochila;


import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		Mochila p =  (Mochila) toState;
        Double distancia = new Double(p.getCoste());
   	    return distancia;
	}

}
