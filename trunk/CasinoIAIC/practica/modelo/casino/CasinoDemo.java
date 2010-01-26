package practica.modelo.casino;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import practica.modelo.GestorModelo;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.uninformed.DepthLimitedSearch;

public class CasinoDemo {
	
	static Casino casino;
	
	
	public static void main(String[] args) {
		micromundoDLSDemo();
	}
	
	private static void micromundoDLSDemo() {

		GestorModelo gestor = new GestorModelo();
		
        casino=gestor.generaCasinoAleatoriodePrueba();

		System.out.println("\nMicroMundo recursive DLS -->");
		try {
			Problem problem = new Problem(casino,
					new Sucesores(),new Objetivo(),new Coste());
			Search search = new DepthLimitedSearch(9);
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


		private static void printInstrumentation(Properties properties) {
			Iterator keys = properties.keySet().iterator();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				String property = properties.getProperty(key);
				System.out.println(key + " : " + property);
			}

		}

		private static void printActions(List actions) {
			for (int i = 0; i < actions.size(); i++) {
				String action = (String) actions.get(i);
				System.out.println(action);
			}
		}

}
