package practica.modelo.minijuegos.Palillos;


import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction {

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		Palillos p =  (Palillos) toState;
        Double distancia = new Double(p.getCoste());
   	    return distancia;
	}

}
