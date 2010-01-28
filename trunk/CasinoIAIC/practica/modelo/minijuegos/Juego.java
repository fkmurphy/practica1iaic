package practica.modelo.minijuegos;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import practica.modelo.casino.ResultadoPrueba;
import practica.modelo.minijuegos.Palillos.Coste;
import practica.modelo.minijuegos.Palillos.Heur’stica;
import practica.modelo.minijuegos.Palillos.Objetivo;
import practica.modelo.minijuegos.Palillos.Sucesores;

import aima.search.framework.*;

import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;

public abstract class Juego {
	
	String nombre;
	Object EstadoInicial;
	SuccessorFunction Sucesores;
	GoalTest TestObjetivo;
	StepCostFunction Coste;
	HeuristicFunction Heuristica;

	
	
		public Juego (String nombre, Object EstadoInicial, SuccessorFunction Sucesores, GoalTest TestObjetivo
				, StepCostFunction Coste, HeuristicFunction Heuristica){
			this.nombre=nombre;
	        this.EstadoInicial = EstadoInicial;
	        this.Sucesores = Sucesores;
	        this.TestObjetivo = TestObjetivo;
	        this.Coste = Coste;
	        this.Heuristica = Heuristica;
		}
	


		
		
	   	public ResultadoPrueba juega(int estrategia) {


	        String r=null;

	        Random random=new Random();
	        int ran=random.nextInt(7)+1;
	 
	        switch (estrategia) {
	            case 1:
	                r = AStar();
	                break;
	            case 2:
	                r = GreedyBestFirst();
	                break;
	            case 3:
	                r = DLS();
	                break;
	            case 4:
	                r = HillClimbing();
	                break;
	            case 5:
	                r = SimulatedAnnealing();
	                break;
	            case 6:
	                r = AStarManhattanDemo();
	                break;
	            case 7 :
	                r = IDLS();
	                break;
	            case 8 :
	                r = GreedyBestFirstManhattanDemo();
	                break;
	            case 9 :
	                r = GreedyBestFirst();
	                break;
	                
	                //

	        }
	        
	        
	        return new ResultadoPrueba(r,(!r.toString().contains("cutoff")&&!r.toString().contains("FAILURE")));

	    }
	   	public StringBuffer juegaTodos()
	   	{
	   		StringBuffer bufer = new StringBuffer();
	   		 bufer.append(AStar());
//	   		 bufer.append(GreedyBestFirst());
//	   		 bufer.append(DLS());
//	   		 bufer.append(HillClimbing());
//	   		 bufer.append(SimulatedAnnealing());
//	   		 bufer.append(UniformCost());
//	   		 bufer.append(IDLS());
//	   		 bufer.append(BFS());
//	   		 bufer.append(DFS());
	   		
	   	 return bufer;
	   	 
	   		
	   	}
	   	
	   	
	   	private String AStarManhattanDemo() {
	   	 String resultado = nombre+" :\n AStar Search (ManhattanHeursitic)-->\n";
	   		
			try {
				Problem problem = new Problem(EstadoInicial,Sucesores, TestObjetivo,Heuristica);
				Search search = new AStarSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				resultado += printActions(agent.getActions());
	            resultado+= printInstrumentation(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return resultado;

		}
	   	private  String GreedyBestFirstManhattanDemo() {
			
			 String resultado = nombre+" :\n Greedy Best First Search (ManhattanHeursitic)-->\n";
			try {
				Problem problem = new Problem(EstadoInicial,Sucesores,
	                    TestObjetivo,Coste, Heuristica);
				Search search = new GreedyBestFirstSearch(new GraphSearch());
				SearchAgent agent = new SearchAgent(problem, search);
				resultado += printActions(agent.getActions());
	            resultado+= printInstrumentation(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return resultado;
		}


	    private String DLS() {

	        String resultado = nombre+" :\n recursive DLS -->\n";
	        try {
	            Problem problem = new Problem(EstadoInicial,Sucesores,
	                    TestObjetivo,Coste);
	            Search search = new DepthLimitedSearch(9);
	            SearchAgent agent = new SearchAgent(problem, search);
	            resultado += printActions(agent.getActions());
	            resultado+= printInstrumentation(agent.getInstrumentation());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resultado;
	    }

	      private String BFS() {

	        String resultado = nombre+" :\n BreadthFirstSearch -->\n";
	        try {
	            Problem problem = new Problem(EstadoInicial,Sucesores,
	                    TestObjetivo,Coste);
	            Search search = new BreadthFirstSearch(new GraphSearch());
	            SearchAgent agent = new SearchAgent(problem, search);
	            resultado += printActions(agent.getActions());
	            resultado+= printInstrumentation(agent.getInstrumentation());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resultado;
	    }

	    private String DFS() {

	        String resultado = nombre+" :\n DepthFirstSearch -->\n";
	        try {
	            Problem problem = new Problem(EstadoInicial,Sucesores,
	                    TestObjetivo,Coste);
	            Search search = new DepthFirstSearch(new GraphSearch());
	            SearchAgent agent = new SearchAgent(problem, search);
	            resultado += printActions(agent.getActions());
	            resultado+= printInstrumentation(agent.getInstrumentation());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resultado;
	    }

	    private String HillClimbing() {
	        String resultado = nombre+"\n Hill Climbing -->\n";
			try {
				Problem problem = new Problem(EstadoInicial,Sucesores,
	                    TestObjetivo,Coste,Heuristica);
				HillClimbingSearch search = new HillClimbingSearch();
				SearchAgent agent = new SearchAgent(problem, search);
				resultado+=printActions(agent.getActions());
				resultado+="Search Outcome=" + search.getOutcome()+"\n";
				resultado+="Final State=\n" + search.getLastSearchState()+"\n";
				resultado+=printInstrumentation(agent.getInstrumentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return resultado;
	      
	    }

	    private String IDLS() {
	        String resultado = nombre+"\n Iterative DLS -->\n";
	        try {
	            Problem problem = new Problem(EstadoInicial,Sucesores,
	                    TestObjetivo,Coste);
	            Search search = new IterativeDeepeningSearch();
	            SearchAgent agent = new SearchAgent(problem, search);
	            resultado += printActions(agent.getActions());
	            resultado += printInstrumentation(agent.getInstrumentation());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resultado;
	    }

	    private String UniformCost() {
		       	String resultado="\nUniform Cost Search -->";
				try {
					Problem problem = new Problem(EstadoInicial,Sucesores,
		                    TestObjetivo,Coste);
					Search search = new UniformCostSearch(new TreeSearch());
					SearchAgent agent = new SearchAgent(problem, search);
					resultado+=printActions(agent.getActions());
					resultado+=printInstrumentation(agent.getInstrumentation());
				} catch (Exception e) {
					e.printStackTrace();
				}
	            return resultado;
		    }

	    private String GreedyBestFirst() {
	        String resultado = nombre+"\n Greedy Best First Search (Heursitic)-->\n";
	        try {
	            Problem problem = new Problem(EstadoInicial,Sucesores,
	                    TestObjetivo,Heuristica);
	            Search search = new GreedyBestFirstSearch(new GraphSearch());
	            SearchAgent agent = new SearchAgent(problem, search);
	            resultado += printActions(agent.getActions());
	            resultado += printInstrumentation(agent.getInstrumentation());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resultado;
	    }


	    private String AStar() {
	        String resultado = nombre+"\n AStar Search (Heursitic)-->\n";
	        try {
	            Problem problem = new Problem(EstadoInicial,Sucesores,
	                    TestObjetivo,Coste, Heuristica);
	            Search search = new AStarSearch(new GraphSearch());
	            SearchAgent agent = new SearchAgent(problem, search);
	            resultado += printActions(agent.getActions());
	            resultado += printInstrumentation(agent.getInstrumentation());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resultado;
	    }

	    private String SimulatedAnnealing() {
	        String resultado = nombre+"\n Simulated Annealing  Search -->\n";
	        try {
	            Problem problem = new Problem(EstadoInicial,Sucesores,
	                    TestObjetivo,Coste, Heuristica);
	            SimulatedAnnealingSearch search = new SimulatedAnnealingSearch();
	            SearchAgent agent = new SearchAgent(problem, search);
	            resultado += printActions(agent.getActions());
	            resultado += "Search Outcome=" + search.getOutcome() + "\n";
	            resultado += "Final State=\n" + search.getLastSearchState() + "\n";
	            resultado += printInstrumentation(agent.getInstrumentation());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resultado;
	    }


	    private static String printInstrumentation(Properties properties) {
	        Iterator keys = properties.keySet().iterator();
	        String resultado = "";
	        while (keys.hasNext()) {
	            String key = (String) keys.next();
	            String property = properties.getProperty(key);
	            resultado += key + " : " + property + "\n";
	        }


	        return resultado;
	    }

	    private static String printActions(List actions) {

	        String action = "";
	        for (int i = 0; i < actions.size(); i++) {
	            action += (String) actions.get(i) + "\n";

	        }

	        return action;
	    }

}
