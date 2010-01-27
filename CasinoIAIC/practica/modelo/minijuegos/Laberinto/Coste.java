package practica.modelo.minijuegos.Laberinto;


import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		Laberinto p =  (Laberinto) toState;
        Double distancia = new Double(p.getCoste());
   	    return distancia;
	}

}
