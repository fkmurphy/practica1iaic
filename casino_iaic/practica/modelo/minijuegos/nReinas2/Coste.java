package practica.modelo.minijuegos.nReinas2;

import aima.search.framework.StepCostFunction;
import aima.search.nqueens.NQueensBoard;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		NQueensBoard reinas = (NQueensBoard) toState;
		Double cost= new Double(reinas.getCosteOp());
		return cost;
	}

	
	
}
