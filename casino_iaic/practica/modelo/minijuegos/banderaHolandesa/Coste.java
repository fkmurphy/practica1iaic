package practica.modelo.minijuegos.banderaHolandesa;


import aima.search.framework.StepCostFunction;

public class Coste  implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
	    banderaHolandesa b =  (banderaHolandesa) toState;
        Double distancia = new Double(b.getCosteop());
   	    return distancia;
	}
}
