package practica.modelo.minijuegos.buscarletras;

import java.util.ArrayList;
import java.util.List;


import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		int operadores;
		buscarLetras b =  (buscarLetras)state;
		List<Successor> successors = new ArrayList<Successor>();
	
		for (operadores = 0; operadores <=3; operadores++){
			
			
	           buscarLetras nuevoEstado=b.applyOperator(operadores);
	           if (b.opAplicados())
	           successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	          
	    } 
		
		return successors;
	}

}
