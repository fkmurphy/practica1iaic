package practica.modelo.minijuegos.Mono;


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

import java.util.Iterator;
import java.util.Properties;

import java.util.List;








public class MonoMain {
	static Mono m = new Mono();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		monoAStarDemo(); 
		monoDLSDemo();
		monoUniformCostSearchDemo() ;
		monoAStarManhattanDemo(); 
		monoIDLSDemo(); 
		monoGreedyBestFirstDemo();
		monoGreedyBestFirstManhattanDemo();
		monoSimulatedAnnealingDemo(); 
		//monoDFS(); Aqui no va esta estrategia pero tenemos 9..no hay problema
		monoHillClimbing();

	}
	
	private static void monoDLSDemo() {

		System.out.println("\nmono recursive DLS -->");
		try {
			Problem problem = new Problem(m, new Sucesores(), new Objetivo(),new Coste());
			Search search = new DepthLimitedSearch(9);
			SearchAgent agent = new SearchAgent(problem, search);
			
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void monoIDLSDemo() {
		
		System.out.println("\nmono Iterative DLS -->");
		try {
			Problem problem = new Problem(m,new Sucesores(),new Objetivo(),new Coste());
			Search search = new IterativeDeepeningSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


    private static void monoUniformCostSearchDemo() {
    	
       	System.out.println("\nmono Uniform Cost Search -->");
		try {
			Problem problem = new Problem(m,new Sucesores(),new Objetivo(),new Coste());
			Search search = new UniformCostSearch(new TreeSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	private static void monoGreedyBestFirstDemo() {
		System.out
				.println("\nmono Greedy Best First Search (MisplacedTileHeursitic)-->");
		try {
			Problem problem = new Problem(m,new Sucesores(),new Objetivo(),new Heur’stica());
			Search search = new GreedyBestFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void monoGreedyBestFirstManhattanDemo() {
		System.out
				.println("\nmono Greedy Best First Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(m,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());
			Search search = new GreedyBestFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void monoAStarDemo() {
		System.out.println("\nMono A estrella ");
		try {
			Problem problem = new Problem(m,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	private static void monoSimulatedAnnealingDemo() {
		System.out.println("\nmono Simulated Annealing  Search -->");
		try {
			Problem problem = new Problem(m,new Sucesores(),new Objetivo(),new Heur’stica());
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

	private static void monoAStarManhattanDemo() {
		System.out
				.println("\nmono AStar Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(m,new Sucesores(),new Objetivo(),new Heur’stica());
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	 private static void monoHillClimbing() {
	      
	        System.out
			.println("\n MonoHill Climbing-->");
			try {
				Problem problem = new Problem(m,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());	                
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
	 
	 /*  private static void monoDFS() {
		   System.out
			.println("\n MonoDepthFirstSearch-->");
	         
	        try {
	            Problem problem = new Problem(m,new Sucesores(),new Objetivo(),new Coste()); 
	            Search search = new DepthFirstSearch(new GraphSearch());
	            SearchAgent agent = new SearchAgent(problem, search);
	            MostrarAcciones(agent.getActions());
	            MostrarInstrucciones(agent.getInstrumentation());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	    }*/

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
