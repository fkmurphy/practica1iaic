package practica.modelo.search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aima.search.framework.Node;
import aima.search.framework.NodeStore;
import aima.search.framework.Problem;

public class CasinoGraphSearch extends CasinoQueueSearch{

	Set closed;
	@Override
	public void addExpandedNodesToFringe(NodeStore fringe, Node node, Problem problem)
			{
		if(!alreadySeen(node))
		{
			closed.add(node.getState());
			fringe.add(expandNode(node, problem));
		}	}
	
	public CasinoGraphSearch()
	{
		closed = new HashSet();
	}

	private boolean alreadySeen(Node node)
	{
		return closed.contains(node.getState());
	}
	public List search(Problem problem, NodeStore fringe)
	{
		closed.clear();
		return super.search(problem, fringe);
	}

}
