package practica.modelo.minijuegos.banderaHolandesa;

import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest {

	public boolean isGoalState(Object state) {
		banderaHolandesa b = (banderaHolandesa)state;
		
		return b.isGoal();
	}

}
