package practica.modelo.minijuegos.NB;


import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	public boolean isGoalState(Object state) {
		NB p = (NB)state;
		return p.isGoal();
	}

}
