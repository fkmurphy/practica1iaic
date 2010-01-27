package practica.modelo.minijuegos.Mochila;


import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	public boolean isGoalState(Object state) {
		Mochila p = (Mochila)state;
		return p.isGoal();
	}
	


}
