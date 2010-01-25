package practica.modelo.minijuegos.TorreHanoi;


import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction {

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		TorreHannoi t =  (TorreHannoi) toState;
        Double distancia = new Double(t.getCoste());
   	    return distancia;
	}

}
