package practica.modelo.search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import practica.modelo.casino.Casino;

import aima.search.framework.Node;
import aima.search.framework.NodeStore;

public class CasinoPriorityNodeStore implements NodeStore{

	
	PriorityQueue<Node> queue;
    Set<Integer> closed = new HashSet<Integer>();
    
	public CasinoPriorityNodeStore(Comparator<Node> comparator) 
	{
		queue = new PriorityQueue<Node>(5, comparator);
	}
	
	@Override
	public void add(Node anItem) {
	
		 Casino aux= (Casino) ((Node)anItem).getState();
		 if (!closed.contains(aux.getZonaActual().dameNombreZona()))
				queue.add(anItem);
	}

	@Override
	public void add(List<Node> nodes) {
		for (Object n : nodes) {
	          Casino aux= (Casino) ((Node)n).getState();
	          if (!closed.contains(aux.getZonaActual().dameNombreZona()))
				queue.add((Node) n);
		}
	}



	@Override
	public Node remove() {

        Node n = null;

        boolean resultado = false;



        while (!resultado &&
                !queue.isEmpty()) {

            n = queue.remove();

            Casino m = (Casino) n.getState();
            resultado = m.jugarApuesta();
            if (!resultado)
              closed.add(m.getZonaActual().dameNombreZona());


        }



           if (queue.isEmpty() && !resultado)
                n=null;

        removeAll();
        

        return n;
	}
	 void removeAll() {
	       while (!queue.isEmpty())
	           queue.remove();
	    }


	 public boolean isEmpty() {

			return queue.isEmpty();
		}

		public int size() {
			return queue.size();
		}

		@Override
		public String toString() {
			return queue.toString();
		}


}
