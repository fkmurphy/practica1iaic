package practica.modelo.minijuegos.banderaHolandesa;

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
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;


public class banderaHolandesaMain {
	static banderaHolandesa b = new banderaHolandesa();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BHAStarDemo(); 
		BHDLSDemo();
		//BHUniformCostSearchDemo() ;
		BHAStarManhattanDemo(); 
		BHIDLSDemo(); 
		BHGreedyBestFirstDemo();
		BHGreedyBestFirstManhattanDemo();
		BHSimulatedAnnealingDemo() ; 
		BHHillClimbing();
	}
	
	private static void BHDLSDemo() {

		System.out.println("\nBH recursive DLS -->");
		try {
			Problem problem = new Problem(b, new Sucesores(), new Objetivo(),new Coste());
			Search search = new DepthLimitedSearch(9);
			SearchAgent agent = new SearchAgent(problem, search);
			
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void BHIDLSDemo() {
		
		System.out.println("\nBH Iterative IDLS -->");
		try {
			Problem problem = new Problem(b,new Sucesores(),new Objetivo(),new Coste());
			Search search = new IterativeDeepeningSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


    private static void BHUniformCostSearchDemo() {
    	
       	System.out.println("\nBH Uniform Cost Search -->");
		try {
			Problem problem = new Problem(b,new Sucesores(),new Objetivo(),new Coste());
			Search search = new UniformCostSearch(new TreeSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	private static void BHGreedyBestFirstDemo() {
		System.out
				.println("\nBH Greedy Best First Search (MisplacedTileHeursitic)-->");
		try {
			Problem problem = new Problem(b,new Sucesores(),new Objetivo(),new Heuristica());
			Search search = new GreedyBestFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void BHGreedyBestFirstManhattanDemo() {
		System.out
				.println("\nBH Greedy Best First Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(b,new Sucesores(),new Objetivo(),new Coste(),new Heuristica());
			Search search = new GreedyBestFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void BHAStarDemo() {
		System.out.println("\nBH A estrella ");
		try {
			Problem problem = new Problem(b,new Sucesores(),new Objetivo(),new Coste(),new Heuristica());
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	private static void BHSimulatedAnnealingDemo() {
		System.out.println("\nBH Simulated Annealing  Search -->");
		try {
			Problem problem = new Problem(b,new Sucesores(),new Objetivo(),new Heuristica());
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

	private static void BHAStarManhattanDemo() {
		System.out
				.println("\nBH AStar Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(b,new Sucesores(),new Objetivo(),new Heuristica());
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	 private static void BHHillClimbing() {
	      
	        System.out
			.println("\n BHHill Climbing-->");
			try {
				Problem problem = new Problem(b,new Sucesores(),new Objetivo(),new Coste(),new Heuristica());	                
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
