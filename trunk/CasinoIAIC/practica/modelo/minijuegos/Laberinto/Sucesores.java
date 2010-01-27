package practica.modelo.minijuegos.Laberinto;

import java.util.ArrayList;

import java.util.List;



import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		int operadores;
		Laberinto g = (Laberinto)state;
		List<Successor> successors = new ArrayList<Successor>();
		
		for (operadores = 0; operadores <=3; operadores++){
			
			
	           Laberinto nuevoEstado=g.Operadores(operadores);
	           if (g.opAplicados())
	           successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	          
	    } 
		
		return successors;
	}

}
