package practica.modelo.casino;

import java.util.ArrayList;
import java.util.List;

import practica.modelo.Log.Log;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		
		Casino casino = (Casino) state;
		List<Successor> successors = new ArrayList<Successor>();
		
		ArrayList<Zona> listaZonaContiguas = casino.getJugador().getZonaActual().getZonasContiguas();
		
		Log.addCasino("El explorador se encuentra en "+casino.getJugador().getZonaActual().dameNombreZona()+" y tiene como zonas cercanas \n");
		
		for (int i=0; i<listaZonaContiguas.size();i++)
		{Zona zonaSucesora = listaZonaContiguas.get(i);
		 Casino casinoSucesor = new Casino(zonaSucesora);
		 
		 Log.addCasino(zonaSucesora.dameNombreZona()+" ");
		 
		 successors.add(new Successor("Me muevo de la zona" +casino.getJugador().getZonaActual().dameNombreZona() +
				 " a la zona de " + zonaSucesora.dameNombreZona() + "que es" + zonaSucesora.getTipoZona().toString()+"",casinoSucesor));
		
		}
		
		Log.addCasino("\n");
		return successors;
	}

}
