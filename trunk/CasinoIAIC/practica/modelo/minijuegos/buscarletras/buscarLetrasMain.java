package practica.modelo.minijuegos.buscarletras;

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


public class buscarLetrasMain {
	static buscarLetras b = new buscarLetras();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BLAStarDemo(); 
		BLDLSDemo();
		//BLUniformCostSearchDemo() ;
		BLAStarManhattanDemo(); 
		//BLIDLSDemo(); 
		BLGreedyBestFirstDemo();
		BLGreedyBestFirstManhattanDemo();
		BLSimulatedAnnealingDemo(); 
		BLDFS(); 
		BLHillClimbing();

	}
	
	private static void BLDLSDemo() {

		System.out.println("\nBL recursive DLS -->");
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
	

	private static void BLIDLSDemo() {
		
		System.out.println("\nBL Iterative IDLS -->");
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


    private static void BLUniformCostSearchDemo() {
    	
       	System.out.println("\nBL Uniform Cost Search -->");
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

	private static void BLGreedyBestFirstDemo() {
		System.out
				.println("\nBL Greedy Best First Search (MisplacedTileHeursitic)-->");
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

	private static void BLGreedyBestFirstManhattanDemo() {
		System.out
				.println("\nBL Greedy Best First Search (ManhattanHeursitic)-->");
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

	private static void BLAStarDemo() {
		System.out.println("\nBL A estrella ");
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

	private static void BLSimulatedAnnealingDemo() {
		System.out.println("\nBL Simulated Annealing  Search -->");
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

	private static void BLAStarManhattanDemo() {
		System.out
				.println("\nBL AStar Search (ManhattanHeursitic)-->");
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
	
	 private static void BLHillClimbing() {
	      
	        System.out
			.println("\n BLHill Climbing-->");
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
	 
	   private static void BLDFS() {
		   System.out
			.println("\n BLDepthFirstSearch-->");
	         
	        try {
	            Problem problem = new Problem(b,new Sucesores(),new Objetivo(),new Coste()); 
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
