package practica.modelo.minijuegos.Palillos;

import java.util.ArrayList;
import java.util.List;


import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		int operadores;
		Palillos m =  (Palillos)state;
		List<Successor> successors = new ArrayList<Successor>();
		String operador = "";
		int turno=m.getTurno();
		int palillos= m.getPalillos();
		for (int i=1; i<=3; i++) {
            if (palillos-i >= 0) {
                    operador = "Se quitan " + i + " palillos";
            Palillos nuevoEstado = new Palillos(palillos-i, turno+1);
            successors.add(new Successor(nuevoEstado.toString(), nuevoEstado));
         }
		}
		return successors;

	
	}

}
