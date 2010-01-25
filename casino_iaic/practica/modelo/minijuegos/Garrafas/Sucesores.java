package practica.modelo.minijuegos.Garrafas;

import java.util.ArrayList;



import java.util.List;



import aima.search.framework.*;


public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		
		int operadores;
		Garrafas g =  (Garrafas)state;
		List<Successor> successors = new ArrayList<Successor>();
		/* Tenemos 6 posibles operadores que debemos almacenar*/
		for (operadores = 0; operadores <=5; operadores++){
			
			
	           Garrafas nuevoEstado=g.Operadores(operadores);
	           
	     
	           
	           successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	          
	    } 
		
		return successors;
	}

}
