package practica.modelo.minijuegos.Garrafas;
import aima.search.framework.*;

public class Objetivo implements GoalTest {

	public boolean isGoalState(Object state) {
		
		Garrafas g = (Garrafas)state;
		
		return g.esObjetivo();
	}

}
