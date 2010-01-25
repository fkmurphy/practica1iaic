package practica.modelo.search;

import java.util.Comparator;
import java.util.List;



import aima.search.framework.Metrics;
import aima.search.framework.Node;
import aima.search.framework.Problem;
import aima.search.framework.QueueSearch;
import aima.search.framework.Search;

public abstract class CasinoPrioritySearch implements Search{
	protected CasinoQueueSearch search;
	@Override
	public Metrics getMetrics() {
		return search.getMetrics();
	
	}

	@Override
	public List search(Problem p) throws Exception {
		
		 	return search.search(p, new CasinoPriorityNodeStore(getComparator(p)));
	}


	protected abstract Comparator<Node> getComparator(Problem p);
}
