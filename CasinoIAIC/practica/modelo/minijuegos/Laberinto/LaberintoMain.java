package practica.modelo.minijuegos.Laberinto;


import java.util.List;
import java.util.Iterator;
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

public class LaberintoMain {
	
	static Laberinto p = new Laberinto();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LaberintoAStarDemo(); 
		LaberintoDLSDemo();
		LaberintoUniformCostSearchDemo() ;
		LaberintoAStarManhattanDemo(); 
		LaberintoIDLSDemo(); 
		LaberintoGreedyBestFirstDemo();
		LaberintoGreedyBestFirstManhattanDemo();
		LaberintoSimulatedAnnealingDemo() ; 
		LaberintoHillClimbing();
		LaberintoDFS();

	}
	
	private static void LaberintoDLSDemo() {

		System.out.println("\nLaberinto recursive DLS -->");
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
	

	private static void LaberintoIDLSDemo() {
		
		System.out.println("\nLaberinto Iterative DLS -->");
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


    private static void LaberintoUniformCostSearchDemo() {
    	
       	System.out.println("\nLaberinto Uniform Cost Search -->");
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

	private static void LaberintoGreedyBestFirstDemo() {
		System.out
				.println("\nLaberinto Greedy Best First Search (MisplacedTileHeursitic)-->");
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

	private static void LaberintoGreedyBestFirstManhattanDemo() {
		System.out
				.println("\nLaberinto Greedy Best First Search (ManhattanHeursitic)-->");
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

	private static void LaberintoAStarDemo() {
		System.out.println("\nLaberinto A estrella ");
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

	private static void LaberintoSimulatedAnnealingDemo() {
		System.out.println("\nLaberinto Simulated Annealing  Search -->");
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

	private static void LaberintoAStarManhattanDemo() {
		System.out
				.println("\nLaberinto AStar Search (ManhattanHeursitic)-->");
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
	
	 private static void LaberintoHillClimbing() {
	      
	        System.out
			.println("\nLaberinto Hill Climbing-->");
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
	 
	  private static void LaberintoDFS() {
		   System.out
			.println("\nLaberinto DepthFirstSearch-->");
	         
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
