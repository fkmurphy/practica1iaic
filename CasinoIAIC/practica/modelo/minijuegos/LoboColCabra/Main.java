package practica.modelo.minijuegos.LoboColCabra;

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

public class Main {
	
	static LoboColCabra lobo = new LoboColCabra();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoboAStarDemo(); 
		LoboDLSDemo();
		LoboUniformCostSearchDemo() ;
		LoboAStarManhattanDemo(); 
		LoboIDLSDemo(); 
		LoboGreedyBestFirstDemo();
		LoboGreedyBestFirstManhattanDemo();
		LoboSimulatedAnnealingDemo(); 
		//LoboDFS(); Esta no va pero no hay problemas tenemos 9 estrategias
		LoboHillClimbing();

	}

		
		
		private static void LoboDLSDemo() {

			System.out.println("\nLoboColCabra recursive DLS -->");
			try {
				Problem problem = new Problem(lobo, new Sucesores(), new Objetivo(),new Coste());
				Search search = new DepthLimitedSearch(9);
				SearchAgent agent = new SearchAgent(problem, search);
				
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		private static void LoboIDLSDemo() {
			
			System.out.println("\nLoboColCabra Iterative DLS -->");
			try {
				Problem problem = new Problem(lobo,new Sucesores(),new Objetivo(),new Coste());
				Search search = new IterativeDeepeningSearch();
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}


	    private static void LoboUniformCostSearchDemo() {
	    	
	       	System.out.println("\nLoboColCabra Uniform Cost Search -->");
			try {
				Problem problem = new Problem(lobo,new Sucesores(),new Objetivo(),new Coste());
				Search search = new UniformCostSearch(new TreeSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

		private static void LoboGreedyBestFirstDemo() {
			System.out
					.println("\nLoboColCabra Greedy Best First Search (MisplacedTileHeursitic)-->");
			try {
				Problem problem = new Problem(lobo,new Sucesores(),new Objetivo(),new Heuristica());
				Search search = new GreedyBestFirstSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		private static void LoboGreedyBestFirstManhattanDemo() {
			System.out
					.println("\nLoboColCabra Greedy Best First Search (ManhattanHeursitic)-->");
			try {
				Problem problem = new Problem(lobo,new Sucesores(),new Objetivo(),new Coste(),new Heuristica());
				Search search = new GreedyBestFirstSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		private static void LoboAStarDemo() {
			System.out.println("\nLoboColCabra A estrella ");
			try {
				Problem problem = new Problem(lobo,new Sucesores(),new Objetivo(),new Coste(),new Heuristica());
				Search search = new AStarSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}

		private static void LoboSimulatedAnnealingDemo() {
			System.out.println("\nLoboColCabra Simulated Annealing  Search -->");
			try {
				Problem problem = new Problem(lobo,new Sucesores(),new Objetivo(),new Heuristica());
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

		private static void LoboAStarManhattanDemo() {
			System.out
					.println("\nLoboColCabra AStar Search (ManhattanHeursitic)-->");
			try {
				Problem problem = new Problem(lobo,new Sucesores(),new Objetivo(),new Heuristica());
				Search search = new AStarSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				MostrarAcciones(agent.getActions());
				MostrarInstrucciones(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		 private static void LoboHillClimbing() {
		      
		        System.out
				.println("\n LoboColCabraHill Climbing-->");
				try {
					Problem problem = new Problem(lobo,new Sucesores(),new Objetivo(),new Coste(),new Heuristica());	                
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
		 
	/*	   private static void LoboDFS() {
			   System.out
				.println("\n LoboColCabraDepthFirstSearch-->");
		         
		        try {
		            Problem problem = new Problem(lobo,new Sucesores(),new Objetivo(),new Coste()); 
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

