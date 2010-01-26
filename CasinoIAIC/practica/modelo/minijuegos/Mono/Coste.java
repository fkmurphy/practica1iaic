package practica.modelo.minijuegos.Mono;


import aima.search.framework.*;
public class Coste implements StepCostFunction {

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		
		Mono mo =  (Mono) toState;
        Double distancia = new Double(mo.getCoste());
   	    return distancia;
	}

	
}
