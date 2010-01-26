package practica.modelo.minijuegos.buscarletras;


import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest {

	public boolean isGoalState(Object state) {
		buscarLetras l = (buscarLetras)state;
		
		return l.isGoal();
	}

}
