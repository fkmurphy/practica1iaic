package practica.modelo.minijuegos.Puzzle;

import java.util.ArrayList;
import java.util.List;



import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		int operadores;
		Puzzle g =  (Puzzle)state;
		List<Successor> successors = new ArrayList<Successor>();
		/* Tenemos 6 posibles operadores que debemos almacenar*/
		for (operadores = 0; operadores <=3; operadores++){
			
			
	           Puzzle nuevoEstado=g.Operadores(operadores);
	           successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	          
	    } 
		
		return successors;
	}

}
