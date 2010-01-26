package practica.modelo.minijuegos.Caballo;


import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest {

	public boolean isGoalState(Object state) {
		Caballo c = (Caballo)state;
		
		return c.isGoal();
	}

}
