package practica.modelo.minijuegos.Puzzle;


import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	public boolean isGoalState(Object state) {
		Puzzle p = (Puzzle)state;
		return p.isGoal();
	}
	


}
