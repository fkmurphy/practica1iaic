package practica.modelo.minijuegos.nReinas2;


import practica.modelo.minijuegos.Juego;
import aima.search.nqueens.*;

public class JuegoNReinas extends Juego{

	public JuegoNReinas() {
		super("Reinas", new NQueensBoard(4), new NQueensSuccessorFunction(), new NQueensGoalTest(), new Coste(), new QueensToBePlacedHeuristic());
		// TODO Auto-generated constructor stub
	}

}
