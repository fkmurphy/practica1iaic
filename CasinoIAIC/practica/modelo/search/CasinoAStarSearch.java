package practica.modelo.search;


import aima.search.framework.QueueSearch;
import aima.search.informed.AStarEvaluationFunction;



public class CasinoAStarSearch extends CasinoBestFirstSearch{

	public CasinoAStarSearch(CasinoQueueSearch search) {
		super(search, new AStarEvaluationFunction());
	}

}
