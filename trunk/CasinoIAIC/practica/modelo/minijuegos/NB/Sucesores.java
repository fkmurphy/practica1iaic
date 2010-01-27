package practica.modelo.minijuegos.NB;

import java.util.ArrayList;



import java.util.List;


import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		
		NB m =  (NB)state;
		List<Successor> successors = new ArrayList<Successor>();
		
		
		for (int i=0; i<=5; i++) {
           
            NB nuevoEstado = m.applyOperator(i);
            if (m.aplOperadores())
            successors.add(new Successor(nuevoEstado.toString(), nuevoEstado));
         }
		
		return successors;

	
	}

}
