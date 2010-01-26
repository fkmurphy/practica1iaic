package practica.modelo.minijuegos.Caballo;

import java.util.ArrayList;

import java.util.List;





import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction {

	public List getSuccessors(Object state) {
        List <Successor> successors = new ArrayList <Successor>();
		
		Caballo c = (Caballo) state;
		int operadores;
		for (operadores = 0; operadores <=7; operadores++){
	           Caballo nuevoEstado=c.applyOperator(operadores);
	           successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	          
	    } 
		return successors;
	}

}
