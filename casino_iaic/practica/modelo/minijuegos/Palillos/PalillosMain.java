package practica.modelo.minijuegos.Palillos;

import java.util.Iterator;


import java.util.List;
import java.util.Properties;



import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;

public class PalillosMain {
	
	static Palillos p = new Palillos();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		palillosAStarDemo(); 
		palillosDLSDemo();
		palillosUniformCostSearchDemo() ;
		palillosAStarManhattanDemo(); 
		palillosIDLSDemo(); 
		palillosGreedyBestFirstDemo();
		palillosGreedyBestFirstManhattanDemo();
		palillosSimulatedAnnealingDemo() ; 
		PalillosDFS();
		PalillosHillClimbing();


	}
	
	private static void palillosDLSDemo() {

		System.out.println("\npalillos recursive DLS -->");
		try {
			Problem problem = new Problem(p, new Sucesores(), new Objetivo(),new Coste());
			Search search = new DepthLimitedSearch(9);
			SearchAgent agent = new SearchAgent(problem, search);
			
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void palillosIDLSDemo() {
		
		System.out.println("\npalillos Iterative DLS -->");
		try {
			Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Coste());
			Search search = new IterativeDeepeningSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


    private static void palillosUniformCostSearchDemo() {
    	
       	System.out.println("\npalillos Uniform Cost Search -->");
		try {
			Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Coste());
			Search search = new UniformCostSearch(new TreeSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	private static void palillosGreedyBestFirstDemo() {
		System.out
				.println("\npalillos Greedy Best First Search (MisplacedTileHeursitic)-->");
		try {
			Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Heur’stica());
			Search search = new GreedyBestFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void palillosGreedyBestFirstManhattanDemo() {
		System.out
				.println("\npalillos Greedy Best First Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Coste(), new Heur’stica());
			Search search = new GreedyBestFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void palillosAStarDemo() {
		System.out.println("\npalillos A estrella ");
		try {
			Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	private static void palillosSimulatedAnnealingDemo() {
		System.out.println("\npalillos Simulated Annealing  Search -->");
		try {
			Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Heur’stica());
			SimulatedAnnealingSearch search = new SimulatedAnnealingSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			MostrarInstrucciones(agent.getInstrumentation());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void palillosAStarManhattanDemo() {
		System.out
				.println("\npalillos AStar Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Heur’stica());
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	 private static void PalillosHillClimbing() {
	      
	        System.out
			.println("\n PalillosHill Climbing-->");
			try {
				Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());	                
				HillClimbingSearch search = new HillClimbingSearch();
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				System.out.println("Search Outcome=" + search.getOutcome());
				System.out.println("Final State=\n" + search.getLastSearchState());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
	      
	      
	    }
	 
	   private static void PalillosDFS() {
		   System.out
			.println("\n PalillosDepthFirstSearch-->");
	         
	        try {
	            Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Coste()); 
	            Search search = new DepthFirstSearch(new GraphSearch());
	            SearchAgent agent = new SearchAgent(problem, search);
	            MostrarAcciones(agent.getActions());
	            MostrarInstrucciones(agent.getInstrumentation());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	    }

		private static void MostrarAcciones( List acciones){
			for (int i = 0; i < acciones.size(); i++) {
				String action = (String) acciones.get(i);
				System.out.println(action);
			}
		
		}
	
	
		private static void MostrarInstrucciones(Properties properties ){
			Iterator keys = properties.keySet().iterator();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				String property = properties.getProperty(key);
				System.out.println(key + " : " + property);
			}
		}
	
	
	

}
