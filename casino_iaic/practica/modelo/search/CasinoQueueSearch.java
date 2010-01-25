package practica.modelo.search;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Node;
import aima.search.framework.NodeExpander;
import aima.search.framework.NodeStore;
import aima.search.framework.Problem;
import aima.search.framework.SearchUtils;

public abstract class CasinoQueueSearch extends NodeExpander{
	
	
	private static String QUEUE_SIZE = "queueSize";
	private static String MAX_QUEUE_SIZE = "maxQueueSize";
	private static String PATH_COST = "pathCost";

	public CasinoQueueSearch()
	{
		
	}
	
		
	public List search (Problem problem, NodeStore fringe)
	{
		clearInstrumentation();
		fringe.add(new Node(problem.getInitialState()));
		Node node = fringe.remove();
		addExpandedNodesToFringe(fringe, node, problem);
		setQueueSize(fringe.size());
		do
		{
			if(fringe.isEmpty())
				break;
			node = fringe.remove();
			if(node != null)
			{
				setQueueSize(fringe.size());
				if(problem.isGoalState(node.getState()))
				{
					setPathCost(Double.valueOf(node.getPathCost()));
					return SearchUtils.actionsFromNodes(node.getPathFromRoot());
				}
				addExpandedNodesToFringe(fringe, node, problem);
				setQueueSize(fringe.size());
			}
		} while(true);
		return new ArrayList();

	}
	
	public void clearInstrumentation()
	{
		super.clearInstrumentation();
		metrics.set(QUEUE_SIZE, 0);
		metrics.set(MAX_QUEUE_SIZE, 0);
		metrics.set(PATH_COST, 0);
	}

	public int getQueueSize()
	{
		return metrics.getInt("queueSize");
	}

	public void setQueueSize(int queueSize)
	{
		metrics.set(QUEUE_SIZE, queueSize);
		int maxQSize = metrics.getInt(MAX_QUEUE_SIZE);
		if(queueSize > maxQSize)
			metrics.set(MAX_QUEUE_SIZE, queueSize);
	}

	public int getMaxQueueSize()
	{
		return metrics.getInt(MAX_QUEUE_SIZE);
	}

	public double getPathCost()
	{
		return metrics.getDouble(PATH_COST);
	}

	public void setPathCost(Double pathCost)
	{
		metrics.set(PATH_COST, pathCost.doubleValue());
	}

	public abstract void addExpandedNodesToFringe(NodeStore nodestore, Node node, Problem problem);

}
