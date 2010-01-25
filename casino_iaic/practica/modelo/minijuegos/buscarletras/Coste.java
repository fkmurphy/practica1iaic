package practica.modelo.minijuegos.buscarletras;


import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		buscarLetras b =  (buscarLetras) toState;
        Double distancia = new Double(b.getCoste());
   	    return distancia;
	}
}
