package practica.modelo.minijuegos.Puzzle;

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

public class PuzzleMain {
	
	static Puzzle p = new Puzzle();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PuzzleAStarDemo(); 
		PuzzleDLSDemo();
		PuzzleUniformCostSearchDemo() ;
		PuzzleAStarManhattanDemo(); 
		PuzzleIDLSDemo(); 
		PuzzleGreedyBestFirstDemo();
		PuzzleGreedyBestFirstManhattanDemo();
		PuzzleSimulatedAnnealingDemo() ; 
		PuzzleHillClimbing();
	//	PuzzleDFS();Aqui no va esta estrategia pero tenemos 9..asi que no hay problema

	}
	
	private static void PuzzleDLSDemo() {

		System.out.println("\nPuzzle recursive DLS -->");
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
	

	private static void PuzzleIDLSDemo() {
		
		System.out.println("\nPuzzle Iterative DLS -->");
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


    private static void PuzzleUniformCostSearchDemo() {
    	
       	System.out.println("\nPuzzle Uniform Cost Search -->");
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

	private static void PuzzleGreedyBestFirstDemo() {
		System.out
				.println("\nPuzzle Greedy Best First Search (MisplacedTileHeursitic)-->");
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

	private static void PuzzleGreedyBestFirstManhattanDemo() {
		System.out
				.println("\nPuzzle Greedy Best First Search (ManhattanHeursitic)-->");
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

	private static void PuzzleAStarDemo() {
		System.out.println("\nPuzzle A estrella ");
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

	private static void PuzzleSimulatedAnnealingDemo() {
		System.out.println("\nPuzzle Simulated Annealing  Search -->");
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

	private static void PuzzleAStarManhattanDemo() {
		System.out
				.println("\nPuzzle AStar Search (ManhattanHeursitic)-->");
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
	
	 private static void PuzzleHillClimbing() {
	      
	        System.out
			.println("\n PuzzleHill Climbing-->");
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
	 
	/*   private static void PuzzleDFS() {
		   System.out
			.println("\n PuzzleDepthFirstSearch-->");
	         
	        try {
	            Problem problem = new Problem(p,new Sucesores(),new Objetivo(),new Coste()); 
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
