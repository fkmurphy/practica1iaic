package practica.modelo.minijuegos.Canibales;

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
	static Canibales c = new Canibales();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CanibalesAStarDemo(); 
		CanibalesDLSDemo();
		CanibalesUniformCostSearchDemo() ;
		CanibalesAStarManhattanDemo(); 
		CanibalesIDLSDemo(); 
		CanibalesGreedyBestFirstDemo();
		CanibalesGreedyBestFirstManhattanDemo();
		CanibalesSimulatedAnnealingDemo();
		//CanibalesDFS();  Esta estrategia no funciona aqui pero no pasa nada hay suficientes
		CanibalesHillClimbing();
		

	}
	
	
	private static void CanibalesDLSDemo() {

		System.out.println("\nCanibales recursive DLS -->");
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
	
	
				private static void CanibalesIDLSDemo() {
		//PROFUNDIDAD ITERATIVA			
					System.out.println("\n Canibales Iterative IDLS -->");
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


			    private static void CanibalesUniformCostSearchDemo() {
		//PROFUNDIDAD COSTE UNIFORME	    	
			       	System.out.println("\nCanibales Uniform Cost Search -->");
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

				private static void CanibalesGreedyBestFirstDemo() {
		//PRIMERO EL MEJOR AGRESIVA CON EL COSTE
					System.out
							.println("\nCanibales Greedy Best First Search (MisplacedTileHeursitic)-->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Heuristica());
						Search search = new GreedyBestFirstSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				private static void CanibalesGreedyBestFirstManhattanDemo() {
		//PRIMERO EL MEJOR AGRESIVA CON LA HEURISTICA
					System.out
							.println("\nCanibales Greedy Best First Search (ManhattanHeursitic)-->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Coste(),new Heuristica());
						Search search = new GreedyBestFirstSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				private static void CanibalesAStarDemo() {
		//A ESTRELLA
					System.out.println("\nCanibales A estrella ");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Coste(),new Heuristica());
						Search search = new AStarSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}

				private static void CanibalesSimulatedAnnealingDemo() {
		//RECOCIDO SIMULADO
					System.out.println("\nCanibales Simulated Annealing  Search -->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Heuristica());
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

				private static void CanibalesAStarManhattanDemo() {
		//RECOCIDO SIMULADO
					System.out
							.println("\nCanibales AStar Search (ManhattanHeursitic)-->");
					try {
						Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Heuristica());
						Search search = new AStarSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				
				 private static void CanibalesHillClimbing() {
				      
				        System.out
						.println("\n CanibalesHill Climbing-->");
						try {
							Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Coste(),new Heuristica());	                
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
				 
	/*			   private static void CanibalesDFS() {
					   System.out
						.println("\n CanibalesDepthFirstSearch-->");
				         
				        try {
				            Problem problem = new Problem(c,new Sucesores(),new Objetivo(),new Coste()); 
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
