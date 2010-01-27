package practica.modelo.minijuegos.Laberinto;


import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	public boolean isGoalState(Object state) {
		Laberinto p = (Laberinto)state;
		return p.isGoal();
	}
	


}
