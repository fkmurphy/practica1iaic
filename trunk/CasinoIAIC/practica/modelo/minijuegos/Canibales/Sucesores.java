package practica.modelo.minijuegos.Canibales;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores  implements SuccessorFunction{

	public List getSuccessors(Object state) {
		
		List <Successor> listaSucesores = new ArrayList <Successor>();
		
		Canibales canibales = (Canibales) state;
			for (Operadores op : Operadores.values())
				{		EstadoIslaIzq estadoPrecedente = canibales.getEstadoActual();
						if (canibales.movimientoSeguro(op))
						{	
						EstadoIslaIzq estadoSucesor = canibales.aplicaMovimiento(op);	
						Canibales canibalesSuc = new Canibales(estadoSucesor); 
						listaSucesores.add(new Successor("Del estado " + estadoPrecedente.aString() + " al estado " + estadoSucesor.aString(),canibalesSuc));
						}
				}
		
		return listaSucesores;
	}

}
