package practica.modelo.minijuegos.TorreHanoi;



import aima.search.framework.GoalTest;

public class Objetivo implements GoalTest{

	
		public boolean isGoalState(Object state) {
			TorreHannoi t = (TorreHannoi)state;
			return t.esObjetivo();
		}
	
	
	

}
