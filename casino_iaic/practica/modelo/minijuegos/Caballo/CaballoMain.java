package practica.modelo.minijuegos.Caballo;

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
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;

public class CaballoMain {
	
	static Caballo c = new Caballo();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//CaballoDLSDemo();
		CaballoAStarDemo();
		CaballoUniformCostSearchDemo() ;
		CaballoAStarManhattanDemo();
		CaballoIDLSDemo();
		CaballoGreedyBestFirstDemo();
		CaballoGreedyBestFirstManhattanDemo();
		CaballoSimulatedAnnealingDemo() ;

	}
	
	private static void CaballoDLSDemo() {

		System.out.println("\nCaballo recursive DLS -->");
		try {
			Problem problem = new Problem(c, new Sucesores(), new Objetivo(),new Coste());
			Search search = new DepthLimitedSearch(9);
			SearchAgent agent = new SearchAgent(problem, search);
			
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
				private static void CaballoIDLSDemo() {
		//PROFUNDIDAD ITERATIVA			
					System.out.println("\nCaballo Iterative IDLS -->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Coste());
						Search search = new IterativeDeepeningSearch();
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}


			    private static void CaballoUniformCostSearchDemo() {
		//PROFUNDIDAD COSTE UNIFORME	    	
			       	System.out.println("\nCaballo Uniform Cost Search -->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Coste());
						Search search = new UniformCostSearch(new TreeSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}
			    }

				private static void CaballoGreedyBestFirstDemo() {
		//PRIMERO EL MEJOR AGRESIVA CON EL COSTE
					System.out
							.println("\nCaballo Greedy Best First Search (MisplacedTileHeursitic)-->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Heur’stica());
						Search search = new GreedyBestFirstSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				private static void CaballoGreedyBestFirstManhattanDemo() {
		//PRIMERO EL MEJOR AGRESIVA CON LA HEURISTICA
					System.out
							.println("\nCaballo Greedy Best First Search (ManhattanHeursitic)-->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());
						Search search = new GreedyBestFirstSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				private static void CaballoAStarDemo() {
		//A ESTRELLA
					System.out.println("\nCaballo A estrella ");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());
						Search search = new AStarSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}

				private static void CaballoSimulatedAnnealingDemo() {
		//RECOCIDO SIMULADO
					System.out.println("\nCaballo Simulated Annealing  Search -->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Heur’stica());
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

				private static void CaballoAStarManhattanDemo() {
		//RECOCIDO SIMULADO
					System.out
							.println("\nCaballo AStar Search (ManhattanHeursitic)-->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Heur’stica());
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
