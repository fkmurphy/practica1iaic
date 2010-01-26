package practica.modelo.minijuegos.Mono;

import aima.search.framework.*;

public class Objetivo implements GoalTest {
	
	
	public boolean isGoalState(Object state) {
		Mono m = (Mono)state;
		return m.esObjetivo();
	}
}
