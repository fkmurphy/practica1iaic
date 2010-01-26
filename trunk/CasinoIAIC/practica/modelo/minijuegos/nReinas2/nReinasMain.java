package practica.modelo.minijuegos.nReinas2;

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
import aima.search.informed.SimulatedAnnealingSearch;
import aima.search.nqueens.NQueensBoard;
import aima.search.nqueens.NQueensGoalTest;
import aima.search.nqueens.NQueensSuccessorFunction;
import aima.search.nqueens.QueensToBePlacedHeuristic;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;

public class nReinasMain {

	/**
	 * @param args
	 */
	
	static NQueensBoard t = new  NQueensBoard(4);
	public static void main(String[] args) {
		NReinasAStarDemo(); 
		NReinasDLSDemo();
		NReinasUniformCostSearchDemo() ;
		NReinasAStarManhattanDemo(); 
		NReinasIDLSDemo(); 
		NReinasGreedyBestFirstDemo();
		NReinasGreedyBestFirstManhattanDemo();
		NReinasSimulatedAnnealingDemo() ; 
	}
		
		private static void NReinasDLSDemo() {

			System.out.println("\nReinas recursive DLS -->");
			try {
				Problem problem = new Problem(t, new NQueensSuccessorFunction(), new NQueensGoalTest(),new Coste());
				Search search = new DepthLimitedSearch(9);
				SearchAgent agent = new SearchAgent(problem, search);
				
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		private static void NReinasIDLSDemo() {
			
			System.out.println("\nReinas Iterative DLS -->");
			try {
				Problem problem = new Problem(t,new NQueensSuccessorFunction(),new NQueensGoalTest(),new Coste());
				Search search = new IterativeDeepeningSearch();
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}


	    private static void NReinasUniformCostSearchDemo() {
	    	
	       	System.out.println("\nReinas Uniform Cost Search -->");
			try {
				Problem problem = new Problem(t,new NQueensSuccessorFunction(),new NQueensGoalTest(),new Coste());
				Search search = new UniformCostSearch(new TreeSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

		private static void NReinasGreedyBestFirstDemo() {
			System.out
					.println("\nReinas Greedy Best First Search (MisplacedTileHeursitic)-->");
			try {
				Problem problem = new Problem(t,new NQueensSuccessorFunction(),new NQueensGoalTest(),new Coste(), new QueensToBePlacedHeuristic());
				Search search = new GreedyBestFirstSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		private static void NReinasGreedyBestFirstManhattanDemo() {
			System.out
					.println("\nReinas Greedy Best First Search (ManhattanHeursitic)-->");
			try {
				Problem problem = new Problem(t,new NQueensSuccessorFunction(),new NQueensGoalTest(),new Coste(),new QueensToBePlacedHeuristic());
				Search search = new GreedyBestFirstSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		private static void NReinasAStarDemo() {
			System.out.println("\nReinas A estrella ");
			try {
				Problem problem = new Problem(t,new NQueensSuccessorFunction(),new NQueensGoalTest(),new Coste(), new QueensToBePlacedHeuristic());
				Search search = new AStarSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}

		private static void NReinasSimulatedAnnealingDemo() {
			System.out.println("\nReinas Simulated Annealing  Search -->");
			try {
				Problem problem = new Problem(t,new NQueensSuccessorFunction(),new NQueensGoalTest(),new Coste(),new QueensToBePlacedHeuristic());
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

		private static void NReinasAStarManhattanDemo() {
			System.out
					.println("\nReinas AStar Search (ManhattanHeursitic)-->");
			try {
				Problem problem = new Problem(t,new NQueensSuccessorFunction(),new NQueensGoalTest(),new Coste(),new QueensToBePlacedHeuristic());
				Search search = new AStarSearch(new GraphSearch());
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
