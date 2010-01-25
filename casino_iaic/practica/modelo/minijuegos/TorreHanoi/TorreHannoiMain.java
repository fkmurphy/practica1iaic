package practica.modelo.minijuegos.TorreHanoi;

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

public class TorreHannoiMain {
	
	static TorreHannoi t = new TorreHannoi();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//HannoiAStarDemo(); 
		HannoiDLSDemo();
		//HannoiUniformCostSearchDemo() ;
		HannoiAStarManhattanDemo(); 
		HannoiIDLSDemo(); 
		//HannoiGreedyBestFirstDemo();
		//HannoiGreedyBestFirstManhattanDemo();
		HannoiSimulatedAnnealingDemo(); 
		//HannoiDFS(); 
		HannoiHillClimbing();
	}
		
		private static void HannoiDLSDemo() {

			System.out.println("\nTorreHannoi recursive DLS -->");
			try {
				Problem problem = new Problem(t, new Sucesores(), new Objetivo(),new Coste());
				Search search = new DepthLimitedSearch(9);
				SearchAgent agent = new SearchAgent(problem, search);
				
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		private static void HannoiIDLSDemo() {
			
			System.out.println("\nTorreHannoi Iterative IDLS -->");
			try {
				Problem problem = new Problem(t,new Sucesores(),new Objetivo(),new Coste());
				Search search = new IterativeDeepeningSearch();
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}


	    private static void HannoiUniformCostSearchDemo() {
	    	
	       	System.out.println("\nTorreHannoi Uniform Cost Search -->");
			try {
				Problem problem = new Problem(t,new Sucesores(),new Objetivo(),new Coste());
				Search search = new UniformCostSearch(new TreeSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

		private static void HannoiGreedyBestFirstDemo() {
			System.out
					.println("\nTorreHannoi Greedy Best First Search (MisplacedTileHeursitic)-->");
			try {
				Problem problem = new Problem(t,new Sucesores(),new Objetivo(),new Heur’stica());
				Search search = new GreedyBestFirstSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		private static void HannoiGreedyBestFirstManhattanDemo() {
			System.out
					.println("\nTorreHannoi Greedy Best First Search (ManhattanHeursitic)-->");
			try {
				Problem problem = new Problem(t,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());
				Search search = new GreedyBestFirstSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		private static void HannoiAStarDemo() {
			System.out.println("\nTorreHannoi A estrella ");
			try {
				Problem problem = new Problem(t,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());
				Search search = new AStarSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}

		private static void HannoiSimulatedAnnealingDemo() {
			System.out.println("\nTorreHannoi Simulated Annealing  Search -->");
			try {
				Problem problem = new Problem(t,new Sucesores(),new Objetivo(),new Heur’stica());
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

		private static void HannoiAStarManhattanDemo() {
			System.out
					.println("\nTorreHannoi AStar Search (ManhattanHeursitic)-->");
			try {
				Problem problem = new Problem(t,new Sucesores(),new Objetivo(),new Heur’stica());
				Search search = new AStarSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		
		 private static void HannoiHillClimbing() {
		      
		        System.out
				.println("\n TorreHannoiHill Climbing-->");
				try {
					Problem problem = new Problem(t,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());	                
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
		 
		   private static void HannoiDFS() {
			   System.out
				.println("\n TorreHannoiDepthFirstSearch-->");
		         
		        try {
		            Problem problem = new Problem(t,new Sucesores(),new Objetivo(),new Coste()); 
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
