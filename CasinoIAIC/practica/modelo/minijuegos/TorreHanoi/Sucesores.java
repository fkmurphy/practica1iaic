package practica.modelo.minijuegos.TorreHanoi;

import java.util.ArrayList;

import java.util.List;



import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		
		int operadores;
		TorreHannoi m =  (TorreHannoi)state;
		List<Successor> successors = new ArrayList<Successor>();
		for (operadores = 0; operadores <=5; operadores++){
	           TorreHannoi nuevoEstado=m.Operadores(operadores);
	           successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	          
	    } 
		

		
		
		return successors;
	}

}
