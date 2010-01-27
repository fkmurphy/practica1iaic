package practica.modelo.minijuegos.Mochila;

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

public class MochilaMain {
	
	static Mochila p = new Mochila();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MochilaAStarDemo(); 
		//MochilaDLSDemo();
		//MochilaUniformCostSearchDemo() ;
		MochilaAStarManhattanDemo(); 
		MochilaIDLSDemo(); 
		MochilaGreedyBestFirstDemo();
		MochilaGreedyBestFirstManhattanDemo();
		MochilaSimulatedAnnealingDemo() ; 
		MochilaHillClimbing();
		MochilaDFS();

	}
	
	private static void MochilaDLSDemo() {

		System.out.println("\nMochila recursive DLS -->");
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
	

	private static void MochilaIDLSDemo() {
		
		System.out.println("\nMochila Iterative IDLS -->");
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


    private static void MochilaUniformCostSearchDemo() {
    	
       	System.out.println("\nMochila Uniform Cost Search -->");
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

	private static void MochilaGreedyBestFirstDemo() {
		System.out
				.println("\nMochila Greedy Best First Search (MisplacedTileHeursitic)-->");
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

	private static void MochilaGreedyBestFirstManhattanDemo() {
		System.out
				.println("\nMochila Greedy Best First Search (ManhattanHeursitic)-->");
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

	private static void MochilaAStarDemo() {
		System.out.println("\nMochila A estrella ");
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

	private static void MochilaSimulatedAnnealingDemo() {
		System.out.println("\nMochila Simulated Annealing  Search -->");
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

	private static void MochilaAStarManhattanDemo() {
		System.out
				.println("\nMochila AStar Search (ManhattanHeursitic)-->");
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
	
	 private static void MochilaHillClimbing() {
	      
	        System.out
			.println("\n MochilaHill Climbing-->");
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
	 
	   private static void MochilaDFS() {
		   System.out
			.println("\n MochilaDepthFirstSearch-->");
	         
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
