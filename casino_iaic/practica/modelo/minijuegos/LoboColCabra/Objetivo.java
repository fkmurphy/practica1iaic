package practica.modelo.minijuegos.LoboColCabra;

import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	public boolean isGoalState(Object state) {
		LoboColCabra lobo = (LoboColCabra) state;
		return lobo.isObjetivo();
	}

}
