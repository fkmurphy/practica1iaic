package practica.modelo.casino;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import practica.Controlador.Controlador;
import practica.modelo.Log.Log;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		/*
		Casino casino = (Casino) state;
		List<Successor> successors = new ArrayList<Successor>();
		
		ArrayList<Zona> listaZonaContiguas = casino.getJugador().getZonaActual().getZonasContiguas();
		
		
		Log.addCasino("El jugador se encuentra en la zona "+casino.getJugador().getZonaActual().dameNombreZona()+" y puede acceder a las puertas de las zonas ");
		this.controlador.vistaMuestraMinijuego("\n");
		this.controlador.vistaMuestraMinijuego("El jugador se encuentra en la zona "+casino.getJugador().getZonaActual().dameNombreZona()+" y puede acceder a las puertas de las zonas ");
		for (int i=0; i<listaZonaContiguas.size();i++)
		{Zona zonaSucesora = listaZonaContiguas.get(i);
		Casino casinoSucesor = new Casino(zonaSucesora);
		//casinoSucesor.getJugador().registerControlador(controlador);
		this.controlador.vistaMuestraMinijuego( zonaSucesora.dameNombreZona()+",");
		Log.addCasino(zonaSucesora.dameNombreZona()+" ");

		successors.add(new Successor("El jugador se mueve de la zona " +casino.getJugador().getZonaActual().dameNombreZona() +
				" a la zona de " + zonaSucesora.dameNombreZona() + "que es" + zonaSucesora.getTipoZona().toString()+"",casinoSucesor));

		// this.controlador.vistaMuestraMinijuego("Me muevo de la zona" +casino.getJugador().getZonaActual().dameNombreZona() + " a la zona de " + zonaSucesora.dameNombreZona() + "que es" + zonaSucesora.getTipoZona().toString()+"");
		}
		this.controlador.vistaMuestraMinijuego("\n");
		Log.addCasino("\n");
		return successors;*/
		
		
		/**
		 * He cambiado esto para que tire con la tabla hash en vez del array (contiguos)
		 */
		
		
		Casino casino = (Casino) state;
		List<Successor> successors = new ArrayList<Successor>();
		
		Hashtable<Zona,Integer> listaZonaContiguas = casino.getJugador().getZonaActual().getZonasContiguasHash();
		
		
		Log.addCasino("El jugador se encuentra en la zona "+casino.getJugador().getZonaActual().dameNombreZona()+" y puede acceder a las puertas de las zonas ");
		this.controlador.vistaMuestraMinijuego("\n");
		this.controlador.vistaMuestraMinijuego("El jugador se encuentra en la zona "+casino.getJugador().getZonaActual().dameNombreZona()+" y puede acceder a las puertas de las zonas ");
		
		Iterator it = listaZonaContiguas.keySet().iterator();
        while (it.hasNext()) {
            Zona zonaSucesora = ((Zona) it.next());
            Casino casinoSucesor = new Casino(zonaSucesora);
            //casinoSucesor.getJugador().registerControlador(controlador);
            this.controlador.vistaMuestraMinijuego( zonaSucesora.dameNombreZona()+",");
            Log.addCasino(zonaSucesora.dameNombreZona()+" ");
            successors.add(new Successor("El jugador se mueve de la zona " +casino.getJugador().getZonaActual().dameNombreZona() +
    				" a la zona de " + zonaSucesora.dameNombreZona() + "que es" + zonaSucesora.getTipoZona().toString()+"",casinoSucesor));
         // this.controlador.vistaMuestraMinijuego("El jugador ha decidido moverse a Me muevo de la zona" +casino.getJugador().getZonaActual().dameNombreZona() + " a la zona de " + zonaSucesora.dameNombreZona() + "que es" + zonaSucesora.getTipoZona().toString()+"");
        }
        
       
		
		this.controlador.vistaMuestraMinijuego("\n");
		Log.addCasino("\n");
		return successors;
		
		
		
	}
	
	public void registerControlador(Controlador controlador)
	{
		this.controlador=controlador;
	}
	
	private Controlador controlador;

}
