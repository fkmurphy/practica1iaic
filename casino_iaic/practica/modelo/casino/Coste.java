package practica.modelo.casino;

import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction{

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		
		Casino desdeCasino = (Casino) fromState;
		Casino haciaCasino = (Casino) toState;
		
		Jugador jugador = desdeCasino.getJugador();
		Zona zonaSiguiente = haciaCasino.getJugador().getZonaActual();
		
		Double apuesta = jugador.dameApuestade(zonaSiguiente).doubleValue();
		return apuesta;
	}

}
