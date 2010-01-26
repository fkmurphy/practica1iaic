package practica.modelo.minijuegos.Canibales;

import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	public boolean isGoalState(Object state) {
		
		Canibales canibal = (Canibales) state;
		
		return canibal.esObjetivoLogrado();
	}

}
