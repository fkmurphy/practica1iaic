package practica.modelo.minijuegos.Palillos;


import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	public boolean isGoalState(Object state) {
		Palillos p = (Palillos)state;
		return p.isGoal();
	}

}
