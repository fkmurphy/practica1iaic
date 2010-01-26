package practica.modelo.search;

import java.util.Comparator;

import aima.search.framework.EvaluationFunction;
import aima.search.framework.Node;
import aima.search.framework.Problem;
import aima.search.framework.QueueSearch;


public class CasinoBestFirstSearch extends CasinoPrioritySearch{

	private final EvaluationFunction evaluationFunction;
	
	
	public CasinoBestFirstSearch(CasinoQueueSearch search, EvaluationFunction ef) {
		this.search = search;
		evaluationFunction = ef;
	}
	
	protected Comparator<Node> getComparator(final Problem p) {
		return new Comparator<Node>() {
			public int compare(Node one, Node two) {
				Double f1 = evaluationFunction.getValue(p, one);
				Double f2 = evaluationFunction.getValue(p, two);

				return f1.compareTo(f2);
			}
		};
	}

}
