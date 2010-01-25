package practica.modelo.minijuegos.LoboColCabra;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		
		List<Successor> successors = new ArrayList<Successor>();
		LoboColCabra lobo = (LoboColCabra) state;
		
		for (Operadores op: Operadores.values())
		{
			LoboColCabra loboNuevo = lobo.aplicaOp(op);
			
			if (loboNuevo.esValido())
				successors.add(new Successor(loboNuevo.toString(),loboNuevo));
		}
		
		return successors;
	}

}
