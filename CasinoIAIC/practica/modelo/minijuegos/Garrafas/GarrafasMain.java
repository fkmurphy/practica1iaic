package practica.modelo.minijuegos.Garrafas;

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

public class GarrafasMain {

	 static Garrafas g = new Garrafas();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		garrafasAStarDemo(); 
		garrafasDLSDemo();
		garrafasUniformCostSearchDemo() ;
		garrafasAStarManhattanDemo(); 
		garrafasIDLSDemo(); 
		garrafasGreedyBestFirstDemo();
		garrafasGreedyBestFirstManhattanDemo();
		garrafasSimulatedAnnealingDemo();
		garrafasDFS();
		garrafasHillClimbing();
		

	}
	
	private static void garrafasDLSDemo() {

		System.out.println("\ngarrafas recursive DLS -->");
		try {
			Problem problem = new Problem(g, new Sucesores(), new Objetivo(),new Coste());
			Search search = new DepthLimitedSearch(9);
			SearchAgent agent = new SearchAgent(problem, search);
			
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
				private static void garrafasIDLSDemo() {
		//PROFUNDIDAD ITERATIVA			
					System.out.println("\n Garrafas Iterative IDLS -->");
					try {
						Problem problem = new Problem(g,new Sucesores(),new Objetivo(),new Coste());
						Search search = new IterativeDeepeningSearch();
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}


			    private static void garrafasUniformCostSearchDemo() {
		//PROFUNDIDAD COSTE UNIFORME	    	
			       	System.out.println("\nGarrafas Uniform Cost Search -->");
					try {
						Problem problem = new Problem(g,new Sucesores(),new Objetivo(),new Coste());
						Search search = new UniformCostSearch(new TreeSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}
			    }

				private static void garrafasGreedyBestFirstDemo() {
		//PRIMERO EL MEJOR AGRESIVA CON EL COSTE
					System.out
							.println("\nGarrafas Greedy Best First Search (MisplacedTileHeursitic)-->");
					try {
						Problem problem = new Problem(g,new Sucesores(),new Objetivo(),new Heur’stica());
						Search search = new GreedyBestFirstSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				private static void garrafasGreedyBestFirstManhattanDemo() {
		//PRIMERO EL MEJOR AGRESIVA CON LA HEURISTICA
					System.out
							.println("\nGarrafas Greedy Best First Search (ManhattanHeursitic)-->");
					try {
						Problem problem = new Problem(g,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());
						Search search = new GreedyBestFirstSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				private static void garrafasAStarDemo() {
		//A ESTRELLA
					System.out.println("\nGarrafas A estrella ");
					try {
						Problem problem = new Problem(g,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());
						Search search = new AStarSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}

				private static void garrafasSimulatedAnnealingDemo() {
		//RECOCIDO SIMULADO
					System.out.println("\nGarrafas Simulated Annealing  Search -->");
					try {
						Problem problem = new Problem(g,new Sucesores(),new Objetivo(),new Heur’stica());
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

				private static void garrafasAStarManhattanDemo() {
		//RECOCIDO SIMULADO
					System.out
							.println("\nGarrafas AStar Search (ManhattanHeursitic)-->");
					try {
						Problem problem = new Problem(g,new Sucesores(),new Objetivo(),new Heur’stica());
						Search search = new AStarSearch(new GraphSearch());
						SearchAgent agent = new SearchAgent(problem, search);
						MostrarAcciones(agent.getActions());
						MostrarInstrucciones(agent.getInstrumentation());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				
				 private static void garrafasHillClimbing() {
				      
				        System.out
						.println("\n garrafasHill Climbing-->");
						try {
							Problem problem = new Problem(g,new Sucesores(),new Objetivo(),new Coste(),new Heur’stica());	                
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
				 
				   private static void garrafasDFS() {
					   System.out
						.println("\n garrafasDepthFirstSearch-->");
				         
				        try {
				            Problem problem = new Problem(g,new Sucesores(),new Objetivo(),new Coste()); 
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
